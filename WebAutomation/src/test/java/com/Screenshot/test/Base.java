package com.Screenshot.test;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

	public static WebDriver driver;

	public void initialization() {
		
		//For MAC chrome driver permission terminal command :  xattr -d com.apple.quarantine chromedriver
		System.setProperty("webdriver.chrome.driver",
				"/Users/wrp/git/SeleniumAutomation-Web/WebAutomation/src/test/resources/Drivers/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.get("https://www.facebook.com/");

	}

	public void failed(String testMethodName) {
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile,
					new File("/Users/wrp/git/SeleniumAutomation-Web/WebAutomation/src/test/resources/"
							+ "Screenshots/" + "snapshot_"+testMethodName+".jpg"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
