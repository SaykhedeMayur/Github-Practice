package com.vtiger.crm.generic.fileutility;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * this class is for to work with Properties File
 * 
 * @author Mayur
 */
public class FileUtility {
	
	/**this method is for to get the data from Properties File*/
	public String getDataFromPropertiesFile(String key) throws Throwable {
		
		FileInputStream fis = new FileInputStream("./configAppData/commondata.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		String data = pObj.getProperty(key);
		return data;
	}

}
