package com.proteus.preprocess.pp.ext;

import java.util.HashMap;
import java.util.Map;

public class MacroMap<K,V> extends  HashMap<K,V> implements Map<K,V>{
	
	private static final long serialVersionUID = 1L;

	public Boolean containsInMacroList(MacroKey macroKey,HashMap<MacroKey,Macro> macroMap){
		for(MacroKey macrokeykey:macroMap.keySet()){
			if(macrokeykey.equals(macroKey)){
				return true;
			}
		}
		return false;
	}

	public Macro getMacroFromMacrosList(MacroKey macroKey,HashMap<MacroKey,Macro> macroMap){
		for(MacroKey macrokeykey:macroMap.keySet()){
			if(macrokeykey.equals(macroKey)){
				return macroMap.get(macrokeykey);
			}
		}
		return null;
	}

}
