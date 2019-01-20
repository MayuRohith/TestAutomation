package com.testDataDriven;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.excel.utility.ExcelDataConfig;

public class TestDrivenWithExcel {

	// Report Details
	ExtentReports extentReports;
	ExtentTest extentTest;
	ExtentHtmlReporter extentHtmlReporter;

	WebDriver driver;
	String driverPath = "webdrivers\\chromedriver.exe";
	String baseUrl = "https://opensource-demo.orangehrmlive.com/";

	@BeforeTest
	public void setUp() {

		extentHtmlReporter = new ExtentHtmlReporter(
				new File(System.getProperty("user.dir") + "/AutomationReports.html"));
		extentHtmlReporter.loadXMLConfig(new File(System.getProperty("user.dir") + "/ReportsConfig.xml"));
		extentReports = new ExtentReports();
		extentReports.setSystemInfo("Environment", "QA");
		extentReports.attachReporter(extentHtmlReporter);
	}

	@BeforeMethod
	public void launchBrowser(Method method) {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl); 
		
		String descriptiveTestName = method.getAnnotation(Test.class).testName();
		extentTest = extentReports.createTest(descriptiveTestName);
		
	}

	@Test(dataProvider = "orangeHRMData", testName = "Verify login function work or not")
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

		String expected = "Welcome Admin";
		String actual = driver.findElement(By.id("welcome")).getText();
		assertEquals(actual, expected);
		extentTest.log(Status.INFO, "Assert Pass as condition is True");
	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(Status.PASS, "The Test Method Name As : " + result.getName() + " is Passed ");

		} else if (result.getStatus() == ITestResult.FAILURE) {
			extentTest.log(Status.FAIL, "The Test Method Name As : " + result.getName() + " is Fail ");
			extentTest.log(Status.FAIL, "The Test Failure : " + result.getThrowable());
		} else if (result.getStatus() == ITestResult.SKIP) {
			extentTest.log(Status.SKIP, "The Test Method Name As : " + result.getName() + " is Skiped ");
		}
		extentReports.flush();
		driver.quit();
	}
	
	@AfterTest
	public void endReport() {
		extentReports.flush();
	}

	@DataProvider(name = "orangeHRMData")
	public Object[][] orangeHRM() {

		ExcelDataConfig exConfig = new ExcelDataConfig("ExcellData\\LoginCredintial.xlsx");
		int rows = exConfig.getRowCount(0);

		Object[][] data = new Object[rows][2];
		for (int i = 1; i < rows; i++) {
			data[i][0] = exConfig.getData(0, i, 0);
			data[i][1] = exConfig.getData(0, i, 1);
		}
		return data;
	}
}
