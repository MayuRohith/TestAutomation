package com.excel.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelSheet {

	public static void main(String a[]) throws IOException {

		File src = new File("ExcellData\\LoginCredintial.xlsx");
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet =wb.getSheetAt(0);
		String data0 = sheet.getRow(0).getCell(1).getStringCellValue();
		System.out.println(data0);
		wb.close();
	}
}
