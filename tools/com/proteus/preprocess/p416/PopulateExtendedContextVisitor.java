package com.proteus.preprocess.p416;

import org.antlr.v4.runtime.ParserRuleContext;

import com.proteus.preprocess.pp.ext.*;
import com.proteus.preprocess.pp.gen.P416PPParser;
import com.proteus.preprocess.pp.gen.P416PPParserBaseVisitor;
public class PopulateExtendedContextVisitor extends P416PPParserBaseVisitor<ParserRuleContext>{
	@Override public org.antlr.v4.runtime.ParserRuleContext visitProgram(P416PPParser.ProgramContext ctx) {
		super.visitProgram(ctx);
		ctx.extendedContext = new ProgramContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitStatement(P416PPParser.StatementContext ctx) {
		super.visitStatement(ctx);
		ctx.extendedContext = new StatementContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitPreprocess(P416PPParser.PreprocessContext ctx) {
		super.visitPreprocess(ctx);
		ctx.extendedContext = new PreprocessContextExt(ctx);
		return ctx;
	}
	
	@Override public org.antlr.v4.runtime.ParserRuleContext visitPpId(P416PPParser.PpIdContext ctx) {
		super.visitPpId(ctx);
		ctx.extendedContext = new PpIdContextExt(ctx);
		return ctx;
	}
	
	@Override public org.antlr.v4.runtime.ParserRuleContext visitPpChar(P416PPParser.PpCharContext ctx) {
		super.visitPpChar(ctx);
		ctx.extendedContext = new PpCharContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitPpChars(P416PPParser.PpCharsContext ctx) {
		super.visitPpChars(ctx);
		ctx.extendedContext = new PpCharsContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitPpInclude(P416PPParser.PpIncludeContext ctx) {
		super.visitPpInclude(ctx);
		ctx.extendedContext = new PpIncludeContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitPpPragma(P416PPParser.PpPragmaContext ctx) {
		super.visitPpPragma(ctx);
		ctx.extendedContext = new PpPragmaContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitPpError(P416PPParser.PpErrorContext ctx) {
		super.visitPpError(ctx);
		ctx.extendedContext = new PpErrorContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitPpUndef(P416PPParser.PpUndefContext ctx) {
		super.visitPpUndef(ctx);
		ctx.extendedContext = new PpUndefContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitPpDefineVar(P416PPParser.PpDefineVarContext ctx) {
		super.visitPpDefineVar(ctx);
		ctx.extendedContext = new PpDefineVarContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitPpDefineFunc(P416PPParser.PpDefineFuncContext ctx) {
		super.visitPpDefineFunc(ctx);
		ctx.extendedContext = new PpDefineFuncContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitPpdfId(P416PPParser.PpdfIdContext ctx) {
		super.visitPpdfId(ctx);
		ctx.extendedContext = new PpdfIdContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitPpdfiArguments(P416PPParser.PpdfiArgumentsContext ctx) {
		super.visitPpdfiArguments(ctx);
		ctx.extendedContext = new PpdfiArgumentsContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitPpdfiArgument(P416PPParser.PpdfiArgumentContext ctx) {
		super.visitPpdfiArgument(ctx);
		ctx.extendedContext = new PpdfiArgumentContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitPpdfChars(P416PPParser.PpdfCharsContext ctx) {
		super.visitPpdfChars(ctx);
		ctx.extendedContext = new PpdfCharsContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitPpdfcId(P416PPParser.PpdfcIdContext ctx) {
		super.visitPpdfcId(ctx);
		ctx.extendedContext = new PpdfcIdContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitPpdfcNotId(P416PPParser.PpdfcNotIdContext ctx) {
		super.visitPpdfcNotId(ctx);
		ctx.extendedContext = new PpdfcNotIdContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitPpIfStatement(P416PPParser.PpIfStatementContext ctx) {
		super.visitPpIfStatement(ctx);
		ctx.extendedContext = new PpIfStatementContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitPpisIF(P416PPParser.PpisIFContext ctx) {
		super.visitPpisIF(ctx);
		ctx.extendedContext = new PpisIFContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitPpisElif(P416PPParser.PpisElifContext ctx) {
		super.visitPpisElif(ctx);
		ctx.extendedContext = new PpisElifContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitPpisElse(P416PPParser.PpisElseContext ctx) {
		super.visitPpisElse(ctx);
		ctx.extendedContext = new PpisElseContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitPpisEndif(P416PPParser.PpisEndifContext ctx) {
		super.visitPpisEndif(ctx);
		ctx.extendedContext = new PpisEndifContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitPpisIfDef(P416PPParser.PpisIfDefContext ctx) {
		super.visitPpisIfDef(ctx);
		ctx.extendedContext = new PpisIfDefContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitPpisIfNdef(P416PPParser.PpisIfNdefContext ctx) {
		super.visitPpisIfNdef(ctx);
		ctx.extendedContext = new PpisIfNdefContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitPpisStatement(P416PPParser.PpisStatementContext ctx) {
		super.visitPpisStatement(ctx);
		ctx.extendedContext = new PpisStatementContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitPpisElifElseEndif(P416PPParser.PpisElifElseEndifContext ctx) {
		super.visitPpisElifElseEndif(ctx);
		ctx.extendedContext = new PpisElifElseEndifContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitPpisElseEndif(P416PPParser.PpisElseEndifContext ctx) {
		super.visitPpisElseEndif(ctx);
		ctx.extendedContext = new PpisElseEndifContextExt(ctx);
		return ctx;
	}

}
