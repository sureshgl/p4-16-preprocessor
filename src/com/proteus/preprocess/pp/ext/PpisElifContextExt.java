package com.proteus.preprocess.pp.ext;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import lombok.Getter;

import com.proteus.preprocess.p416.PopulateExtendedContextVisitor;
import com.proteus.preprocess.p416.runner.PreprocessRunnerSession;
import com.proteus.preprocess.pp.gen.P416PPParser.PpisElifContext;
import com.proteus.preprocess.pp.gen.P416PPParser.StatementContext;

public class PpisElifContextExt extends AbstractBaseExt{

	@Getter private PpisElifContext ctx;

	public PpisElifContextExt(PpisElifContext ctx) {
		this.ctx = ctx;
	}

	@Override
	public ParserRuleContext getContext(){
		return ctx;
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).ppisElif());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof PpisElifContext){
				this.ctx = (PpisElifContext) ctx;
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+PpisElifContext.class.getName());
			}
		} else {
			this.ctx= null;
		}
	}
	
	
	//ppisElif :    PREPROCESS_BEGIN    WS*    PREPROCESS_ELIF        WS+    ppChars    WS*    NEWLINE   ppisStatement    ppisElifElseEndif    ;
	@Override
	public List<StatementContext> preprocessing(PreprocessRunnerSession prs){
		List<StatementContext> statementContexts = new ArrayList<StatementContext>();
		if(ctx != null && ctx.children != null && ctx.children.size()>0){
			String macroName = null;
			if(ctx.ppChars().ppId()!=null && ctx.ppChars().ppId().size()>0)  macroName = ctx.ppChars().ppId().get(0).getText();
			else if(ctx.ppChars().ppChar()!=null && ctx.ppChars().ppChar().size()>0)  macroName = ctx.ppChars().ppChar().get(0).getText();
			if(macroName!=null){
				MacroKey macroKey = new MacroKey();
				macroKey.setMacroName(macroName);
				macroKey.setNoOfParameters(0);
				if(prs.getMacroMap().containsKey(macroKey)){
					statementContexts = getExtendedContext(ctx.ppisStatement()).preprocessing(prs);
				}
				else {
					statementContexts = getExtendedContextVisitor().visit(ctx.ppisElifElseEndif()).preprocessing(prs);
				}
			}
		}
		return statementContexts;
	}
}
