package com.proteus.preprocess.pp.ext;

import org.antlr.v4.runtime.ParserRuleContext;
import lombok.Getter;
import com.proteus.preprocess.p416.PopulateExtendedContextVisitor;
import com.proteus.preprocess.pp.gen.P416PPParser.PpisElseEndifContext;

public class PpisElseEndifContextExt extends AbstractBaseExt{

	@Getter private PpisElseEndifContext ctx;

	public PpisElseEndifContextExt(PpisElseEndifContext ctx) {
		this.ctx = ctx;
	}

	@Override
	public ParserRuleContext getContext(){
		return ctx;
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).ppisElseEndif());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof PpisElseEndifContext){
				this.ctx = (PpisElseEndifContext) ctx;
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+PpisElseEndifContext.class.getName());
			}
		} else {
			this.ctx= null;
		}
	}
}
