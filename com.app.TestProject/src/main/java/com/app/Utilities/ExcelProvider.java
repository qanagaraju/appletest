package com.app.Utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public abstract class  ExcelProvider  {
	
	public static  XSSFWorkbook wb;
	
	public ExcelProvider() {
		
		try {
			
			File file = new File("./app.MyFiles/login.xlsx");
			FileInputStream fis = new FileInputStream(file);
			wb = new XSSFWorkbook(fis);
			
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}finally 
		{
			System.out.println("File Loaded successfully");
		}
		
		
	}
	
	
	public String getsheetname(String sheetname,int rownum,int columnno) {
		return wb.getSheet(sheetname).getRow(rownum).getCell(columnno).getStringCellValue();
	}
	
	
	public String getsheetname(int sheetno,int rownum,int columnno) {
		
		return wb.getSheetAt(sheetno).getRow(rownum).getCell(columnno).getStringCellValue();
		
	}
	
	
	
	
	

}
