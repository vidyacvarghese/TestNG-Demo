package com.qburst.samples.utility;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.LabelCell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 * 
 * ClassName: ExcelUtility 
 * Description: This class is to interact with the excel sheet such as reading from an excel file, writing to an excel file
 */


public class ExcelUtility {
	private static String keywordValue = null;
	
	
	//Method to get the required value from the Excel sheet
	public static String getValueForKeyword(String keyword,String excelSheetName) throws BiffException, IOException 
	{
		if (getWorkbook() != null) {
			keywordValue = null;
				try {
					Sheet sheet = getWorkbook().getSheet(excelSheetName);
					LabelCell cellLabelObj = sheet.findLabelCell(keyword);
					int columnNumber = cellLabelObj.getColumn();
					int rowNumber = cellLabelObj.getRow();
					int columnNumberNew = columnNumber + 1;
					Cell keywordHeadingCell = sheet.getCell(columnNumberNew, rowNumber);
					keywordValue = keywordHeadingCell.getContents();
				} 
				catch (Exception e) {
				}
		}
		return keywordValue;
	}

	
	public static Workbook getWorkbook() {
		Workbook workbook = null;
		try {
			workbook = Workbook.getWorkbook(new File(PropertyUtility.getProperty("Inputexcelfile")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return workbook;
	}

	
}
