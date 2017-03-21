package com.proteus.preprocess.pp.ext;

import org.antlr.v4.runtime.ParserRuleContext;

import lombok.Getter;

import com.proteus.preprocess.p416.PopulateExtendedContextVisitor;
import com.proteus.preprocess.pp.gen.P416PPParser.ProgramContext;

public class ProgramContextExt extends AbstractBaseExt{

	@Getter private ProgramContext ctx;

	public ProgramContextExt(ProgramContext ctx) {
		this.ctx = ctx;
	}

	@Override
	public ParserRuleContext getContext(){
		return ctx;
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).program());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof ProgramContext){
				this.ctx = (ProgramContext) ctx;
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+ProgramContext.class.getName());
			}
		} else {
			this.ctx= null;
		}
	}
	
}
