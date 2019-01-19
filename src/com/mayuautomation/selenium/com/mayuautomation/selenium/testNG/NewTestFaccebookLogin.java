package com.mayuautomation.selenium.com.mayuautomation.selenium.testNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class NewTestFaccebookLogin {
	WebDriver driver;
  @Test
  public void openBrowser() {
	  System.setProperty("webdriver.chrome.driver","webdrivers//chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().deleteAllCookies();
	  driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  driver.get("https://opensource-demo.orangehrmlive.com/");
  }
  
  @Test(dependsOnMethods= {"openBrowser"})
  public void facebookLogin() {
	  driver.findElement(By.id("txtUsername")).sendKeys("Admin");
	  driver.findElement(By.id("txtPassword")).sendKeys("admin123");
	  driver.findElement(By.id("btnLogin")).submit();
	  driver.findElement(By.id("welcome")).click();
	  driver.findElement(By.xpath("//*[@id=\"welcome-menu\"]/ul/li[2]/a")).click();
  }
}
