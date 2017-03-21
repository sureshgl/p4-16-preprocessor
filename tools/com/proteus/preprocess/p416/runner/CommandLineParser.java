package com.proteus.preprocess.p416.runner;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.Data;
import lombok.Getter;

import com.beust.jcommander.IStringConverter;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.proteus.preprocess.InvalidOptionException;
import com.proteus.preprocess.pp.ext.Macro;
import com.proteus.preprocess.pp.ext.MacroKey;
@Data
public class CommandLineParser implements ICommandLineParser{
	private static final Logger L = LoggerFactory.getLogger(CommandLineParser.class);
	@Parameter()
	private List<String> parameters;

	@Parameter(names = {"-o","-output"}, description="Output file name", converter=FileNameConverter.class,required=true)
	File outputFile;

	public File getOutputDir(){
		if(outputFile.getParentFile()==null)
			return new File(".");
		return outputFile.getParentFile();
	} 

	private File designFile;

	@Getter
	public static List<File> inputFilesInOrder = new ArrayList<File>();

	@Parameter(names = "-help",help=true,description="Produces this Output")
	private boolean help; 

	public static class FileNameConverter implements IStringConverter<File>{
		@Override
		public File convert(String value) {
			return new File(value);
		}

	}

	public final Integer MAX_FILES_COUNT =1000;
	@Getter
	private Path sourceFile;
	private Path basePath;
	private List<CommandLineParser> children;
	private static Map<String,String> macroMap = new HashMap<String,String>();

	private boolean CompletedprocessingAllFOptionFiles;

	public CommandLineParser(String path) throws InvalidOptionException{
		children = new ArrayList<CommandLineParser>();
		sourceFile = FileSystems.getDefault().getPath(path).normalize();
		if ( !sourceFile.toFile().exists()){
			throw new InvalidOptionException(basePath.toString());
		}
		if ( sourceFile.toFile().isDirectory() ){
			basePath = sourceFile;
			sourceFile = null;
		}
		else{
			basePath = sourceFile.getParent();
		}
		parameters = new ArrayList<String>();
	}


	private Path getNormalizedPath(String path){
		return basePath.resolve(path).normalize();
	}

	private void processMacroDefinitions(){
		List<String> params = new ArrayList<String>();
		for(String param : parameters)
		{
			if(param.startsWith("+"))
			{
				String[] keyValue = null;
				if ( param.startsWith("+define+")){
					keyValue  = param.substring("+define+".length(), param.length()).split("=");
				}
				else
				{
					keyValue  = param.substring(1, param.length()).split("=");
				}

				macroMap.put(keyValue[0],keyValue[1]);
				params.add(param);
			}
		}
		for( String param : params)
		{
			parameters.remove(param);
		}
	}


	public HashMap<MacroKey,Macro> getMacroDefinitions()
	{
		HashMap<MacroKey,Macro> tempMacroMap = new HashMap<MacroKey, Macro>();
		for(String macroid : macroMap.keySet()){
			Macro macro = new Macro();
			MacroKey macrokey = new MacroKey();
			macrokey.setMacroName(macroid);
			macrokey.setNoOfParameters(null);
			macro.setMacroName(macroid);
			macro.setListOfParameters(null);
			macro.setMacroKey(macrokey);
			macro.setMacroDef(macroMap.get(macroid));
		    tempMacroMap.put(macrokey, macro);
		}
		return tempMacroMap;
	}
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("parameters=\n");
		for(String param:parameters)
		{
			sb.append("\t"+param+"\n");
		}
		sb.append("includeFileList=\n");
		return sb.toString();
	}

	private void processParametersForIncludedFiles()
	{
		List<String> removedEntries = new ArrayList<String>();
		for(String param: parameters)
		{
			Path normalizedPath = getNormalizedPath(param);
			inputFilesInOrder.add(normalizedPath.toFile());
		}
		for(String param: removedEntries)
		{
			parameters.remove(param);
		}
	}
	
	public static void main(String[] args) {


		Path basePath = FileSystems.getDefault().getPath("/");

		CommandLineParser clp = new CommandLineParser(new File("./").getAbsolutePath());
		try{
			System.out.println(System.setProperty(JCommander.DEBUG_PROPERTY,"debug"));
			//		JCommander jCommander = new JCommander(clp, args);
			JCommander jCommander = new JCommander(clp);
			jCommander.parse(args);
			System.out.println("Command="+jCommander.getParsedCommand());

		}
		catch(ParameterException ex)
		{
			System.out.println(ex.getMessage());
		}
		System.out.println(clp);
	}


	@Override
	public void processArgs() throws FileNotFoundException {
		processMacroDefinitions();
		processParametersForIncludedFiles();
		
	}

}
