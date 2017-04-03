package com.proteus.preprocess.p416.runner;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import lombok.Data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.proteus.common.util.FileUtils;
import com.proteus.preprocess.pp.ext.Macro;
import com.proteus.preprocess.pp.ext.MacroKey;
import com.proteus.preprocess.pp.gen.P416PPParser.ProgramContext;
import com.proteus.preprocess.pp.gen.P416PPParser.StatementContext;

@Data
public class PreprocessRunnerSession {
	private static final Logger L = LoggerFactory.getLogger(PreprocessRunnerSession.class);

	private File outputDir;
	private List<File> allInputFilesInOrder;
	private File processingFile;
	private HashMap<MacroKey,Macro> macroMap = new HashMap<MacroKey, Macro>();
	private List<StatementContext> statementsContextsList = new ArrayList<StatementContext>();
	//private PreprocessRunnerSession preprocessRunnerSession;


	private  HashMap<File,Boolean> filePreprocessStatusMap = new HashMap<File, Boolean>();

	public PreprocessRunnerSession(File outputDir,List<File> allInputFilesInOrder ,HashMap<MacroKey,Macro> macroMap,File processingFile, HashMap<File,Boolean> filePreprocessStatusMap){
		this.outputDir = outputDir;
		this.allInputFilesInOrder = allInputFilesInOrder;
		this.macroMap = macroMap;
		this.processingFile = processingFile;
		this.filePreprocessStatusMap = filePreprocessStatusMap;
	}

	public ProgramContext preprocess(){
		FileParser fp = new FileParser();
		this.setProcessingFile(this.allInputFilesInOrder.get(0));
		System.out.println(this.getProcessingFile().getName());
		ProgramContext pc = fp.getFileContent(this.getProcessingFile());
		List<StatementContext> statementsContexts = pc.extendedContext.preprocessing(this);
		//String listString = String.join(", ", statementsContexts);
		StringBuilder sb  = new StringBuilder();
		for (StatementContext statementsContext : statementsContexts){
			sb.append(statementsContext.extendedContext.getFormattedText());
		}
		ProgramContext newContext = fp.getStartContext(sb.toString());
		writeToFile(newContext.extendedContext.getFormattedText(),this.getProcessingFile().getName());
		cleanProcessedFile();
		return pc;
	}


	private void cleanProcessedFile(){
		File outputFile = new File(this.getOutputDir()+"/"+this.getProcessingFile().getName());
		File inputFile = new File(this.getOutputDir()+"/"+this.getProcessingFile().getName()+".temp");
		StringBuilder sb = new StringBuilder();
		List<String> lines = FileUtils.ReadLines(inputFile);
		for(int i=0;i<lines.size();i++){
			if(!lines.get(i).trim().isEmpty()){
				sb.append(lines.get(i)+"\n");
			}else if(i<lines.size()-1 && !(lines.get(i+1).trim().isEmpty())){
				sb.append(lines.get(i)+"\n");
			}
		}
		FileUtils.WriteFile(outputFile, sb);
		FileUtils.Delete(inputFile, true);
	}

	private void writeToFile(String processedText,String fileName){
		if(outputDir.exists() || outputDir.mkdirs()){ 
			File preprocessDir = new File(outputDir+"/");
			File processedFile = new File(preprocessDir+"/"+fileName+".temp");
			if(!preprocessDir.exists())
				preprocessDir.deleteOnExit();
				preprocessDir.mkdir();
			FileUtils.AppendToFile(processedFile, processedText);
		}else{
			throw new RuntimeException("Couldn't create OP directory: "+outputDir.getAbsolutePath());
		}
	}

}
