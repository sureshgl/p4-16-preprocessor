package com.proteus.preprocess.antlr4;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import com.proteus.preprocess.ANTLRv4.gen.ANTLRv4Lexer;
import com.proteus.preprocess.ANTLRv4.gen.ANTLRv4Parser;
import com.proteus.preprocess.ANTLRv4.gen.ANTLRv4ParserBaseListener;
@Data
@EqualsAndHashCode(callSuper=true)
public class Antlr4Reflection extends ANTLRv4ParserBaseListener{
	
	public static interface RuleType{
		public boolean isAlt();
	}
	
	@Data
	@AllArgsConstructor
	public static class RuleNormal implements RuleType{
		private final String ruleName;
		private final String ruleBody;
		@Override
		public boolean isAlt() {
			return false;
		}
	}
	@Data
	public static class RuleAlt implements RuleType{
		private final String altName;
		private final String altText;
		private final RuleNormal parentRule;
		@Override
		public boolean isAlt() {
			return true;
		}
	}
	
	private static String getActualContent(ParserRuleContext ctx, CharStream c){
		int a = ctx.start.getStartIndex();
	    int b = ctx.stop.getStopIndex();
	    return c.getText(new Interval(a, b));
	}
	
	private static CharStream cs;

	private static Map<String,RuleType> rules = new LinkedHashMap<>();
	
	@Override 
	public void enterParserRuleSpec(@NotNull ANTLRv4Parser.ParserRuleSpecContext ctx) { 
		String parserRuleName = ctx.RULE_REF().getText();
	    String ruleBody=getActualContent(ctx, cs);
	    rules.put(parserRuleName, new RuleNormal(parserRuleName, ruleBody));
	    
	}
	@Override
	public void enterLabeledAlt(@NotNull ANTLRv4Parser.LabeledAltContext ctx){
		if(ctx.children.size()>1){// This is a 
			String altName = ctx.getChild(2).getText();
			String RuleName = ctx.parent.parent.parent.getChild(0).getText();
			rules.put(altName,new RuleAlt(altName, getActualContent(ctx, cs), (RuleNormal) rules.get(RuleName)));
		}
		
	}
	
	private static void resetMap(){
		rules=new LinkedHashMap<>();
	}
	
	public static synchronized Map<String, RuleType> getParserRules(String filename) throws IOException {
		resetMap();
		InputStream ip = new FileInputStream(filename);
		cs = new ANTLRInputStream(ip);
		ANTLRv4Lexer lexer = new ANTLRv4Lexer(cs);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		ANTLRv4Parser parser = new ANTLRv4Parser(tokens);
		
		ParserRuleContext tree = parser.grammarSpec();
		
		ParseTreeWalker walker  = new ParseTreeWalker();
		
		Antlr4Reflection sr = new Antlr4Reflection();
		
		walker.walk(sr, tree);
		return rules;
	}
	
	public static void main(String[] args) throws IOException {
		getParserRules("grammar/Verilog.g4");
	}
}
