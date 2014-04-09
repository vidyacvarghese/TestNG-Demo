package com.qburst.samples.tests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import jxl.read.biff.BiffException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qburst.samples.utility.ExcelUtility;

public class GmailLogin {
	private String loginUserName;
	private String loginPassword;
	public WebDriver driver = new FirefoxDriver();
	public String baseUrl = "http://gmail.com/";

	@BeforeTest
	public void launchBrowser() throws IOException, InterruptedException,
			BiffException {
		driver.manage().window().maximize();
		driver.get(baseUrl);
		Thread.sleep(5000);
	}

	@Test
	public void checkGmailLogin() throws IOException, InterruptedException {
	
		// to get customer credentials
		loginUserName = "testt3223fgdg";
		loginPassword = "testt3223";
		
		Thread.sleep(3000);
		
		//to enter username
		WebElement userNameField = driver.findElement(By.id("Email"));
		Thread.sleep(3000);
		userNameField.sendKeys("testt3223");
		
		// to enter password
		WebElement passwordField = driver.findElement(By.id("Passwd"));
		Thread.sleep(3000);
		passwordField.sendKeys("testt3223");
		
		Thread.sleep(3000);
		
		WebElement signInbutton = driver.findElement(By.id("signIn"));
		signInbutton.click();
		Thread.sleep(5000);

		if (driver.findElements(By.className("error-msg"))
				.size()==0) {
			assertTrue(true, "Valid credentials");
		}
		else {
			assertTrue(false, "Invalid credentials");
		}
		
	}
	
	@AfterTest
	public void terminateBrowser() throws IOException, InterruptedException,
			BiffException {
		driver.quit();
		System.out.println("terminateBrowser");
	}
}
