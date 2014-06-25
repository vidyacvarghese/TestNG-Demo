package com.qburst.samples.tests;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import jxl.read.biff.BiffException;

public class AnnotationExample1 {
	public WebDriver driver = new FirefoxDriver();
	public String baseUrl = "http://google.com/";

	@BeforeTest
	public void launchBrowser() throws IOException, InterruptedException,
			BiffException {
		System.out.println("launchBrowser");
		driver.get(baseUrl);
		Thread.sleep(5000);
	}

	@Test
	public void getTitle() throws IOException, InterruptedException,
			BiffException {
		System.out.println("annotationExample");
		String actualTitle = driver.getTitle();
		System.out.println("Title: "+actualTitle);
	}

	@AfterTest
	public void terminateBrowser() throws IOException, InterruptedException,
			BiffException {
		driver.quit();
		System.out.println("terminateBrowser");
	}

}
