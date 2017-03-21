package com.proteus.preprocess.pp.ext;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

import lombok.Getter;

import com.proteus.preprocess.p416.PopulateExtendedContextVisitor;
import com.proteus.preprocess.p416.runner.PreprocessRunnerSession;
import com.proteus.preprocess.pp.gen.P416PPParser.PpCharsContext;
import com.proteus.preprocess.pp.gen.P416PPParser.PreprocessContext;
import com.proteus.preprocess.pp.gen.P416PPParser.StatementContext;

public class StatementContextExt extends AbstractBaseExt{

	@Getter private StatementContext ctx;

	public StatementContextExt(StatementContext ctx) {
		this.ctx = ctx;
	}

	@Override
	public ParserRuleContext getContext(){
		return ctx;
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).statement());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof StatementContext){
				this.ctx = (StatementContext) ctx;
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+StatementContext.class.getName());
			}
		} else {
			this.ctx= null;
		}
	}
	
	public List<StatementContext> preprocessing(PreprocessRunnerSession proteusRunnerSession){
		ParserRuleContext ctx = getContext();
		List<StatementContext> statementContexts = new ArrayList<StatementContext>();
		if(ctx != null && ctx.children != null && ctx.children.size()>0){
			for(ParseTree childCtx : ctx.children){
				if (childCtx instanceof PreprocessContext){
					List<StatementContext> scs  = getExtendedContext(childCtx).preprocessing(proteusRunnerSession);
					if( scs.size()>0){
						statementContexts.addAll(scs);
					}

				}else if(childCtx  instanceof PpCharsContext){
					List<StatementContext> scs  = getExtendedContext(childCtx).preprocessing(proteusRunnerSession);
					if( scs.size()>0){
						statementContexts.addAll(scs);
					}
				}else{
					StatementContext statementContext =  (StatementContext) new PopulateExtendedContextVisitor().visit(getPrimeParser(childCtx.getText()).statement());
					statementContexts.add(statementContext);
				}
			}	
		}
		return statementContexts;
	}

}
