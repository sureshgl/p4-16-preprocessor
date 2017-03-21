package com.proteus.preprocess.pp.ext;

import org.antlr.v4.runtime.ParserRuleContext;
import lombok.Getter;
import com.proteus.preprocess.p416.PopulateExtendedContextVisitor;
import com.proteus.preprocess.pp.gen.P416PPParser.PpdfiArgumentsContext;

public class PpdfiArgumentsContextExt extends AbstractBaseExt{

	@Getter private PpdfiArgumentsContext ctx;

	public PpdfiArgumentsContextExt(PpdfiArgumentsContext ctx) {
		this.ctx = ctx;
	}

	@Override
	public ParserRuleContext getContext(){
		return ctx;
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).ppdfiArguments());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof PpdfiArgumentsContext){
				this.ctx = (PpdfiArgumentsContext) ctx;
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+PpdfiArgumentsContext.class.getName());
			}
		} else {
			this.ctx= null;
		}
	}
}
