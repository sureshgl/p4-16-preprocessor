package com.proteus.preprocess.pp.ext;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import lombok.Getter;

import com.proteus.preprocess.p416.PopulateExtendedContextVisitor;
import com.proteus.preprocess.p416.runner.PreprocessRunnerSession;
import com.proteus.preprocess.pp.gen.P416PPParser.PpisElseContext;
import com.proteus.preprocess.pp.gen.P416PPParser.StatementContext;

public class PpisElseContextExt extends AbstractBaseExt{

	@Getter private PpisElseContext ctx;

	public PpisElseContextExt(PpisElseContext ctx) {
		this.ctx = ctx;
	}

	@Override
	public ParserRuleContext getContext(){
		return ctx;
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).ppisElse());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof PpisElseContext){
				this.ctx = (PpisElseContext) ctx;
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+PpisElseContext.class.getName());
			}
		} else {
			this.ctx= null;
		}
	}
	
	//ppisElse  :    PREPROCESS_BEGIN    WS*    PREPROCESS_ELSE WS*    NEWLINE            ppisStatement    ppisEndif    ;
	
	@Override
	public List<StatementContext> preprocessing(PreprocessRunnerSession prs){
		List<StatementContext> statementContexts = new ArrayList<StatementContext>();
		if(ctx != null && ctx.children != null && ctx.children.size()>0){
			statementContexts = getExtendedContext(ctx.ppisStatement()).preprocessing(prs);
		}
		return statementContexts;
	}
}
