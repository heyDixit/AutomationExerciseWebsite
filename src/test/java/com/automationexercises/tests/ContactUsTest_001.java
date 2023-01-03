package com.automationexercises.tests;

import org.testng.annotations.Test;



import com.automationexercises.pageObjects.ContactUs;

import com.automationexercises.reusable.ReUse;



import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class ContactUsTest_001 extends Setting {
	ContactUs cu;
	ReUse ru;
	
	@Test(priority=1)
	public void homePageTest() {
		driver.get(baseURL);
		if(driver.getTitle().equals("Automation Exercise")) {
			 Assert.assertTrue(true);
		 }
		 else {
			 Assert.assertTrue(false);
		 }	 
	}
	
	@Test(priority=2)
	public void clickContactValidation() {
		// Objects calling
		cu = new ContactUs(driver);
		ru = new ReUse(driver);

		cu.clickContactUs();
		//Verifying Heading
		ru.txtVerification(cu.getFormHeadingText(), "GET IN TOUCH");
	}
	
	@Test(priority=3)
	public void fillContactUsForm() {
		//Filling the feedback form
		cu.setName(name);
		cu.setEmail(email);
		cu.setSubject(subject);
		cu.setMessage(message);
		cu.fileUpload(filePath);
	}
	
	@Test(priority=4)
	public void submitContactUsForm() {
		//Submitting
		cu.clickSubmit();
	}
	
	@Test(priority=5)
	public void contactAlertValidation() {
		// Waiting for the alert
		ru.waitForAlert();
		cu.acceptAlert();
		// Verifying Success Message
		ru.txtVerification(cu.getSuccessMsg(), "Success! Your details have been submitted successfully.");
	}
	
	@Test(priority=6)
	public void goBackHomeValidation() {
		//Going back to the homepage
		cu.clickHome();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		String expected = "Automation Exercise";
		wait.until(ExpectedConditions.titleContains(expected));
		String actual = cu.verifyHomePage();
		Assert.assertTrue(actual.contains(expected), "Expected: " + actual + " to contain: " + expected);
		
	}


}
