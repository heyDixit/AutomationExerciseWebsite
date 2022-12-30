package com.automationexercises.testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	
	public String baseURL="https://automationexercise.com/";
	public static WebDriver driver;
	public String filePath ="/Users/ankitdixit/Downloads/abc.jpg";
	public String name="Rudra";
	public String email="abc@ghi.com";
	public String subject="To automate";
	public String message="a boy with a gun";
	
	
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver","/Users/ankitdixit/Downloads/chromedriver");
		ChromeOptions options = new ChromeOptions();

		options.setExperimentalOption("excludeSwitches",Arrays.asList("disable-popup-blocking"));
		driver = new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}
	
	@AfterMethod
	@AfterClass
	public void tearDown() {
//		driver.quit();
	}
}
