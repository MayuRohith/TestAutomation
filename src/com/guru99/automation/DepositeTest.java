package com.guru99.automation;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DepositeTest {
	WebDriver driver;
	String driverPath = "webdrivers\\chromedriver.exe";
	String baseUrl = "http://www.way2automation.com/angularjs-protractor/banking/#/login";
	String deposit = "5000";

	@BeforeTest
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}

	@Test(priority = 0)
	public void checkPage() {
		String expected = "Protractor practice website - Banking App";
		String actual = driver.getTitle();
		assertEquals(actual, expected);
	}

	@Test(priority = 1, dependsOnMethods = {"checkPage"})
	public void customerLogin() {
		driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[1]/div[1]/button")).click();
		Select user = new Select(driver.findElement(By.id("userSelect")));
		user.selectByVisibleText("Hermoine Granger");
	}

	@Test(priority = 2)
	public void checkLoginButton() {
		String expected = "Login";
		String actual = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/form/button")).getText();
		try {
			assertEquals(actual, expected);
		} catch (AssertionError e) {
			System.out.println("Login button disable.. ");
			throw e;
		}

		System.out.println("Login button enable.. ");
		// Click Login button
		driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/form/button")).click();
	}

	@Test(priority = 3)
	public void checkDepositeButton() {

		String expectedDepoButton = "Deposit";
		String actualDepoButton = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[3]/button[2]"))
				.getText();
		try {
			assertEquals(actualDepoButton, expectedDepoButton);
		} catch (AssertionError e) {
			System.out.println("Deposite button disable.. ");
			throw e;
		}
		System.out.println("Deposite button enable.. ");
	}

	@Test(priority = 4)
	public void deposite() {
		Select dropdown = new Select(driver.findElement(By.id("accountSelect")));
		dropdown.selectByIndex(2);

		// Check the dropdown is selected one or not
		String expected = "1003";
		String actual = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/strong[1]")).getText();
		assertEquals(actual, expected);

		driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[3]/button[2]")).click();

		// Check the Area of amount fill show
		String expect = "Amount to be Deposited :";
		String actu = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[4]/div/form/div/label"))
				.getText();
		assertEquals(actu, expect);

		driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[4]/div/form/div/input")).sendKeys(deposit);
		driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[4]/div/form/button")).click();

		// verify the amount deposited or not
		String expectAmount = deposit;
		String actualAmount = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/strong[2]"))
				.getText();
		try {
			assertEquals(actualAmount, expectAmount);
		} catch (AssertionError e) {
			System.out.println("Deposited failed.. ");
			throw e;
		}
		System.out.println("Deposited Pass.. ");
	}

	@Test(priority = 5)
	public void checkWithrowelButton() {
		String expectedWithrowButton = "Withdrawl";
		String actualWithrowButton = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[3]/button[3]"))
				.getText();
		try {
			assertEquals(actualWithrowButton, expectedWithrowButton);
		} catch (AssertionError e) {
			System.out.println("Withrow button disable.. ");
			throw e;
		}
		System.out.println("Withrow button enable.. ");
	}

	@Test(priority = 6)
	public void checkLogoutButton() {
		String expectedLogoutButton = "Logout";
		String actualLogoutButton = driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/button[2]")).getText();
		try {
			assertEquals(actualLogoutButton, expectedLogoutButton);
		} catch (AssertionError e) {
			System.out.println("LogoutButton button disable.. ");
			throw e;
		}
		System.out.println("LogoutButton button enable.. ");
	}
}
