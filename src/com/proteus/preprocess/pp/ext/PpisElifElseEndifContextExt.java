package com.proteus.preprocess.pp.ext;

import org.antlr.v4.runtime.ParserRuleContext;
import lombok.Getter;
import com.proteus.preprocess.p416.PopulateExtendedContextVisitor;
import com.proteus.preprocess.pp.gen.P416PPParser.PpisElifElseEndifContext;

public class PpisElifElseEndifContextExt extends AbstractBaseExt{

	@Getter private PpisElifElseEndifContext ctx;

	public PpisElifElseEndifContextExt(PpisElifElseEndifContext ctx) {
		this.ctx = ctx;
	}

	@Override
	public ParserRuleContext getContext(){
		return ctx;
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).ppisElifElseEndif());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof PpisElifElseEndifContext){
				this.ctx = (PpisElifElseEndifContext) ctx;
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+PpisElifElseEndifContext.class.getName());
			}
		} else {
			this.ctx= null;
		}
	}
}
