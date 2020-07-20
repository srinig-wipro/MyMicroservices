/*
 *
 * Copyright 2014 Wipro Technologies All rights reserved.
 * 
 * Customer specific copyright notice     :
 *
 * File Name       : HelloWorldTest.java
 *
 * Description     :Project desc.
 *
 * Version         : 1.0.0.
 *
 * Created Date    :Mar 13, 2017
 * 
 */
package com.demo;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

@Category(IntegrationTest.class)
public class HelloWorldTest {

	static WebDriver driver;

	@BeforeClass
	public static <driver> void setup() {
		System.setProperty("webdriver.chrome.driver", "F:\\chromedriver.exe");
		driver = new ChromeDriver();
		// new FirefoxDriver();
	}

	@AfterClass
	public static void cleanUp() {
		driver.quit();
	}

	@Test
	public void shouldSayHelloWorld() {
		driver.get("http://localhost:6080/App1LoginQA");
		
		WebElement we = driver.findElement(By.xpath("html/body/h1[1]"));
		
		if (we.getText().contains("Welcome patel/patel")) {
			System.out.println("### Home Page Successful ###");
		} else {
			System.out.println("Home Page Unsuccessful");
		}
		
		assertEquals("Welcome patel/patel", we.getText());
	}
}