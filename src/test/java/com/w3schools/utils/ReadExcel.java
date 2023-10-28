package com.w3schools.utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ReadExcel {
	
	@DataProvider(name = "ReadtestDataFromExcel")
	public Object[][] readExcelPath(){
		Object[][]  data= null;
		
		try {
			data = getDatafromExcel(System.getProperty("user.dir")+"/Excel/testdata.xlsx", "W3Schools");
			
		}catch(Exception e) {
			
		}
		return data;
	}
	
	
	public Object[][] getDatafromExcel (String path, String sheetName) {
		
		Object[][] excelData = null;
		try {
			XSSFWorkbook wb = new XSSFWorkbook(path);
			XSSFSheet sheet = wb.getSheet(sheetName);
			int noOfRows = sheet.getPhysicalNumberOfRows();
			XSSFRow row = sheet.getRow(0);
			int noOfCols = row.getPhysicalNumberOfCells();
			
			excelData = new Object[noOfRows-1][noOfCols]; 
			
			for(int i=0;i<noOfRows;i++) {
				for(int j=0;j<noOfCols;j++) {
					String CellValue = sheet.getRow(i).getCell(j).getStringCellValue();
					excelData[i-1][j]= CellValue;
					
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return excelData;
		
		
	}

}
