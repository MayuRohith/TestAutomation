package com.framework.pages;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginPage extends BasePage {

	@Test(priority = 0,description = "Valid Login Test")
	public void loginTest() {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.id("welcome")).click();
		driver.findElement(By.linkText("Logout")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Test(priority = 1,description = "Invalid Login Test")
	public void invalidLogin() {
		driver.findElement(By.id("txtUsername")).sendKeys("Admi");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
	}

}
