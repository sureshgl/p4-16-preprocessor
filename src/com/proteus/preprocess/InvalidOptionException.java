package com.proteus.preprocess;

import com.beust.jcommander.ParameterException;

public class InvalidOptionException extends ParameterException {

	public InvalidOptionException(String file) 
	{
		super(file + " does not exists or is not a directory");
	}

}
