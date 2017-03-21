package com.proteus.preprocess.pp.ext;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import lombok.Getter;

import com.proteus.preprocess.p416.PopulateExtendedContextVisitor;
import com.proteus.preprocess.pp.gen.P416PPParser.StatementContext;
import com.proteus.preprocess.p416.runner.PreprocessRunnerSession;
import com.proteus.preprocess.pp.gen.P416PPParser.PpDefineVarContext;

public class PpDefineVarContextExt extends AbstractBaseExt{

	@Getter private PpDefineVarContext ctx;

	public PpDefineVarContextExt(PpDefineVarContext ctx) {
		this.ctx = ctx;
	}

	@Override
	public ParserRuleContext getContext(){
		return ctx;
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).ppDefineVar());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof PpDefineVarContext){
				this.ctx = (PpDefineVarContext) ctx;
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+PpDefineVarContext.class.getName());
			}
		} else {
			this.ctx= null;
		}
	}
	
//ppDefineVar :   PREPROCESS_BEGIN    WS*    PREPROCESS_DEFINE    WS+    ID        ( WS+    ppChars )?    WS*    ( NEWLINE | EOF )    ;
	
	@Override
	public List<StatementContext> preprocessing(PreprocessRunnerSession prs){
		List<StatementContext> statementContext = new ArrayList<StatementContext>();
		if(ctx != null && ctx.children != null && ctx.children.size()>0){
			Macro macro = new Macro();
			MacroKey macroKey = new MacroKey();
			List<String> listOfParameters = new ArrayList<String>();
			String macroName = ctx.ID().getText();
			macro.setMacroName(macroName);
			if(ctx.ppChars()!=null){
				macro.setMacroDef(" "+ctx.ppChars().extendedContext.getFormattedText()+" ");
			}
			macroKey.setMacroName(macroName);
			macroKey.setNoOfParameters(listOfParameters.size());
			macro.setMacroKey(macroKey);
			if(prs.getMacroMap().containsKey(macroKey)){
				logger.info("macro already exist "+macroKey.getMacroName());
			}
			prs.getMacroMap().put(macroKey, macro);
		}
		return statementContext;
	}
}
