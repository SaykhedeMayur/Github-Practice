package com.vtiger.crm.generic.dataprovider;


import org.testng.annotations.DataProvider;

import com.vtiger.crm.generic.fileutility.ExcelUtility;

/**
 * this class is for to provide data from Excel File to Test Script with 
 * the help of @DataProvider annotation
 * 
 * @author Mayur
 */
public class DataProviderClass {

	@DataProvider
	public Object[][] getMobileProduct() throws Throwable {

		ExcelUtility eLib = new ExcelUtility();
		int rowCount = eLib.getRowCount("mobileProduct");

		Object[][] objArr = new Object[rowCount][2];

		for (int i = 0; i < rowCount; i++) {
			objArr[i][0] = eLib.getDataFromExcelFile("mobileProduct", i + 1, 0);
			objArr[i][1] = eLib.getDataFromExcelFile("mobileProduct", i + 1, 1);
		}

		return objArr;
	}

}
