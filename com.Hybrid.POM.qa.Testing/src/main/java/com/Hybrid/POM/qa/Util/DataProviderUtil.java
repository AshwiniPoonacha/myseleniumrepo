package com.Hybrid.POM.qa.Util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class DataProviderUtil {


	public Object[][] dataproviderutility(String sheetname) {
		FileInputStream file=null;
		XSSFWorkbook workbook=null;
		XSSFSheet sheet=null;
		String path="C:\\Users\\91990\\Music\\New folder\\Data_POM_Hybrid.xlsx";
	
			
			try {
			file=new FileInputStream(path);
			workbook=new XSSFWorkbook(file);
			sheet=workbook.getSheet(sheetname);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			//Reading the rows&cols//
			int rownum=sheet.getLastRowNum();
			System.out.println(rownum);
			int colnum=sheet.getRow(0).getLastCellNum();
			System.out.println(colnum);
			
			Hashtable<String,String> table=null ;
			Object data[][]=new Object[rownum][colnum];
			for(int r=0;r<rownum;r++){
				table=new Hashtable<String,String>();
				for(int c=0;c<colnum;c++){
					String key=sheet.getRow(0).getCell(c).toString();
					String value=sheet.getRow(r+1).getCell(c).toString();
					table.put(key, value);
					data[r][c]=sheet.getRow(r+1).getCell(c).toString();
				}
	
				System.out.println(table);
				data[r][0]=table;
			}
			//return data;
			return data;

	}

}
