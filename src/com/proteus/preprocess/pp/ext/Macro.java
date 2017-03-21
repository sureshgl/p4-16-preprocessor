package com.proteus.preprocess.pp.ext;

import java.util.List;

import lombok.Data;

@Data
public class Macro{

	public MacroKey macroKey;
	public String macroName;
	public String macroDef;
	public List<String> listOfParameters;

	@Override 
	public boolean equals(Object obj){
		if(this == obj)
			return true; 
		if(obj == null || this==null || (this.getClass() != obj.getClass())){ 
			return false;
		} 
		Macro newMacro = null;
		if(obj instanceof Macro){
			newMacro = (Macro) obj;
			return ((this.macroName !=null && macroName.equals(newMacro.macroName)) && (this.macroDef!=null && macroDef.equals(newMacro.macroDef)) &&
					this.listOfParameters!=null && this.listOfParameters.size()==newMacro.listOfParameters.size() && this.listOfParameters.containsAll(newMacro.listOfParameters) && newMacro.listOfParameters.containsAll(this.listOfParameters)
					&& this.macroKey.equals(newMacro.macroKey));

		}else{
			return false;
		}

	}

	@Override public int hashCode(){ 
		return super.hashCode();
	}

}

