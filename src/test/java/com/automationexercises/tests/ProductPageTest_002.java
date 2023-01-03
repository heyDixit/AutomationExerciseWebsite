package com.automationexercises.tests;


import org.testng.annotations.Test;


import org.testng.Assert;




import com.automationexercises.pageObjects.ContactUs;
import com.automationexercises.pageObjects.ProductPage;
import com.automationexercises.reusable.ReUse;

public class ProductPageTest_002 extends ContactUsTest_001{
	ContactUs cu;
	ReUse ru;
	ProductPage pg;
	
	@Test(priority=7)
	public void homePage() {
		driver.get(baseURL);
		if(driver.getTitle().equals("Automation Exercise")) {
			 Assert.assertTrue(true);
		 }
		 else {
			 Assert.assertTrue(false);
		 }	
	}
	
	@Test(priority=8)
	public void clickProductValidation() {
		pg=new ProductPage(driver);
		pg.clickProduct();
		pg.verifyProductsPage();
	}
	
	@Test(priority=9)
	public void searchedProductsValidation() throws InterruptedException {
		
		
		 pg.searchProduct();
		 pg.verifySearchedProducts();
	}
	
	@Test(priority=10)
	public void cartValidation() throws InterruptedException {
		pg.addToCart();
		pg.handleCartModal();
		pg.cart();
		pg.sign();
	}
	
	

}
