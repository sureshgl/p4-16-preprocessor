// Generated from P416PPParser.g4 by ANTLR 4.4
package com.proteus.preprocess.pp.gen;

        import com.proteus.preprocess.pp.ext.*;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link P416PPParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface P416PPParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link P416PPParser#ppChars}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPpChars(@NotNull P416PPParser.PpCharsContext ctx);
	/**
	 * Visit a parse tree produced by {@link P416PPParser#ppdfId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPpdfId(@NotNull P416PPParser.PpdfIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link P416PPParser#ppdfiArguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPpdfiArguments(@NotNull P416PPParser.PpdfiArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link P416PPParser#ppdfcNotId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPpdfcNotId(@NotNull P416PPParser.PpdfcNotIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link P416PPParser#ppdfChars}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPpdfChars(@NotNull P416PPParser.PpdfCharsContext ctx);
	/**
	 * Visit a parse tree produced by {@link P416PPParser#ppisElseEndif}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPpisElseEndif(@NotNull P416PPParser.PpisElseEndifContext ctx);
	/**
	 * Visit a parse tree produced by {@link P416PPParser#ppisStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPpisStatement(@NotNull P416PPParser.PpisStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link P416PPParser#ppDefineFunc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPpDefineFunc(@NotNull P416PPParser.PpDefineFuncContext ctx);
	/**
	 * Visit a parse tree produced by {@link P416PPParser#ppdfiArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPpdfiArgument(@NotNull P416PPParser.PpdfiArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link P416PPParser#ppdfcId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPpdfcId(@NotNull P416PPParser.PpdfcIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link P416PPParser#ppChar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPpChar(@NotNull P416PPParser.PpCharContext ctx);
	/**
	 * Visit a parse tree produced by {@link P416PPParser#ppUndef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPpUndef(@NotNull P416PPParser.PpUndefContext ctx);
	/**
	 * Visit a parse tree produced by {@link P416PPParser#ppId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPpId(@NotNull P416PPParser.PpIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link P416PPParser#ppisElifElseEndif}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPpisElifElseEndif(@NotNull P416PPParser.PpisElifElseEndifContext ctx);
	/**
	 * Visit a parse tree produced by {@link P416PPParser#ppisIfNdef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPpisIfNdef(@NotNull P416PPParser.PpisIfNdefContext ctx);
	/**
	 * Visit a parse tree produced by {@link P416PPParser#ppisElif}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPpisElif(@NotNull P416PPParser.PpisElifContext ctx);
	/**
	 * Visit a parse tree produced by {@link P416PPParser#ppisIfDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPpisIfDef(@NotNull P416PPParser.PpisIfDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link P416PPParser#ppisIF}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPpisIF(@NotNull P416PPParser.PpisIFContext ctx);
	/**
	 * Visit a parse tree produced by {@link P416PPParser#ppPragma}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPpPragma(@NotNull P416PPParser.PpPragmaContext ctx);
	/**
	 * Visit a parse tree produced by {@link P416PPParser#ppInclude}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPpInclude(@NotNull P416PPParser.PpIncludeContext ctx);
	/**
	 * Visit a parse tree produced by {@link P416PPParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(@NotNull P416PPParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link P416PPParser#preprocess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreprocess(@NotNull P416PPParser.PreprocessContext ctx);
	/**
	 * Visit a parse tree produced by {@link P416PPParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(@NotNull P416PPParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link P416PPParser#ppisElse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPpisElse(@NotNull P416PPParser.PpisElseContext ctx);
	/**
	 * Visit a parse tree produced by {@link P416PPParser#ppDefineVar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPpDefineVar(@NotNull P416PPParser.PpDefineVarContext ctx);
	/**
	 * Visit a parse tree produced by {@link P416PPParser#ppisEndif}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPpisEndif(@NotNull P416PPParser.PpisEndifContext ctx);
	/**
	 * Visit a parse tree produced by {@link P416PPParser#ppIfStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPpIfStatement(@NotNull P416PPParser.PpIfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link P416PPParser#ppError}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPpError(@NotNull P416PPParser.PpErrorContext ctx);
}