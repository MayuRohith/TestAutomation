package com.excel.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadFullDataFromExcel {

	public static void main(String[] args) throws IOException {
		File src = new File("ExcellData\\LoginCredintial.xlsx");
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet =wb.getSheetAt(0);
		int rowCount = sheet.getLastRowNum();
		for(int i = 1; i <= rowCount; i++) {
			
			String data0 = sheet.getRow(i).getCell(1).getStringCellValue();
			System.out.println(data0);
		}
		wb.close();
	}

}
