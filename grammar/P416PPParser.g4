parser grammar P416PPParser;
options {
	tokenVocab=P416PPLexer;
}
// parser rules must start with lower case.

@header{
        import com.proteus.preprocess.pp.ext.*;
}


program locals [ ProgramContextExt extendedContext ] :    statement*    EOF    ;

statement locals [ StatementContextExt extendedContext ] :    preprocess
            |    ( COMMENT_BLOCK | COMMENT_LINE )
            |    STRING                        // ignore
            |    ( ppChars | NEWLINE )        // ignore
            ;

// pp means preprocess
preprocess locals [ PreprocessContextExt extendedContext ] :    ppInclude
            |    ppDefineFunc    // this must be before ppDefineVar: eg. #define AAA  ( a )  
            |    ppDefineVar
            |    ppUndef
            |    ppPragma
            |    ppError
            |    ppIfStatement
            ;

ppId locals [ PpIdContextExt extendedContext ] : ID ;
ppChar locals [ PpCharContextExt extendedContext ] : CHAR ;
ppChars locals [ PpCharsContextExt extendedContext ] :    ( STRING | WS | PREPROCESS_BEGIN | DEFINED | ppId | PREPROCESS_ERROR | PREPROCESS_IF | PREPROCESS_ELSE | COMMA | PAREN_OPEN | PAREN_CLOSE | ppChar )+    ;

ppInclude locals [ PpIncludeContextExt extendedContext ] :    PREPROCESS_BEGIN    WS*    PREPROCESS_INCLUDE    WS*    ppChars    WS*    ( NEWLINE | EOF )    ;
ppPragma locals [ PpPragmaContextExt extendedContext ] :    PREPROCESS_BEGIN    WS*    PREPROCESS_PRAGMA    WS*    ppChars    WS*    ( NEWLINE | EOF )    ;
ppError locals [ PpErrorContextExt extendedContext ] :    PREPROCESS_BEGIN    WS*    PREPROCESS_ERROR    WS*    ppChars    WS*    ( NEWLINE | EOF )    ;

ppUndef locals [ PpUndefContextExt extendedContext ] :    PREPROCESS_BEGIN    WS*    PREPROCESS_UNDEF    WS+    ID                            WS*    ( NEWLINE | EOF )    ;
ppDefineVar locals [ PpDefineVarContextExt extendedContext ] :    PREPROCESS_BEGIN    WS*    PREPROCESS_DEFINE    WS+    ID        ( WS+    ppChars )?    WS*    ( NEWLINE | EOF )    ;
ppDefineFunc locals [ PpDefineFuncContextExt extendedContext ] :    PREPROCESS_BEGIN    WS*    PREPROCESS_DEFINE    WS+    ppdfId    WS*    ppdfChars        WS*    ( NEWLINE | EOF )    ;

// ppdfi means preprocess define function ID
ppdfId locals [ PpdfIdContextExt extendedContext ] : ID PAREN_OPEN    WS*    ppdfiArguments    WS*    PAREN_CLOSE    ;    // WS between ID and '(' is not allowed.
ppdfiArguments locals [ PpdfiArgumentsContextExt extendedContext ] : ppdfiArgument    ( WS*    COMMA    WS*    ppdfiArgument    )*    ;    // at least 1 argument is required.
ppdfiArgument locals [ PpdfiArgumentContextExt extendedContext ] : ID    ;

// ppdfc means preprocess define function characters
ppdfChars locals [ PpdfCharsContextExt extendedContext ] : ( ppdfcId | ppdfcNotId )+    ;
ppdfcId locals [ PpdfcIdContextExt extendedContext ] :    ID    ;
ppdfcNotId locals [ PpdfcNotIdContextExt extendedContext ] : ( STRING | WS | PREPROCESS_BEGIN | DEFINED | COMMA | PAREN_OPEN | PAREN_CLOSE | CHAR )    ;

ppIfStatement locals [ PpIfStatementContextExt extendedContext ] : ( ppisIF | ppisIfDef | ppisIfNdef ) ;

ppisIF locals [ PpisIFContextExt extendedContext ] :    PREPROCESS_BEGIN    WS*    PREPROCESS_IF        WS+    ppChars    WS*    NEWLINE            ppisStatement    ppisElifElseEndif    ;
ppisElif locals [ PpisElifContextExt extendedContext ] :    PREPROCESS_BEGIN    WS*    PREPROCESS_ELIF        WS+    ppChars    WS*    NEWLINE            ppisStatement    ppisElifElseEndif    ;
ppisElse locals [ PpisElseContextExt extendedContext ] :    PREPROCESS_BEGIN    WS*    PREPROCESS_ELSE                    WS*    NEWLINE            ppisStatement    ppisEndif    ;
ppisEndif locals [ PpisEndifContextExt extendedContext ] :    PREPROCESS_BEGIN    WS*    PREPROCESS_ENDIF                WS*    (NEWLINE|EOF)    ;
ppisIfDef locals [ PpisIfDefContextExt extendedContext ] :    PREPROCESS_BEGIN    WS*    PREPROCESS_IFDEF    WS+    ID        WS*    NEWLINE            ppisStatement    ppisElseEndif    ;
ppisIfNdef locals [ PpisIfNdefContextExt extendedContext ] :    PREPROCESS_BEGIN    WS*    PREPROCESS_IFNDEF    WS+    ID        WS*    NEWLINE            ppisStatement    ppisElseEndif    ;

ppisStatement locals [ PpisStatementContextExt extendedContext ] : statement* ;
ppisElifElseEndif locals [ PpisElifElseEndifContextExt extendedContext ] : ppisElif | ppisElseEndif ;
ppisElseEndif locals [ PpisElseEndifContextExt extendedContext ] : ppisElse | ppisEndif ;
