package com.excel.utility;

public class ReadExcelData {

	public static void main(String[] args) {
		ExcelDataConfig dataConfig = new ExcelDataConfig("ExcellData\\LoginCredintial.xlsx");
		System.out.println(dataConfig.getData(0, 1, 1));
	}

}
