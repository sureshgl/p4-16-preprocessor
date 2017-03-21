package com.proteus.preprocess.pp.ext;

import org.antlr.v4.runtime.ParserRuleContext;
import lombok.Getter;
import com.proteus.preprocess.p416.PopulateExtendedContextVisitor;
import com.proteus.preprocess.pp.gen.P416PPParser.PpdfcNotIdContext;

public class PpdfcNotIdContextExt extends AbstractBaseExt{

	@Getter private PpdfcNotIdContext ctx;

	public PpdfcNotIdContextExt(PpdfcNotIdContext ctx) {
		this.ctx = ctx;
	}

	@Override
	public ParserRuleContext getContext(){
		return ctx;
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).ppdfcNotId());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof PpdfcNotIdContext){
				this.ctx = (PpdfcNotIdContext) ctx;
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+PpdfcNotIdContext.class.getName());
			}
		} else {
			this.ctx= null;
		}
	}
}
