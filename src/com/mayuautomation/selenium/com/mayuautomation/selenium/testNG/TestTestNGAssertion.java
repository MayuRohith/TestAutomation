package com.mayuautomation.selenium.com.mayuautomation.selenium.testNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestTestNGAssertion {
	WebDriver driver;
	@BeforeTest
	public void invokeBrowser() {
		try {
			System.setProperty("webdriver.chrome.driver", "webdrivers//chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("https://www.gmail.com");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
  @Test
  public void testAssert() {
	  Assert.assertEquals(true, isEqual(10,0));
	  System.out.println("test assert fail");
  }
  
  public boolean isEqual(int a, int b) {
	  if(a==b) {
		  return true;
	  }
	  else {
		  return false;
	  }
  }
  
  @Test
  public void getTitle() {
	  String title = driver.getTitle();
	  Assert.assertEquals(title, "Gmail");
	  System.out.println("test assert pass");
  }
}
