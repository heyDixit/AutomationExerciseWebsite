package com.automationexercises.reusable;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ReUse {
	Actions action;
	WebDriver driver;
	public ReUse(WebDriver driver) {
		action=new Actions(driver);
		this.driver=driver;
	}
	public void txtVerification(String Orignal, String Expected) {
		Assert.assertEquals(Orignal, Expected);
	}	
	public void waitForAlert() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
	}
		
}
