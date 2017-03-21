package com.proteus.preprocess.pp.ext;

import org.antlr.v4.runtime.ParserRuleContext;
import lombok.Getter;
import com.proteus.preprocess.p416.PopulateExtendedContextVisitor;
import com.proteus.preprocess.pp.gen.P416PPParser.PpdfiArgumentContext;

public class PpdfiArgumentContextExt extends AbstractBaseExt{

	@Getter private PpdfiArgumentContext ctx;

	public PpdfiArgumentContextExt(PpdfiArgumentContext ctx) {
		this.ctx = ctx;
	}

	@Override
	public ParserRuleContext getContext(){
		return ctx;
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).ppdfiArgument());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof PpdfiArgumentContext){
				this.ctx = (PpdfiArgumentContext) ctx;
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+PpdfiArgumentContext.class.getName());
			}
		} else {
			this.ctx= null;
		}
	}
}
