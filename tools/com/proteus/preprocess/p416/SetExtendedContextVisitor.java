package com.proteus.preprocess.p416;

import org.antlr.v4.runtime.ParserRuleContext;
import com.proteus.preprocess.pp.gen.P416PPParser;
import com.proteus.preprocess.pp.gen.P416PPParserBaseVisitor;
import com.proteus.preprocess.pp.ext.*;

public class SetExtendedContextVisitor extends P416PPParserBaseVisitor<ParserRuleContext>{
	private AbstractBaseExt extendedContext;
	public SetExtendedContextVisitor( AbstractBaseExt extendedCtx){
		this.extendedContext = extendedCtx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitProgram(P416PPParser.ProgramContext ctx) {
		if ( extendedContext != null && extendedContext instanceof ProgramContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((ProgramContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitStatement(P416PPParser.StatementContext ctx) {
		if ( extendedContext != null && extendedContext instanceof StatementContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((StatementContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitPreprocess(P416PPParser.PreprocessContext ctx) {
		if ( extendedContext != null && extendedContext instanceof PreprocessContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((PreprocessContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}
	
	@Override public org.antlr.v4.runtime.ParserRuleContext visitPpId(P416PPParser.PpIdContext ctx) {
		if ( extendedContext != null && extendedContext instanceof PpIdContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((PpIdContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}
	
	@Override public org.antlr.v4.runtime.ParserRuleContext visitPpChar(P416PPParser.PpCharContext ctx) {
		if ( extendedContext != null && extendedContext instanceof PpCharContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((PpCharContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}


	@Override public org.antlr.v4.runtime.ParserRuleContext visitPpChars(P416PPParser.PpCharsContext ctx) {
		if ( extendedContext != null && extendedContext instanceof PpCharsContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((PpCharsContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitPpInclude(P416PPParser.PpIncludeContext ctx) {
		if ( extendedContext != null && extendedContext instanceof PpIncludeContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((PpIncludeContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitPpPragma(P416PPParser.PpPragmaContext ctx) {
		if ( extendedContext != null && extendedContext instanceof PpPragmaContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((PpPragmaContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitPpError(P416PPParser.PpErrorContext ctx) {
		if ( extendedContext != null && extendedContext instanceof PpErrorContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((PpErrorContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitPpUndef(P416PPParser.PpUndefContext ctx) {
		if ( extendedContext != null && extendedContext instanceof PpUndefContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((PpUndefContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitPpDefineVar(P416PPParser.PpDefineVarContext ctx) {
		if ( extendedContext != null && extendedContext instanceof PpDefineVarContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((PpDefineVarContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitPpDefineFunc(P416PPParser.PpDefineFuncContext ctx) {
		if ( extendedContext != null && extendedContext instanceof PpDefineFuncContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((PpDefineFuncContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitPpdfId(P416PPParser.PpdfIdContext ctx) {
		if ( extendedContext != null && extendedContext instanceof PpdfIdContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((PpdfIdContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitPpdfiArguments(P416PPParser.PpdfiArgumentsContext ctx) {
		if ( extendedContext != null && extendedContext instanceof PpdfiArgumentsContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((PpdfiArgumentsContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitPpdfiArgument(P416PPParser.PpdfiArgumentContext ctx) {
		if ( extendedContext != null && extendedContext instanceof PpdfiArgumentContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((PpdfiArgumentContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitPpdfChars(P416PPParser.PpdfCharsContext ctx) {
		if ( extendedContext != null && extendedContext instanceof PpdfCharsContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((PpdfCharsContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitPpdfcId(P416PPParser.PpdfcIdContext ctx) {
		if ( extendedContext != null && extendedContext instanceof PpdfcIdContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((PpdfcIdContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitPpdfcNotId(P416PPParser.PpdfcNotIdContext ctx) {
		if ( extendedContext != null && extendedContext instanceof PpdfcNotIdContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((PpdfcNotIdContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitPpIfStatement(P416PPParser.PpIfStatementContext ctx) {
		if ( extendedContext != null && extendedContext instanceof PpIfStatementContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((PpIfStatementContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitPpisIF(P416PPParser.PpisIFContext ctx) {
		if ( extendedContext != null && extendedContext instanceof PpisIFContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((PpisIFContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitPpisElif(P416PPParser.PpisElifContext ctx) {
		if ( extendedContext != null && extendedContext instanceof PpisElifContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((PpisElifContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitPpisElse(P416PPParser.PpisElseContext ctx) {
		if ( extendedContext != null && extendedContext instanceof PpisElseContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((PpisElseContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitPpisEndif(P416PPParser.PpisEndifContext ctx) {
		if ( extendedContext != null && extendedContext instanceof PpisEndifContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((PpisEndifContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitPpisIfDef(P416PPParser.PpisIfDefContext ctx) {
		if ( extendedContext != null && extendedContext instanceof PpisIfDefContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((PpisIfDefContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitPpisIfNdef(P416PPParser.PpisIfNdefContext ctx) {
		if ( extendedContext != null && extendedContext instanceof PpisIfNdefContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((PpisIfNdefContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitPpisStatement(P416PPParser.PpisStatementContext ctx) {
		if ( extendedContext != null && extendedContext instanceof PpisStatementContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((PpisStatementContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitPpisElifElseEndif(P416PPParser.PpisElifElseEndifContext ctx) {
		if ( extendedContext != null && extendedContext instanceof PpisElifElseEndifContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((PpisElifElseEndifContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitPpisElseEndif(P416PPParser.PpisElseEndifContext ctx) {
		if ( extendedContext != null && extendedContext instanceof PpisElseEndifContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((PpisElseEndifContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

}
