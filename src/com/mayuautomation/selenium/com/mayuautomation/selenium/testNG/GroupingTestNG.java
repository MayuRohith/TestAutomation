package com.mayuautomation.selenium.com.mayuautomation.selenium.testNG;

import org.testng.annotations.Test;

public class GroupingTestNG {
	@Test(groups = { "A" })
	public void g1() {
	}

	@Test(groups = { "A" })
	public void g2() {
	}

	@Test(groups = { "B" })
	public void g3() {
	}

	@Test(groups = { "B" })
	public void g4() {
	}

	@Test(groups = { "A" })
	public void g5() {
	}
}
