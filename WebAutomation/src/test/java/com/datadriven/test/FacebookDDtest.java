package com.datadriven.test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.test.utility.TestUtil;

public class FacebookDDtest {
	
	WebDriver driver;
	
	@BeforeMethod
	@Parameters ({"url"})
	public void setUp(String url) {
		
		
		//For MAC chrome driver permission terminal command :  xattr -d com.apple.quarantine chromedriver
		System.setProperty("webdriver.chrome.driver", "/Users/wrp/git/SeleniumAutomation-Web/WebAutomation/src/test/resources/Drivers/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
		driver.get(url);
	}
	
	
	@DataProvider
	public Iterator<Object[]> getTestData() {
		
		ArrayList<Object[]> testData = TestUtil.getDataFromExcel();
		return testData.iterator();
	}
	
	
	@Test (dataProvider = "getTestData")
	public void FacebookloginTest(String username, String password) throws InterruptedException {
		
		WebElement usr  = driver.findElement(By.xpath("//input[@id='email']"));
		usr.sendKeys(username);
		
		WebElement pass  = driver.findElement(By.xpath("//input[@id='pass']"));
		pass.sendKeys(password);
		
		Thread.sleep(2000);
		
	}
	
	@AfterMethod
	public void tearDown() {
		
		if (driver != null) {
			
			driver.quit();
		}
	}

}
