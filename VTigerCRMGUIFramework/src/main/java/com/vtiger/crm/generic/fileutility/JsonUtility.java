package com.vtiger.crm.generic.fileutility;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * 
 * this class is for to work with JSON File 
 * 
 * @author Mayur
 */
public class JsonUtility {
	
	/**this method is for to get the data from JSON File*/
	public String getDataFromJsonFile(String key) throws Throwable {
		
		FileReader fileR = new FileReader("./configAppData/appCommonData.json");	
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(fileR);
		JSONObject map = (JSONObject) obj;
		String data = map.get(key).toString();
		
		return data;	
	}

}
