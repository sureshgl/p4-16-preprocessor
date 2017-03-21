package com.proteus.preprocess.pp.ext;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import lombok.Getter;

import com.proteus.preprocess.p416.PopulateExtendedContextVisitor;
import com.proteus.preprocess.pp.gen.P416PPParser.PpCharsContext;
import com.proteus.preprocess.pp.gen.P416PPParser.PpIncludeContext;
import com.proteus.preprocess.pp.gen.P416PPParser.ProgramContext;
import com.proteus.preprocess.pp.gen.P416PPParser.StatementContext;
import com.proteus.preprocess.p416.runner.FileParser;
import com.proteus.preprocess.p416.runner.PreprocessRunnerSession;

public class PpIncludeContextExt extends AbstractBaseExt{

	@Getter private PpIncludeContext ctx;

	public PpIncludeContextExt(PpIncludeContext ctx) {
		this.ctx = ctx;
	}

	@Override
	public ParserRuleContext getContext(){
		return ctx;
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).ppInclude());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof PpIncludeContext){
				this.ctx = (PpIncludeContext) ctx;
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+PpIncludeContext.class.getName());
			}
		} else {
			this.ctx= null;
		}
	}
	
	//ppInclude locals [ PpIncludeContextExt extendedContext ] :    PREPROCESS_BEGIN    WS*    PREPROCESS_INCLUDE    WS*    ppChars    WS*    ( NEWLINE | EOF )    ;
	
	@Override
	public List<StatementContext> preprocessing(PreprocessRunnerSession prs){
		List<StatementContext> statementContexts = new ArrayList<StatementContext>();
		if(ctx != null && ctx.children != null && ctx.children.size()>0){
			if(ctx.getChild(3) instanceof PpCharsContext){
				if(ctx.ppChars()!=null && ctx.ppChars().getText().length()>0){
					File f= new File(prs.getProcessingFile().getParent(), ctx.ppChars().getText().substring(1, ctx.ppChars().getText().length()-1));
					if(f.exists()){
						FileParser fp = new FileParser();
						ProgramContext pc = fp.getFileContent(f);
						statementContexts = pc.extendedContext.preprocessing(prs);
					}else{
						logger.error("inlucded file is not found "+ ctx.getText());
					}
				}
			}
		}
		return statementContexts;
	}
}
