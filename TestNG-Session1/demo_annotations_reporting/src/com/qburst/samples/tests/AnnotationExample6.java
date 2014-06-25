package com.qburst.samples.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AnnotationExample6 {

	@BeforeTest
	public void beforeTest_test() {
		System.out.println("beforeTest_test");
	}

	@BeforeMethod
	public void beforeMethod_test() {
		System.out.println("beforeMethod_test");
	}

	@Test
	public void test_test() {
		System.out.println("test_test");
	}

	@AfterMethod
	public void afterMethod_test() {
		System.out.println("afterMethod_test");
	}

	@AfterTest
	public void afterTest_test() {
		System.out.println("afterTest_test");
	}

}
