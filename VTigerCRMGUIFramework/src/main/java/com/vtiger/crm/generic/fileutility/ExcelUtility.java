package com.vtiger.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * this class is for to work with Excel File
 * 
 * @author Mayur
 */
public class ExcelUtility {
	
	/**this method is for to fetch the data from excel file*/
	public String getDataFromExcelFile (String sheetName, int rowIndex, int cellIndex) throws Throwable {
		
		FileInputStream fis = new FileInputStream("./testdata/vtiger_CRM_Excel.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetName).getRow(rowIndex).getCell(cellIndex).getStringCellValue();
		
		return data;
	}
	
	/**this method is for to get no of total rows present inside the sheet*/
	public int getRowCount(String sheetName) throws Throwable {
		
		FileInputStream fis = new FileInputStream("./testdata/vtiger_CRM_Excel.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int rowNum = wb.getSheet(sheetName).getLastRowNum();
		wb.close();
		
		return rowNum; 
	}
	
	/**this method is for to get no of total cells present inside the rows */
	public int getCellCount(String sheetName) throws Throwable {
		
		FileInputStream fis = new FileInputStream("./testdata/vtiger_CRM_Excel.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int cellNum = wb.getSheet(sheetName).getRow(0).getLastCellNum();
		wb.close();
		
		return cellNum;
	}
	
	/**this method is for to set/pass the data into Excel File*/
	public void setDataIntoExcel(String sheetName, int rowNum, int cellNum, String data) throws Throwable {
		
		FileInputStream fis = new FileInputStream("./testdata/vtiger_CRM_Excel.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(rowNum).createCell(cellNum, CellType.STRING);
		
		FileOutputStream fos = new FileOutputStream("./testdata/vtiger_CRM_Excel.xlsx");
		wb.write(fos);
		wb.close();
	}

}
