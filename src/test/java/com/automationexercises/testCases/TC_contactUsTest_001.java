package com.automationexercises.testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationexercises.pageObjects.ContactUs;

public class TC_contactUsTest_001 extends TC_homePageTest_001{
	@Test (priority=2)
	public void contactUsTest() throws InterruptedException {
		
		
		ContactUs cu = new ContactUs(driver);
		
		cu.clickContactUs();
		
		
		AssertJUnit.assertEquals(cu.getFormHeadingText(), "GET IN TOUCH");
		
		cu.setName(name);

		cu.setEmail(email);
		
		cu.setSubject(subject);
		
		cu.setMessage(message);

		cu.fileUpload(filePath);
		
		cu.clickSubmit();
		

		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		
		cu.acceptAlert();
		
		AssertJUnit.assertEquals(cu.getSuccessMsg(), "Success! Your details have been submitted successfully.");
		
		cu.clickHome();
		String expected="Automation Exercise";
		String actual=cu.verifyHomePage();
		Assert.assertTrue(actual.contains(expected), "Expected: " + actual + " to contain: " + expected);

}
}
