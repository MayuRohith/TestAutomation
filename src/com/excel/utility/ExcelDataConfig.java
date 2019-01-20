package com.excel.utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataConfig {

	XSSFWorkbook wb;
	XSSFSheet sheet;

	public ExcelDataConfig(String excelPath) {
		try {
			File src = new File(excelPath);
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
	}

	public String getData(int sheetIndex, int row, int col) {
		sheet = wb.getSheetAt(sheetIndex);
		String data = sheet.getRow(row).getCell(col).getStringCellValue();
		return data;
	}

	public int getRowCount(int sheetIndex) {
		int row = wb.getSheetAt(sheetIndex).getLastRowNum();
		// it will give the index value so index start with 0 initially so we need
		// actual count so we plus one
		row = row + 1;
		return row;
	}

}
