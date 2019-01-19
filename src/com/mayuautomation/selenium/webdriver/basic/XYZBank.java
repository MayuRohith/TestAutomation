package com.mayuautomation.selenium.webdriver.basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class XYZBank {
	WebDriver driver;
	
	public void invokeBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "webdrivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("http://www.way2automation.com/");
		deposit();
	}

	
	public void deposit() throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"navbar-collapse-1\"]/ul/li[8]"))).build().perform();
		driver.findElement(By.linkText("Practice site 2")).click();
		driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[2]/div[2]/div/ul/li[5]/a/figure/img")).click();
		//Thread.sleep(10000);
		
	}
	
	public void nextPage() {
		//Click Customer Login 
				//driver.get("http://www.way2automation.com/angularjs-protractor/banking/#/login");
				driver.findElement(By.linkText("Customer Login")).click();
				
				driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[1]/div[2]/button")).click();
		
				//Select Customer name For Login
				Select dropdown = new Select(driver.findElement(By.id("userSelect")));
				dropdown.selectByIndex(2);
				driver.findElement(By.id("Login"));

				//Select Account Based On The Currency 
				Select account = new Select(driver.findElement(By.id("accountSelect")));
				account.selectByIndex(2);

				//Click Deposite Button
				driver.findElement(By.id("notch"));
				
	}
	public static void main(String[] args) throws InterruptedException {
		XYZBank xyzBank = new XYZBank();
		xyzBank.invokeBrowser();
		xyzBank.nextPage();

	}

}
