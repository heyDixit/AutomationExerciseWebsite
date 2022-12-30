package com.automationexercises.pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.automationexercises.reusable.SearchFunctionality;

public class ProductPage{
	WebDriver ldriver;
	public ProductPage(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath="//a[@href='/products']")
	@CacheLookup
	WebElement productsNavBtn;
	
	@FindBy(id="search_product")
	@CacheLookup
	WebElement searchInput;	
	
	@FindBy(id="submit_search")
	@CacheLookup
	WebElement searchBtn;	
	
	
	
	@FindBy(css=".features_items .title")
	@CacheLookup
	WebElement verifyProductText;
	
	//input[@name='login'and @type='submit']
	
	
	@FindBy(xpath="//a[@data-product-id='1']")
	@CacheLookup
	WebElement btnToHover;
	
	
	
	@FindBy(css=".product-overlay a")
	@CacheLookup
	WebElement btnToClick;
	
	
	@FindBy(css=".single-products")
	@CacheLookup
	WebElement addHover;
	
	@FindBy(css=".add-to-cart")
	@CacheLookup
	WebElement add;
	
	
	
	@FindBy(id="cartModal")
	@CacheLookup
	WebElement cartModal;
	
	@FindBy(xpath="//a[@href='/view_cart']")
	@CacheLookup
	WebElement viewCartLink;
	
	@FindBy(css="button.btn:nth-child(1)")
	@CacheLookup
	WebElement continueShopBtn;
	
	@FindBy(css="a.btn")
	@CacheLookup
	WebElement proceedCheckoutBtn;
	
	@FindBy(id="checkoutModal")
	@CacheLookup
	WebElement checkoutModal;
	
	@FindBy(xpath="//a[@href='/login']")
	@CacheLookup
	WebElement loginBtn;
	
	
	
	
	
	//Actions on element
	public void clickProduct() {
		try {
			productsNavBtn.click();
			List<WebElement> adSize = ldriver.findElements(By.cssSelector("iframe[src$='//automationexercise.com'][style*='display: inline']"));

					if (adSize.size() >= 1) {

					WebElement frame1 = ldriver.findElement(By.cssSelector("iframe[src$='//automationexercise.com'][style*='display: inline']"));
					ldriver.switchTo().frame(frame1);
					WebElement frame2 = ldriver.findElement(By.id("ad_iframe"));
					ldriver.switchTo().frame(frame2);
					ldriver.findElement(By.id("dismiss-button")).click();
					ldriver.switchTo().defaultContent();
					ldriver.switchTo().defaultContent();
					}	
			}
		catch(Exception e) {
			System.out.println("Exception Caught"+ e.getMessage());
		}
	}
	
	public void verifyProductsPage() {
		String title =ldriver.getTitle();
		String expected="Automation Exercise - All Products";
		String actual=title;
		Assert.assertTrue(actual.contains(expected), "Expected: " + actual + " to contain: " + expected);
	}
	
	public void searchProduct() {
		searchInput.sendKeys("Blue Top");
		searchBtn.click();
	}
	
	public void verifySearchedProducts() {
		String expected="SEARCHED PRODUCTS";
		String actual=verifyProductText.getText();
		Assert.assertTrue(actual.contains(expected), "Expected: " + actual + " to contain: " + expected);
	}
	
	

	public void viewProduct() {
//		SearchFunctionality objSearch=new SearchFunctionality(ldriver);
		JavascriptExecutor js = (JavascriptExecutor) ldriver;
		js.executeScript("window.scrollBy(0,250)", "");
		Actions action=new Actions(ldriver);
		action.moveToElement(addHover).build().perform();
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("add-to-cart")));
		action.moveToElement(add);
		action.click().build().perform();
		
	}
	
	public void handleCartModal() {
		continueShopBtn.click();
	}
	
	public void cart() {
		viewCartLink.click();
		proceedCheckoutBtn.click();
		checkoutModal.click();
		loginBtn.click();
		
	}
	
	
	

}
