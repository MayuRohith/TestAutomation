package com.mayuautomation.selenium.com.mayuautomation.selenium.testNG;

import org.testng.annotations.Test;

public class NewGroupingTestNG {
	@Test(groups = { "B" })
	public void f1() {
	}

	@Test(groups = { "C" })
	public void f2() {
	}

	@Test(groups = { "B" })
	public void f3() {
	}

	@Test(groups = { "B" })
	public void f4() {
	}

	@Test(groups = { "C" })
	public void f5() {
	}
}
