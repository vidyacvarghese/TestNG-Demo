package com.qburst.tests;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TestNGSample {

	public WebDriver driver = new FirefoxDriver();
	public String baseUrl = "http://google.com/";

	@Test
	public void loadUrl() throws IOException, InterruptedException {
		driver.manage().window().maximize();
		driver.get(baseUrl);
		Thread.sleep(30);
	}
}
