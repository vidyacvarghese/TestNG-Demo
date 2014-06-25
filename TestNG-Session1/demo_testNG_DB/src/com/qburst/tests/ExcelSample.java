package com.qburst.tests;

import java.io.IOException;

import jxl.read.biff.BiffException;

import com.qburst.utility.ExcelUtility;

public class ExcelSample {
	public static void main(String[] args) throws BiffException, IOException {
		ExcelUtility ex = new ExcelUtility();
	String studentName = ex.getValueForKeyword("name", "student");
	System.out.println("Name "+studentName);
	}

}
