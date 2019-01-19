package com.mayuautomation.selenium.webdriver.basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class EbayAutoSikuliTest {

	WebDriver driver;
	private Screen screean;

	public void invokeBrowser() {
		System.setProperty("webdriver.chrome.driver", "webdrivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/");
		searchOnEbay();
	}

	public void searchOnEbay() {
		try {
			Pattern email = new Pattern("ScreenShots//email.PNG");
			Pattern pass = new Pattern("ScreenShots//pass.PNG");
			Pattern login = new Pattern("ScreenShots//login.PNG");
			//Pattern sigin = new Pattern("ScreenShots//signin.PNG");
			
			//screean.wait(sigin, 10);
			//screean.click(sigin);
			screean.wait(email, 10);
			screean.click(email);
			screean.type(email, "admin");
			//screean.wait(pass,10);
			screean.click(pass);
			screean.type(pass, "admin123");
			screean.click(login);
		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

	public static void main(String args[]) {
		EbayAutoSikuliTest ebayTest = new EbayAutoSikuliTest();
		ebayTest.invokeBrowser();
		ebayTest.searchOnEbay();
	}
}
