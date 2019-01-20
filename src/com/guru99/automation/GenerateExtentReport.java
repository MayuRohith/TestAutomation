package com.guru99.automation;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class GenerateExtentReport {
	// Report Details
	ExtentReports extentReports;
	ExtentTest extentTest;
	ExtentHtmlReporter extentHtmlReporter;

	// Driver Initilization and Url Initilization
	WebDriver driver;
	String driverPath = "webdrivers\\chromedriver.exe";
	String baseUrl = "https://opensource-demo.orangehrmlive.com/";

	@BeforeTest
	public void startReport() {
		extentHtmlReporter = new ExtentHtmlReporter(
				new File(System.getProperty("user.dir") + "/AutomationReport.html"));
		extentHtmlReporter.loadXMLConfig(new File(System.getProperty("user.dir") + "/ReportsConfig.xml"));
		extentReports = new ExtentReports();
		extentReports.setSystemInfo("Environment", "QA");
		extentReports.attachReporter(extentHtmlReporter);

		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}

	@Test(priority = 0, testName = "Check Login Button Work Correct")
	public void loginButtonWorkVerification() {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		String expected = "Welcome Admin";
		String actual = driver.findElement(By.id("welcome")).getText();
		assertEquals(actual, expected);
		extentTest.log(Status.INFO, "Assert Pass as condition is True");
	}

	@Test(priority = 1, testName = "Check User Add Option is Work or Not")
	public void addUser() {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id("menu_admin_viewAdminModule"))).build().perform();
		action.moveToElement(driver.findElement(By.id("menu_admin_UserManagement"))).build().perform();
		driver.findElement(By.id("menu_admin_viewSystemUsers")).click();
		driver.findElement(By.id("btnAdd")).click();

		String expected = "Add User";
		String actual = driver.findElement(By.id("UserHeading")).getText();
		assertEquals(actual, expected);
		extentTest.log(Status.INFO, "Assert Fail as condition is False");
	}

	@BeforeMethod
	public void getResult(Method method) {
//		String testName = method.getName();
//		extentTest = extentReports.createTest(testName);
		String descriptiveTestName = method.getAnnotation(Test.class).testName();
		extentTest = extentReports.createTest(descriptiveTestName);
	}

	@AfterMethod
	public void getResult(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(Status.PASS, "The Test Method Name As : " + result.getName() + " is Passed ");

		} else if (result.getStatus() == ITestResult.FAILURE) {
			extentTest.log(Status.FAIL, "The Test Method Name As : " + result.getName() + " is Fail ");
			extentTest.log(Status.FAIL, "The Test Failure : " + result.getThrowable());
		} else if (result.getStatus() == ITestResult.SKIP) {
			extentTest.log(Status.SKIP, "The Test Method Name As : " + result.getName() + " is Skiped ");
		}
	}

	@AfterTest
	public void endreport() {
		extentReports.flush();

	}
}