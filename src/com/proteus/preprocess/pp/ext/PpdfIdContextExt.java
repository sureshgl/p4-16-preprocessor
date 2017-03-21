package com.proteus.preprocess.pp.ext;

import org.antlr.v4.runtime.ParserRuleContext;
import lombok.Getter;
import com.proteus.preprocess.p416.PopulateExtendedContextVisitor;
import com.proteus.preprocess.pp.gen.P416PPParser.PpdfIdContext;

public class PpdfIdContextExt extends AbstractBaseExt{

	@Getter private PpdfIdContext ctx;

	public PpdfIdContextExt(PpdfIdContext ctx) {
		this.ctx = ctx;
	}

	@Override
	public ParserRuleContext getContext(){
		return ctx;
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).ppdfId());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof PpdfIdContext){
				this.ctx = (PpdfIdContext) ctx;
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+PpdfIdContext.class.getName());
			}
		} else {
			this.ctx= null;
		}
	}
}
