package com.proteus.preprocess.pp.ext;

import org.antlr.v4.runtime.ParserRuleContext;
import lombok.Getter;
import com.proteus.preprocess.p416.PopulateExtendedContextVisitor;
import com.proteus.preprocess.pp.gen.P416PPParser.PpisEndifContext;

public class PpisEndifContextExt extends AbstractBaseExt{

	@Getter private PpisEndifContext ctx;

	public PpisEndifContextExt(PpisEndifContext ctx) {
		this.ctx = ctx;
	}

	@Override
	public ParserRuleContext getContext(){
		return ctx;
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).ppisEndif());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof PpisEndifContext){
				this.ctx = (PpisEndifContext) ctx;
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+PpisEndifContext.class.getName());
			}
		} else {
			this.ctx= null;
		}
	}
}
