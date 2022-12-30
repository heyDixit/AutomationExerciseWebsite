package com.automationexercises.reusable;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class SearchFunctionality {
	Actions action;
	public SearchFunctionality(WebDriver driver) {
		action=new Actions(driver);
	}
	
	public void pressEnter() {
		action.sendKeys(Keys.ENTER).build().perform();
	}
	public void scrollDown(WebDriver driver) {
		JavascriptExecutor executor=(JavascriptExecutor)driver;
		executor.executeScript("window.scrollBy(0,2000)","");
	}
	public void performMouseHover(WebElement element) {
		action.moveToElement(element).build().perform();
	}
	public void clickUsingJavaScriptExecutor(WebElement element, WebDriver driver) {
		JavascriptExecutor executor=(JavascriptExecutor)driver;
		executor.executeScript("argument[0].click();", element); 

	}
	
	
	
}
