package com.crm.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataproviderUtil {
	 
	public static Object[][] getTestData(String sheetname){
		FileInputStream fis=null;
		XSSFSheet sheet = null;
		XSSFWorkbook workbook= null;
		String path=System.getProperty("user.dir")+"\\src\\main\\java1\\com\\crm\\qa\\TestData\\DataPOM.xlsx";
		System.out.println(path);
		
		
	 try {
		fis=new FileInputStream(path);
		try {
			workbook=new XSSFWorkbook(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheet =workbook.getSheet(sheetname);
		//System.out.println(sheet);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 //Total number of rows//
	 int rownum=sheet.getLastRowNum();
	 System.out.println(rownum);
	 
	 //Total number of columns//
	 int colnum=sheet.getRow(0).getLastCellNum();
	
	 Object data[][] =new Object[rownum][colnum];
	 for(int i=0;i<rownum;i++){
		 for(int j=0;j<colnum;j++){
			 
			 data[i][j]=sheet.getRow(i+1).getCell(j).toString();
 
		 }
	 }

		return data;

	}

}
