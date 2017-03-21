package com.proteus.preprocess.p416.runner;

import java.io.File;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.beust.jcommander.JCommander;
import com.proteus.common.util.Utils;

public class PreprocessRunner {

	private static final Logger L = LoggerFactory.getLogger(PreprocessRunner.class);
	private static JCommander jc = null;
	private static CommandLineParser cp = new CommandLineParser(new File("./").getAbsolutePath());

	public static void main(String[] args) {
		L.info("Launching Verilog Parser Runner");
		runVerilogParserRunner(args, true);
	}

	public static void printHelp(JCommander jac){
		jac.usage();
	}

	public static void runVerilogParserRunner(String[] args, boolean systemExitOnException){
		try{
			jc = new JCommander(cp);
			jc.setProgramName("proteus");
			jc.parse(args);
			cp.processArgs();
			if(cp.isHelp()){
				printHelp(jc);
				System.exit(0);
			}
		}catch(Throwable t){
			printHelp(jc);
			takeCareOfError("Error parsing Arguments",t, systemExitOnException);
		}
		try{
			HashMap<File,Boolean> filePreprocessStatusMap = new HashMap<File, Boolean>();
			PreprocessRunnerSession session = new PreprocessRunnerSession(cp.getOutputFile(), cp.getInputFilesInOrder() , cp.getMacroDefinitions(), null,filePreprocessStatusMap);
			session.preprocess();
			L.info("Done");
		}catch(Throwable t){
			t.printStackTrace();
			takeCareOfError("Error Running Proteus Session", t, systemExitOnException);
		}
	}

	public static void takeCareOfError(String externalErrorMsg, Throwable t, boolean systemExitOnException) {
		L.error(externalErrorMsg + ": " + Utils.getRootCauseUserDisplayString(t));
		takeCareOfError(new RuntimeException(externalErrorMsg, t), systemExitOnException);
	}

	private static void takeCareOfError(Throwable t, boolean systemExitOnException) {
		if (systemExitOnException)
			System.exit(1);
		else
			throw new RuntimeException(t);
	}

}
