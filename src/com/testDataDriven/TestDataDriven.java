package com.testDataDriven;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class TestDataDriven {

	WebDriver driver;
	String driverPath = "webdrivers\\chromedriver.exe";
	String baseUrl = "https://opensource-demo.orangehrmlive.com/";
	
	@BeforeMethod
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(4, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}
	
	@Test(dataProvider = "orangeHRMData")
	public void testLogin(String userName, String password) {
		driver.findElement(By.id("txtUsername")).sendKeys(userName);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		driver.findElement(By.id("btnLogin")).click();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(driver.findElement(By.id("welcome")).getText().contains("Welcome Admin"), "Login Faild Invalid Creditial ");
		System.out.println("Login Successful Wel Come To Orange HRM");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	@DataProvider(name = "orangeHRMData")
	public Object[][] orangeHRM(){
		Object[][] data = new Object[3][2];
		data[0][0] = "Admi";
		data[0][1] = "admin123";
		
		data[1][0] = "Admin";
		data[1][1] = "admin123";
		
		data[2][0] = "Admin";
		data[2][1] = "admin12";
		return data;
	}
}
