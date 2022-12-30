package com.automationexercises.testCases;


import org.testng.annotations.Test;
import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

import com.automationexercises.pageObjects.ProductPage;

public class TC_productPageTest_001 extends TC_homePageTest_001 {
	@Test (priority=2)
	public void productPageTest() throws InterruptedException {
		
		
		 ProductPage pg=new ProductPage(driver);
		 
		 pg.clickProduct();
		 pg.verifyProductsPage();
		 pg.searchProduct();
		 pg.verifySearchedProducts();
		 pg.viewProduct();
		 pg.handleCartModal();
		 pg.cart();
		 pg.sign();

}
}
