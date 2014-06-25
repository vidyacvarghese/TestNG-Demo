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

public class Test07 {

	private WebDriver driver1, driver2;

//	@BeforeMethod
//	@Parameters({ "browser" })
//	public void openBroswer(String browser) {
//		if (browser.equalsIgnoreCase("firefox")) {
//			driver1 = new FirefoxDriver();
//			driver2 = new FirefoxDriver();
//		} else if (browser.equalsIgnoreCase("chrome")) {
//			// Set Path for the executable file
//			System.setProperty("webdriver.chrome.driver",
//					"/home/vidya/Documents/softwares/chromedriver");
//			driver1 = new ChromeDriver();
//			driver2 = new ChromeDriver();
//		} else {
//			throw new IllegalArgumentException("The Browser Type is Undefined");
//		}
//	}

	@Test
	public void loadGoogle() throws InterruptedException {
		// Open App
		driver1 = new FirefoxDriver();
		driver1.get("http://google.com");
		System.out.println("Thread id = " + Thread.currentThread().getId());
		System.out.println("Google1 loaded");
		Thread.sleep(5000);
		closeBrowser(driver1);
	}

	@Test
	public void loadYahoo() throws InterruptedException {
		// Open App
		driver2 = new FirefoxDriver();
		driver2.get("http://google.com");
		System.out.println("Thread id = " + Thread.currentThread().getId());
		System.out.println("Google2 loaded");
		Thread.sleep(5000);
		closeBrowser(driver2);
	}

	@AfterMethod
	public void closeBrowser(WebDriver driver) {
		try {
			driver.quit();
		} catch (Exception e) {
			driver = null;
		}
	}

}
