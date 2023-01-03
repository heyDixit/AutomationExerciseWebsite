package com.automationexercises.tests;



import com.automationexercises.reusable.BaseClass;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;

public class Setting extends BaseClass {

	@BeforeTest
	@Parameters("browser")
	public void set(String browser) throws Exception {
		setup(browser);
	}

	@AfterTest
	public void afterClass() {
		
		tearDown();
	
}
}