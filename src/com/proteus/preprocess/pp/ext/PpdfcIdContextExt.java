package com.proteus.preprocess.pp.ext;

import org.antlr.v4.runtime.ParserRuleContext;
import lombok.Getter;
import com.proteus.preprocess.p416.PopulateExtendedContextVisitor;
import com.proteus.preprocess.pp.gen.P416PPParser.PpdfcIdContext;

public class PpdfcIdContextExt extends AbstractBaseExt{

	@Getter private PpdfcIdContext ctx;

	public PpdfcIdContextExt(PpdfcIdContext ctx) {
		this.ctx = ctx;
	}

	@Override
	public ParserRuleContext getContext(){
		return ctx;
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).ppdfcId());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof PpdfcIdContext){
				this.ctx = (PpdfcIdContext) ctx;
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+PpdfcIdContext.class.getName());
			}
		} else {
			this.ctx= null;
		}
	}
}
