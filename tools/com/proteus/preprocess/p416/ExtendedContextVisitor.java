package com.proteus.preprocess.p416;

import com.proteus.preprocess.pp.ext.AbstractBaseExt;
import com.proteus.preprocess.pp.gen.P416PPParserBaseVisitor;
import com.proteus.preprocess.pp.gen.P416PPParser;

public class ExtendedContextVisitor extends P416PPParserBaseVisitor<AbstractBaseExt>{
	@Override public AbstractBaseExt visitProgram(P416PPParser.ProgramContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitStatement(P416PPParser.StatementContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitPreprocess(P416PPParser.PreprocessContext ctx) {
		return ctx.extendedContext;
	}
	
	@Override public AbstractBaseExt visitPpId(P416PPParser.PpIdContext ctx) {
		return ctx.extendedContext;
	}
	
	@Override public AbstractBaseExt visitPpChar(P416PPParser.PpCharContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitPpChars(P416PPParser.PpCharsContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitPpInclude(P416PPParser.PpIncludeContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitPpPragma(P416PPParser.PpPragmaContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitPpError(P416PPParser.PpErrorContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitPpUndef(P416PPParser.PpUndefContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitPpDefineVar(P416PPParser.PpDefineVarContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitPpDefineFunc(P416PPParser.PpDefineFuncContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitPpdfId(P416PPParser.PpdfIdContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitPpdfiArguments(P416PPParser.PpdfiArgumentsContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitPpdfiArgument(P416PPParser.PpdfiArgumentContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitPpdfChars(P416PPParser.PpdfCharsContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitPpdfcId(P416PPParser.PpdfcIdContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitPpdfcNotId(P416PPParser.PpdfcNotIdContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitPpIfStatement(P416PPParser.PpIfStatementContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitPpisIF(P416PPParser.PpisIFContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitPpisElif(P416PPParser.PpisElifContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitPpisElse(P416PPParser.PpisElseContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitPpisEndif(P416PPParser.PpisEndifContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitPpisIfDef(P416PPParser.PpisIfDefContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitPpisIfNdef(P416PPParser.PpisIfNdefContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitPpisStatement(P416PPParser.PpisStatementContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitPpisElifElseEndif(P416PPParser.PpisElifElseEndifContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitPpisElseEndif(P416PPParser.PpisElseEndifContext ctx) {
		return ctx.extendedContext;
	}

}
