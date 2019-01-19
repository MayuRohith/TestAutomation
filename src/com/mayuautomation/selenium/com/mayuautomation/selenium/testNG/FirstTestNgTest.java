package com.mayuautomation.selenium.com.mayuautomation.selenium.testNG;

import org.testng.annotations.*;

public class FirstTestNgTest {
  @Test
  public void f1() {
	  System.out.println("Inside F1");
  }
  
  @Test
  public void f2() {
	  System.out.println("Inside F2");
  }
  
  @BeforeTest
  public void beforeAnyTest() {
	  System.out.println("Before Any Test");
  }
  
  @AfterTest
  public void afterAllTest() {
	  System.out.println("After All Test");
  }
  
  @BeforeMethod
  public void beforeEveryMethod() {
	  System.out.println("Before Every Test Method");
  }
  
  @AfterMethod
  public void afterEveryMethod() {
	  System.out.println("After Every Test Method");
  }
  
  @BeforeClass
  public void beforeClass() {
	  System.out.println("Before Class");
  }
  
  @AfterClass
  public void afterClass() {
	  System.out.println("After Class");
  }
}
