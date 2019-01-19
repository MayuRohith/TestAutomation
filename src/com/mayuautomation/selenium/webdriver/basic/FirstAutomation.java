package com.mayuautomation.selenium.webdriver.basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FirstAutomation {
	WebDriver driver;

	// JavascriptExecutor jse;
	// Actions builder = new Actions(driver);
//	WebElement webElement = driver.findElement(By.id("dLabel"));
	// private WebElement webElement = driver.findElement(By.id("dLabel"));
	public void invokeBrowser() {
		try {
			System.setProperty("webdriver.chrome.driver", "webdrivers//chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

			driver.get("https://www.facebook.com/");
			loginFb();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void loginFb() throws InterruptedException {

		// WebElement webElement = driver.findElement(By.id("day"));
		Select day = new Select(driver.findElement(By.id("day")));
//		day.selectByIndex(2);
		// day.selectByValue("2");
		day.selectByVisibleText("10");

		Select month = new Select(driver.findElement(By.id("month")));
		month.selectByIndex(3);
		// month.selectByValue("3");

		Select year = new Select(driver.findElement(By.id("year")));
		year.selectByIndex(4);
//	month.selectByValue("2016");

		// driver.findElement(By.xpath("//*[@id=\"header-II\"]/section/nav/div/a[2]")).click();

		// dLabel

		// builder.moveToElement(webElement).build().perform();
		// driver.findElement(By.id("dLabel")).click();
//	driver.findElement(By.id("homeSearchBar")).sendKeys("Java");
//	driver.findElement(By.id("homeSearchBarLoadingIcon")).click();
		Thread.sleep(1000);
		// driver.findElement(By.id("homeSearchBar")).sendKeys("");
//	jse = (JavascriptExecutor)driver;
//	jse.executeScript("scroll(0,1000)");
		// driver.findElement(By.id("filterdropdown")).click();
		// driver.quit();

	}

	public static void main(String[] args) {
		FirstAutomation fAuto = new FirstAutomation();
		fAuto.invokeBrowser();
	}

}
