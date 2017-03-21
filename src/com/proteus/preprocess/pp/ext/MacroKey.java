package com.proteus.preprocess.pp.ext;

import lombok.Data;

@Data
public class MacroKey {

	public String macroName;
	public Integer noOfParameters;


	@Override public int hashCode(){ 
		return noOfParameters;
	}
	@Override 
	public boolean equals(Object obj){
		if(this == obj)
			return true; 
		if(obj == null || this==null || (this.getClass() != obj.getClass())){ 
			return false;
		} 
		MacroKey newMacrokey = null;
		if(obj instanceof MacroKey){
			newMacrokey = (MacroKey) obj;
			return this.macroName!=null && this.macroName.equals(newMacrokey.macroName) && this.noOfParameters == newMacrokey.noOfParameters;
		}else{
			return false;
		}
	}
}
