package com.proteus.preprocess.pp.ext;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import lombok.Getter;

import com.proteus.preprocess.p416.PopulateExtendedContextVisitor;
import com.proteus.preprocess.p416.runner.PreprocessRunnerSession;
import com.proteus.preprocess.pp.gen.P416PPParser.PpisIfNdefContext;
import com.proteus.preprocess.pp.gen.P416PPParser.StatementContext;

public class PpisIfNdefContextExt extends AbstractBaseExt{

	@Getter private PpisIfNdefContext ctx;

	public PpisIfNdefContextExt(PpisIfNdefContext ctx) {
		this.ctx = ctx;
	}

	@Override
	public ParserRuleContext getContext(){
		return ctx;
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).ppisIfNdef());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof PpisIfNdefContext){
				this.ctx = (PpisIfNdefContext) ctx;
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+PpisIfNdefContext.class.getName());
			}
		} else {
			this.ctx= null;
		}
	}
	
	//ppisIfNdef  :    PREPROCESS_BEGIN    WS*    PREPROCESS_IFNDEF    WS+    ID        WS*    NEWLINE            ppisStatement    ppisElseEndif    ;
	@Override
	public List<StatementContext> preprocessing(PreprocessRunnerSession prs){
		List<StatementContext> statementContexts = new ArrayList<StatementContext>();
		if(ctx != null && ctx.children != null && ctx.children.size()>0){
			if(ctx.ID().getText()!=null){
				String macroName = ctx.ID().getText();
				MacroKey macroKey = new MacroKey();
				macroKey.setMacroName(macroName);
				macroKey.setNoOfParameters(0);
				if(!prs.getMacroMap().containsKey(macroKey)){
					statementContexts = getExtendedContext(ctx.ppisStatement()).preprocessing(prs);
				}
				else {
					statementContexts = getExtendedContext(ctx.ppisElseEndif()).preprocessing(prs);

				}
			}
		}
		return statementContexts;
	}
}
