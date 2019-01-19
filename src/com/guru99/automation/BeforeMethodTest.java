package com.guru99.automation;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;


public class BeforeMethodTest {
	public String baseUrl = "http://demo.guru99.com/test/newtours/index.php";
	public String driverPath = "webdrivers//chromedriver.exe";
	public WebDriver driver;

	@BeforeTest
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(baseUrl);
	}

	@BeforeMethod
	public void verifyHomePage() {
		String ExpectedTitle = "Welcome: Mercury Tours";
		String ActualTitle = driver.getTitle();
		assertEquals(ActualTitle, ExpectedTitle);
	}

	@Test(priority = 0)
	public void register() {
		driver.findElement(By.linkText("REGISTER")).click();
		String ExpectedTitle = "Register: Mercury Tours";
		String ActualTitle = driver.getTitle();
		assertEquals(ActualTitle, ExpectedTitle);
	}
	
	@Test(priority = 1)
	public void support() {
		driver.findElement(By.linkText("SUPPORT")).click();
		String ExpectedTitle = "Under Construction: Mercury Tours";
		String ActualTitle = driver.getTitle();
		assertEquals(ActualTitle, ExpectedTitle);
	}
	
	@AfterMethod
	public void goBackToHome() {
		driver.findElement(By.linkText("Home")).click();
	}
	
	@AfterTest
	public void terminate() {
		driver.close();
	}

}
