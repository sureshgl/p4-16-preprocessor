package com.proteus.preprocess.pp.ext;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import lombok.Getter;

import com.proteus.preprocess.p416.PopulateExtendedContextVisitor;
import com.proteus.preprocess.pp.gen.P416PPParser.StatementContext;
import com.proteus.preprocess.p416.runner.PreprocessRunnerSession;
import com.proteus.preprocess.pp.gen.P416PPParser.PpisIFContext;

public class PpisIFContextExt extends AbstractBaseExt{

	@Getter private PpisIFContext ctx;

	public PpisIFContextExt(PpisIFContext ctx) {
		this.ctx = ctx;
	}

	@Override
	public ParserRuleContext getContext(){
		return ctx;
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).ppisIF());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof PpisIFContext){
				this.ctx = (PpisIFContext) ctx;
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+PpisIFContext.class.getName());
			}
		} else {
			this.ctx= null;
		}
	}

	//ppChars  :    ( STRING | WS | PREPROCESS_BEGIN | DEFINED | ppId | PREPROCESS_IF | PREPROCESS_ELSE | COMMA | PAREN_OPEN | PAREN_CLOSE | CHAR )+    ;
	//ppisIF  : PREPROCESS_BEGIN WS* PREPROCESS_IF   WS+    ppChars    WS*    NEWLINE ppisStatement    ppisElifElseEndif    ;
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
					statementContexts = getExtendedContextVisitor().visit(ctx.ppisStatement()).preprocessing(prs);
				}
				else {
					statementContexts = getExtendedContextVisitor().visit(ctx.ppisElifElseEndif()).preprocessing(prs);
				}
			}
		}
		return statementContexts;
	}
	
	/*
	ParserRuleContext ctx = getContext();
	List<StatementContext> statementContexts = new ArrayList<StatementContext>();
	if(ctx != null && ctx.children != null && ctx.children.size()>0){
		for(ParseTree childCtx : ctx.children){
			String macroName = null;
			if(childCtx instanceof PpIdContext)  macroName = childCtx.getText();
			else if(childCtx instanceof PpIdCharContext)  macroName = childCtx.getText();
			if(macroName!=null){
				MacroKey macroKey = new MacroKey();
				macroKey.setMacroName(macroName);
				macroKey.setNoOfParameters(0);
				if(prs.getMacroMap().containsKey(macroKey)){
					statementContexts = getExtendedContextVisitor().visit(ctx.ppisStatement()).preprocessing(prs);
				}
				else {
					statementContexts = getExtendedContextVisitor().visit(ctx.ppisElifElseEndif()).preprocessing(prs);
				}
			}
		}	
	}
	return null;
	*/

}
