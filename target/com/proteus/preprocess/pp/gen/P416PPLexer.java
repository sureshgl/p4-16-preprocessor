// Generated from P416PPLexer.g4 by ANTLR 4.4
package com.proteus.preprocess.pp.gen;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class P416PPLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COMMENT_BLOCK=1, COMMENT_LINE=2, NL_ESC=3, STRING=4, WS=5, NEWLINE=6, 
		PREPROCESS_BEGIN=7, PREPROCESS_INCLUDE=8, PREPROCESS_DEFINE=9, PREPROCESS_UNDEF=10, 
		PREPROCESS_IFDEF=11, PREPROCESS_IFNDEF=12, PREPROCESS_IF=13, PREPROCESS_ELSE=14, 
		PREPROCESS_ELIF=15, PREPROCESS_ENDIF=16, PREPROCESS_PRAGMA=17, PREPROCESS_ERROR=18, 
		DEFINED=19, ID=20, COMMA=21, PAREN_OPEN=22, PAREN_CLOSE=23, CHAR=24;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'", "'\\u0018'"
	};
	public static final String[] ruleNames = {
		"COMMENT_BLOCK", "COMMENT_LINE", "NL_ESC", "STRING", "WS", "NEWLINE", 
		"PREPROCESS_BEGIN", "PREPROCESS_INCLUDE", "PREPROCESS_DEFINE", "PREPROCESS_UNDEF", 
		"PREPROCESS_IFDEF", "PREPROCESS_IFNDEF", "PREPROCESS_IF", "PREPROCESS_ELSE", 
		"PREPROCESS_ELIF", "PREPROCESS_ENDIF", "PREPROCESS_PRAGMA", "PREPROCESS_ERROR", 
		"DEFINED", "ID", "COMMA", "PAREN_OPEN", "PAREN_CLOSE", "CHAR", "ID_LETTER", 
		"DIGIT", "STRING_ESC", "NL", "NOT_NL"
	};


	public P416PPLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "P416PPLexer.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\32\u00d7\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\3\2\3\2\3\2\3"+
		"\2\7\2B\n\2\f\2\16\2E\13\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\7\3P\n"+
		"\3\f\3\16\3S\13\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\7\5_\n\5\f\5"+
		"\16\5b\13\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17"+
		"\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\7\25\u00b9\n\25\f\25"+
		"\16\25\u00bc\13\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\31\3\31\5"+
		"\31\u00c8\n\31\3\32\3\32\3\33\3\33\3\34\3\34\3\34\3\35\5\35\u00d2\n\35"+
		"\3\35\3\35\3\36\3\36\4C`\2\37\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13"+
		"\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61"+
		"\32\63\2\65\2\67\29\2;\2\3\2\7\4\2\13\13\"\"\5\2C\\aac|\3\2\62;\t\2$$"+
		"\62\62^^ddppttvv\4\2\f\f\17\17\u00d9\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2"+
		"\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23"+
		"\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2"+
		"\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2"+
		"\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\3=\3\2\2\2\5K\3\2\2"+
		"\2\7V\3\2\2\2\t[\3\2\2\2\13e\3\2\2\2\rg\3\2\2\2\17i\3\2\2\2\21k\3\2\2"+
		"\2\23s\3\2\2\2\25z\3\2\2\2\27\u0080\3\2\2\2\31\u0086\3\2\2\2\33\u008d"+
		"\3\2\2\2\35\u0090\3\2\2\2\37\u0095\3\2\2\2!\u009a\3\2\2\2#\u00a0\3\2\2"+
		"\2%\u00a7\3\2\2\2\'\u00ad\3\2\2\2)\u00b5\3\2\2\2+\u00bd\3\2\2\2-\u00bf"+
		"\3\2\2\2/\u00c1\3\2\2\2\61\u00c7\3\2\2\2\63\u00c9\3\2\2\2\65\u00cb\3\2"+
		"\2\2\67\u00cd\3\2\2\29\u00d1\3\2\2\2;\u00d5\3\2\2\2=>\7\61\2\2>?\7,\2"+
		"\2?C\3\2\2\2@B\13\2\2\2A@\3\2\2\2BE\3\2\2\2CD\3\2\2\2CA\3\2\2\2DF\3\2"+
		"\2\2EC\3\2\2\2FG\7,\2\2GH\7\61\2\2HI\3\2\2\2IJ\b\2\2\2J\4\3\2\2\2KL\7"+
		"\61\2\2LM\7\61\2\2MQ\3\2\2\2NP\5;\36\2ON\3\2\2\2PS\3\2\2\2QO\3\2\2\2Q"+
		"R\3\2\2\2RT\3\2\2\2SQ\3\2\2\2TU\b\3\2\2U\6\3\2\2\2VW\7^\2\2WX\59\35\2"+
		"XY\3\2\2\2YZ\b\4\3\2Z\b\3\2\2\2[`\7$\2\2\\_\5\67\34\2]_\13\2\2\2^\\\3"+
		"\2\2\2^]\3\2\2\2_b\3\2\2\2`a\3\2\2\2`^\3\2\2\2ac\3\2\2\2b`\3\2\2\2cd\7"+
		"$\2\2d\n\3\2\2\2ef\t\2\2\2f\f\3\2\2\2gh\59\35\2h\16\3\2\2\2ij\7%\2\2j"+
		"\20\3\2\2\2kl\7k\2\2lm\7p\2\2mn\7e\2\2no\7n\2\2op\7w\2\2pq\7f\2\2qr\7"+
		"g\2\2r\22\3\2\2\2st\7f\2\2tu\7g\2\2uv\7h\2\2vw\7k\2\2wx\7p\2\2xy\7g\2"+
		"\2y\24\3\2\2\2z{\7w\2\2{|\7p\2\2|}\7f\2\2}~\7g\2\2~\177\7h\2\2\177\26"+
		"\3\2\2\2\u0080\u0081\7k\2\2\u0081\u0082\7h\2\2\u0082\u0083\7f\2\2\u0083"+
		"\u0084\7g\2\2\u0084\u0085\7h\2\2\u0085\30\3\2\2\2\u0086\u0087\7k\2\2\u0087"+
		"\u0088\7h\2\2\u0088\u0089\7p\2\2\u0089\u008a\7f\2\2\u008a\u008b\7g\2\2"+
		"\u008b\u008c\7h\2\2\u008c\32\3\2\2\2\u008d\u008e\7k\2\2\u008e\u008f\7"+
		"h\2\2\u008f\34\3\2\2\2\u0090\u0091\7g\2\2\u0091\u0092\7n\2\2\u0092\u0093"+
		"\7u\2\2\u0093\u0094\7g\2\2\u0094\36\3\2\2\2\u0095\u0096\7g\2\2\u0096\u0097"+
		"\7n\2\2\u0097\u0098\7k\2\2\u0098\u0099\7h\2\2\u0099 \3\2\2\2\u009a\u009b"+
		"\7g\2\2\u009b\u009c\7p\2\2\u009c\u009d\7f\2\2\u009d\u009e\7k\2\2\u009e"+
		"\u009f\7h\2\2\u009f\"\3\2\2\2\u00a0\u00a1\7r\2\2\u00a1\u00a2\7t\2\2\u00a2"+
		"\u00a3\7c\2\2\u00a3\u00a4\7i\2\2\u00a4\u00a5\7o\2\2\u00a5\u00a6\7c\2\2"+
		"\u00a6$\3\2\2\2\u00a7\u00a8\7g\2\2\u00a8\u00a9\7t\2\2\u00a9\u00aa\7t\2"+
		"\2\u00aa\u00ab\7q\2\2\u00ab\u00ac\7t\2\2\u00ac&\3\2\2\2\u00ad\u00ae\7"+
		"f\2\2\u00ae\u00af\7g\2\2\u00af\u00b0\7h\2\2\u00b0\u00b1\7k\2\2\u00b1\u00b2"+
		"\7p\2\2\u00b2\u00b3\7g\2\2\u00b3\u00b4\7f\2\2\u00b4(\3\2\2\2\u00b5\u00ba"+
		"\5\63\32\2\u00b6\u00b9\5\63\32\2\u00b7\u00b9\5\65\33\2\u00b8\u00b6\3\2"+
		"\2\2\u00b8\u00b7\3\2\2\2\u00b9\u00bc\3\2\2\2\u00ba\u00b8\3\2\2\2\u00ba"+
		"\u00bb\3\2\2\2\u00bb*\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bd\u00be\7.\2\2\u00be"+
		",\3\2\2\2\u00bf\u00c0\7*\2\2\u00c0.\3\2\2\2\u00c1\u00c2\7+\2\2\u00c2\60"+
		"\3\2\2\2\u00c3\u00c4\7)\2\2\u00c4\u00c5\13\2\2\2\u00c5\u00c8\7)\2\2\u00c6"+
		"\u00c8\13\2\2\2\u00c7\u00c3\3\2\2\2\u00c7\u00c6\3\2\2\2\u00c8\62\3\2\2"+
		"\2\u00c9\u00ca\t\3\2\2\u00ca\64\3\2\2\2\u00cb\u00cc\t\4\2\2\u00cc\66\3"+
		"\2\2\2\u00cd\u00ce\7^\2\2\u00ce\u00cf\t\5\2\2\u00cf8\3\2\2\2\u00d0\u00d2"+
		"\7\17\2\2\u00d1\u00d0\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d3\3\2\2\2"+
		"\u00d3\u00d4\7\f\2\2\u00d4:\3\2\2\2\u00d5\u00d6\n\6\2\2\u00d6<\3\2\2\2"+
		"\13\2CQ^`\u00b8\u00ba\u00c7\u00d1\4\2\3\2\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}