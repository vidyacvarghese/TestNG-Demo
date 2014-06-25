package com.qburst.samples.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class RunningSuites1 {

	 public WebDriver driver = new FirefoxDriver();

     @Test
     public void loadGoogle() throws InterruptedException {
    	// Open App
//    	 driver.manage().window().maximize();
         driver.get("http://google.com");
         System.out.println("Google loaded");
         Thread.sleep(5000);
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

