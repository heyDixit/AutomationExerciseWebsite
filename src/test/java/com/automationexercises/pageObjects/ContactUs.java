package com.automationexercises.pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;


public class ContactUs {
	WebDriver ldriver;
	public ContactUs(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(linkText="Contact us")
	@CacheLookup
	WebElement contactUs;
	
	@FindBy(css=".contact-form .title")
	@CacheLookup
	public
	WebElement formHeading;
	
	@FindBy(name="name")
	@CacheLookup
	WebElement nameInput;
	
	@FindBy(name="email")
	@CacheLookup
	WebElement emailField;
	
	@FindBy(name="subject")
	@CacheLookup
	WebElement subject;
	
	@FindBy(id="message")
	@CacheLookup
	WebElement messageDesc;
	
	@FindBy(name="upload_file")
	@CacheLookup
	WebElement upload;
	
	
	@FindBy(name="submit")
	@CacheLookup
	WebElement submitBtn;
	
	@FindBy(css=".contact-form .status")
	@CacheLookup
	WebElement successMsg;
	
	@FindBy(linkText="Home")
	@CacheLookup
	WebElement homeNavBtn;
	
	

	
	// For the above elements we will now have our action methods
	
	public void clickContactUs() {
		try {
			contactUs.click();
			Reporter.log("Contact Us Clicked");
		}
		catch(Exception e) {
			System.out.println("Exception Caught"+ e.getMessage());
		}
	}
	
	public void setName(String name) {
		nameInput.sendKeys(name);
	}
	
	public void setEmail(String email) {
		emailField.sendKeys(email);
	}
	
	public void setSubject(String subjectText) {
		subject.sendKeys(subjectText);
	}
	
	public void setMessage(String messageText) {
		messageDesc.sendKeys(messageText);
	}
	
	public void fileUpload(String filePath) {
		upload.sendKeys(filePath);
	}
	
	public void clickSubmit() {
		submitBtn.click();
		Reporter.log("Feedback Submit");
	}
	
	
	public void acceptAlert() {
		
		 Alert alert = ldriver.switchTo().alert();  //We need to switch from the website to the alert box
	     alert.accept();
	     Reporter.log("Alert on contact us page accepted");
	}

	public String getFormHeadingText() {
		return formHeading.getText();
	}


	public String getSuccessMsg() {
		// TODO Auto-generated method stub
		Reporter.log("Verify Success Message");
		return successMsg.getText();
	}
	
	public void clickHome() {
		homeNavBtn.click();
		Reporter.log("Home on nav clicked");
	}
	
	public String verifyHomePage() {
			Reporter.log("Homepage Verified");
		 return ldriver.getTitle();
		 
	}
}
