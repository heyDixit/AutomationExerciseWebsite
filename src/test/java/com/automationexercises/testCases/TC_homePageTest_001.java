package com.automationexercises.testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.automationexercises.pageObjects.HomePage;


public class TC_homePageTest_001 extends BaseClass {
	@Test(priority=1)
	public void homePageTest() {
		driver.get(baseURL);
		 HomePage hp=new HomePage(driver);
		 if(driver.getTitle().equals("Automation Exercise")) {
			 AssertJUnit.assertTrue(true);
		 }
		 else {
			 AssertJUnit.assertTrue(false);
		 }
		 
		 
	}
}
