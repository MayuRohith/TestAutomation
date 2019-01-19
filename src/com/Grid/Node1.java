package com.Grid;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Node1 {
	WebDriver driver;
	String nodeUrl;
  @Test
  public void f() {
	  try {
			nodeUrl = "http://192.168.8.104:5555/wd/hub";
			
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setBrowserName("chrome");
			capabilities.setPlatform(Platform.WIN10);
			driver = new RemoteWebDriver(new URL(nodeUrl), capabilities);
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(45,TimeUnit.SECONDS);
			driver.get("http://www.amazon.com");
			driver.findElement(By.linkText("Today's Deals")).click();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
  }

