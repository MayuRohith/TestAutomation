package com.guru99.automation;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class FirstTestNGByG99 {
	public String baseUrl = "http://www.way2automation.com/angularjs-protractor/banking/#/login";
	public String driverPath = "webdrivers//chromedriver.exe";
	public WebDriver driver;

	@BeforeTest
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(baseUrl);
	}

	@Test
	public void verifyTitleOfHomePage() {
		String ExpectedTitle = "Protractor practice website - Banking App";
		String ActualTitle = driver.getTitle();
		assertEquals(ActualTitle, ExpectedTitle);
	}

	@AfterTest
	public void terminated() {
		driver.close();
	}
	
	
}
