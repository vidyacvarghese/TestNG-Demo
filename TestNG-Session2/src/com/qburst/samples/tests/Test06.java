package com.qburst.samples.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test06 {

	private WebDriver driver;

	@BeforeMethod
	@Parameters({ "browser" })
	public void openBroswer(String browser) {
		if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			// Set Path for the executable file
			System.setProperty("webdriver.chrome.driver",
					"/home/vidya/Documents/softwares/chromedriver");
			driver = new ChromeDriver();
		} else {
			throw new IllegalArgumentException("The Browser Type is Undefined");
		}
	}

	@Test
	public void loadGoogle() throws InterruptedException {
		// Open App
		driver.get("http://google.com");
		System.out.println("Thread id = " + Thread.currentThread().getId());
		System.out.println("Google1 loaded");
		Thread.sleep(5000);
	}

	@Test
	public void loadYahoo() throws InterruptedException {
		// Open App
		driver.get("http://yahoo.com");
		System.out.println("Thread id = " + Thread.currentThread().getId());
		System.out.println("yahoo loaded");
		Thread.sleep(5000);
	}

//	@AfterMethod
//	public void closeBrowser() {
//		try {
//			driver.quit();
//		} catch (Exception e) {
//			driver = null;
//		}
//	}

}
