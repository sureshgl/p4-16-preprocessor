package com.proteus.preprocess.pp.ext;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

import lombok.Getter;

import com.proteus.preprocess.p416.PopulateExtendedContextVisitor;
import com.proteus.preprocess.p416.runner.FileParser;
import com.proteus.preprocess.p416.runner.PreprocessRunnerSession;
import com.proteus.preprocess.pp.gen.P416PPParser.PpCharsContext;
import com.proteus.preprocess.pp.gen.P416PPParser.PpIdContext;
import com.proteus.preprocess.pp.gen.P416PPParser.ProgramContext;
import com.proteus.preprocess.pp.gen.P416PPParser.StatementContext;

public class PpCharsContextExt extends AbstractBaseExt{

	@Getter private PpCharsContext ctx;

	public PpCharsContextExt(PpCharsContext ctx) {
		this.ctx = ctx;
	}

	@Override
	public ParserRuleContext getContext(){
		return ctx;
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).ppChars());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof PpCharsContext){
				this.ctx = (PpCharsContext) ctx;
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+PpCharsContext.class.getName());
			}
		} else {
			this.ctx= null;
		}
	}

	//ppChars  :    ( STRING | WS | PREPROCESS_BEGIN | DEFINED | ID | PREPROCESS_ERROR | PREPROCESS_IF | PREPROCESS_ELSE | COMMA | PAREN_OPEN | PAREN_CLOSE | CHAR )+    ;
	@Override
	public List<StatementContext> preprocessing(PreprocessRunnerSession prs){
		ParserRuleContext ctx = getContext();
		List<StatementContext> statementContexts = new ArrayList<StatementContext>();
		if(ctx != null && ctx.children != null && ctx.children.size()>0){
			for(ParseTree childCtx : ctx.children){
				if(childCtx instanceof PpIdContext){
					String macroName = childCtx.getText();
					MacroKey macroKey = new MacroKey();
					macroKey.setMacroName(macroName);
					macroKey.setNoOfParameters(0);
					if(prs.getMacroMap().containsKey(macroKey)){
						FileParser fp = new FileParser();
						ProgramContext pc = fp.getStartContext(prs.getMacroMap().get(macroKey).getMacroDef());
						List<StatementContext> scs = pc.extendedContext.preprocessing(prs);
						statementContexts.addAll(scs);
					}else{
						StatementContext statementContext =  (StatementContext) new PopulateExtendedContextVisitor().visit(getPrimeParser(childCtx.getText()).statement());
						statementContexts.add(statementContext);
					}
				}else{
					StatementContext statementContext =  (StatementContext) new PopulateExtendedContextVisitor().visit(getPrimeParser(childCtx.getText()).statement());
					statementContexts.add(statementContext);
				}
			}
		}
		return statementContexts;
	}

}
