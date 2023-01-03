package com.automationexercises.reusable;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	
	public String baseURL="https://automationexercise.com/";
	public static WebDriver driver;
	public String filePath ="/Users/ankitdixit/Downloads/abc.jpg";
	public String name="Rudra";
	public String email="abc@ghi.com";
	public String subject="To automate";
	public String message="a boy with a gun";
	public String chromePath="/Users/ankitdixit/Downloads/chromedriver";
	public String firefoxPath= "/Users/ankitdixit/Downloads/geckodriver";
	
	

	public void setup(String browser) throws Exception {
		//Check if parameter passed from TestNG is 'firefox'
		if(browser.equalsIgnoreCase("firefox")){
		//create firefox instance
			System.setProperty("webdriver.gecko.driver",firefoxPath);
			driver = new FirefoxDriver();
		}
		//Check if parameter passed as 'chrome'
		else if(browser.equalsIgnoreCase("chrome")){
			//set path to chromedriver.exe
			System.setProperty("webdriver.chrome.driver",chromePath);
			//create chrome instance
			driver = new ChromeDriver();
		}
		else{
			//If no browser passed throw exception
			throw new Exception("Browser is not correct");
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}
	
	public void tearDown() {
		driver.quit();
	}
}
