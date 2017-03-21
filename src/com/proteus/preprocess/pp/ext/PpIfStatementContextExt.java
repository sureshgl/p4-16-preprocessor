package com.proteus.preprocess.pp.ext;

import org.antlr.v4.runtime.ParserRuleContext;

import lombok.Getter;

import com.proteus.preprocess.p416.PopulateExtendedContextVisitor;
import com.proteus.preprocess.pp.gen.P416PPParser.PpIfStatementContext;

public class PpIfStatementContextExt extends AbstractBaseExt{

	@Getter private PpIfStatementContext ctx;

	public PpIfStatementContextExt(PpIfStatementContext ctx) {
		this.ctx = ctx;
	}

	@Override
	public ParserRuleContext getContext(){
		return ctx;
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).ppIfStatement());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof PpIfStatementContext){
				this.ctx = (PpIfStatementContext) ctx;
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+PpIfStatementContext.class.getName());
			}
		} else {
			this.ctx= null;
		}
	}
	
}
