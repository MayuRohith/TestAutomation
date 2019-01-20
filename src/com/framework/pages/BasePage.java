package com.framework.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BasePage {

	WebDriver driver;
	String baseUrl = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";
	String driverPath = "webdrivers\\chromedriver.exe";

	// if we use @BeforeMethod then each and every test perform by new browser open
	// and close but if we use @BeforeClass then same browser perform the each
	// TestCase
	@BeforeClass
	public void setUp() {
		Reporter.log("*************Browser Session Start****************", true);
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseUrl);

		Reporter.log("**************Application Started******************", true);
	}

	@AfterClass
	public void closeBrowser() {
		driver.close();
		Reporter.log("****************Browser Session End****************", true);
	}

}
