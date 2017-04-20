package com.cs.util;


import java.util.Map.Entry;
import java.util.TreeMap;


public class JqgridUtil {

	
	public static String exchengeToSelect(TreeMap<Integer, String> data){
		
		

		String context = "<select>";
		for( Entry<Integer, String> var:data.entrySet()){
			context = context + "<option value="+var.getKey()+">"+var.getValue()+"</option>";
		}
		context = context + "/<select>";
		return null;		
	}
	
	
	
	
}