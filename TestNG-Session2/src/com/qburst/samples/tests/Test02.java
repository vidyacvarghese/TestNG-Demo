package com.qburst.samples.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test02 {

	private WebDriver driver;

	// Configure for multi browser drivers
	@Parameters("browser")
	@BeforeClass
	public void beforeTest(String browser) {
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
		System.out.println("Google loaded");
	}

	@Test
	public void loadYahoo() throws InterruptedException {
		// Open App
		driver.get("http://yahoo.com");
		System.out.println("Yahoo loaded");
	}

	@AfterClass
	public void afterTest() {
		try {
			driver.quit();
		} catch (Exception e) {
			driver = null;
		}
	}
}
