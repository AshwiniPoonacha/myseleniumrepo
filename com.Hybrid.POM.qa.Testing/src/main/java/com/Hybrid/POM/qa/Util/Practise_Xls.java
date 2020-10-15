package com.Hybrid.POM.qa.Util;

import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Practise_Xls {
	public static XSSFWorkbook workbook=null;
	public static XSSFSheet sheet=null;
	
	public static void main(String[] args){

		String path=System.getProperty("user.dir")+"\\src\\main\\java\\com\\Hybrid\\POM\\qa\\TestData\\Data_POM_Hybrid.xlsx";
		try{
			FileInputStream fs=new FileInputStream(path);
			workbook=new XSSFWorkbook(fs);
			sheet=workbook.getSheetAt(0);
			}catch(Exception e){
			e.printStackTrace();
			}
	
		
		/*for(int i=0;i<workbook.getNumberOfSheets();i++){
		sheet=workbook.getSheetAt(i);
		System.out.println(sheet.getSheetName());
		}*/
		
		
		Iterator<XSSFSheet> it=workbook.iterator();
		while(it.hasNext()){
			System.out.println(it.next().getSheetName());
		}
		
		//Total rows//
		int rownum=sheet.getLastRowNum();
		int colnum=sheet.getRow(0).getLastCellNum();
		
		for(int r=0;r<=rownum;r++){
			for(int c=1;c<colnum;c++){
				String data=sheet.getRow(r).getCell(c).toString();
				System.out.println(data);

			}
		}
		
		String val=readcelldata("TestCases",0,0);
		System.out.println(val);
		
	}
	
		public static String readcelldata(String sheetname,int row,int col){
		sheet=workbook.getSheet(sheetname);
		String data1=sheet.getRow(row+1).getCell(col).getStringCellValue();
		return data1;
	
	}
	
	
	
}


