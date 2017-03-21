package com.proteus.preprocess.pp.ext;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import lombok.Getter;

import com.proteus.preprocess.p416.PopulateExtendedContextVisitor;
import com.proteus.preprocess.pp.gen.P416PPParser.PpUndefContext;
import com.proteus.preprocess.pp.gen.P416PPParser.StatementContext;
import com.proteus.preprocess.p416.runner.PreprocessRunnerSession;

public class PpUndefContextExt extends AbstractBaseExt{

	@Getter private PpUndefContext ctx;

	public PpUndefContextExt(PpUndefContext ctx) {
		this.ctx = ctx;
	}

	@Override
	public ParserRuleContext getContext(){
		return ctx;
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).ppUndef());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof PpUndefContext){
				this.ctx = (PpUndefContext) ctx;
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+PpUndefContext.class.getName());
			}
		} else {
			this.ctx= null;
		}
	}
	
	
	//ppUndef  :    PREPROCESS_BEGIN    WS*    PREPROCESS_UNDEF    WS+    ID   WS*    ( NEWLINE | EOF )    ;
	@Override
	public List<StatementContext> preprocessing(PreprocessRunnerSession prs){
		List<StatementContext> statementContexts = new ArrayList<StatementContext>();
		if(ctx != null && ctx.children != null && ctx.children.size()>0){
			MacroKey macroKey = new MacroKey();
			macroKey.setMacroName(ctx.ID().getText());
			macroKey.setNoOfParameters(0);
			prs.getMacroMap().remove(macroKey);
		}
		return statementContexts;
	}
}
