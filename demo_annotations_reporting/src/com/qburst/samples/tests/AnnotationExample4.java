package com.qburst.samples.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import jxl.read.biff.BiffException;

public class AnnotationExample4 {
	public WebDriver driver = new FirefoxDriver();
	public String baseUrl = "http://jqueryui.com/";

	@BeforeTest
	public void launchBrowser() throws IOException, InterruptedException,
			BiffException {
		System.out.println("launchBrowser");
		driver.manage().window().maximize();
		driver.get(baseUrl);
		Thread.sleep(5000);
	}

	@BeforeMethod
	public void getTitle() throws IOException, InterruptedException,
			BiffException {
		System.out.println("getTitle");
		String expectedTitle = "jQuery UI";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@Test
	public void clickDraggable() throws IOException, InterruptedException,
			BiffException {
		System.out.println("clickDraggable");
		WebElement draggableText = driver.findElement(By.xpath("//a[contains(text(),'Draggable')]"));
		draggableText.click();
		Thread.sleep(3000);
	}

	@Test
	public void clickSelectable() throws IOException, InterruptedException,
			BiffException {
		System.out.println("clickSelectable");
		WebElement selectableText = driver.findElement(By.xpath("//a[contains(text(),'Selectable')]"));
		selectableText.click();
		Thread.sleep(3000);
	}

	@AfterMethod
	public void goBackToHomePage() throws IOException, InterruptedException,
			BiffException {
		System.out.println("goBackToHomePage");
		driver.navigate().back();
		Thread.sleep(3000);
	}

	@AfterTest
	public void terminateBrowser() throws IOException, InterruptedException,
			BiffException {
		System.out.println("terminateBrowser");
		driver.quit();
	}
}
