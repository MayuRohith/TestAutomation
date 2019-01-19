package com.mayuautomation.selenium.com.mayuautomation.selenium.testNG;

import org.testng.annotations.Test;

public class TestTestNGAnnotations {
  @Test(priority=0)
  public void p() {
  }
  @Test(priority=4)
  public void m() {
  }
  @Test(priority=3)
  public void k() {
  }
  @Test(enabled=false)
  public void a() {
  }
  @Test(dependsOnMethods="a")
  public void s() {
  }
  @Test(priority=100)
  public void u() {
  }
}
