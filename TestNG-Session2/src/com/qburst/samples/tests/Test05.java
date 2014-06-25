package com.qburst.samples.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test05 {

	private WebDriver driver1, driver2;

	// Configure for multi browser drivers
	@Parameters("browser")
	@BeforeClass
	public void beforeTest(String browser) {
		if (browser.equalsIgnoreCase("firefox")) {
			driver1 = new FirefoxDriver();
			driver2 = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			// Set Path for the executable file
			System.setProperty("webdriver.chrome.driver",
					"/home/vidya/Documents/softwares/chromedriver");
			driver1 = new ChromeDriver();
			driver2 = new ChromeDriver();
		} else {
			throw new IllegalArgumentException("The Browser Type is Undefined");
		}

	}

	@Test
	public void loadGoogle() throws InterruptedException {
		// Open App
		driver1.get("http://google.com");
		System.out.println("Thread id = " + Thread.currentThread().getId());
		System.out.println("Google loaded");
		Thread.sleep(5000);
	}

	@Test
	public void loadYahoo() throws InterruptedException {
		// Open App
		driver2.get("http://yahoo.com");
		System.out.println("Thread id = " + Thread.currentThread().getId());
		System.out.println("Yahoo loaded");
		Thread.sleep(5000);
	}
	
	@AfterClass
	public void afterTest() {
		try {
			driver1.quit();
			driver2.quit();
		} catch (Exception e) {
			driver1 = null;
			driver2 = null;
		}
	}

}
