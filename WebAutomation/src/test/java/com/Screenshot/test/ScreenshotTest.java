package com.Screenshot.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListener.class)

public class ScreenshotTest extends Base {

	@BeforeMethod
	public void setUp() {

		initialization();

	}

	@Test
	public void FBScreenshotTest01() {

		String title = driver.getTitle();

		Assert.assertEquals(title, "Facebook – log in or sign u");

	}
	
	@Test
	public void FBScreenshotTest02() {

		String title = driver.getTitle();

		Assert.assertEquals(title, "Facebook – log in or sign u");

	}

	@AfterMethod
	public void tearDown() {

			driver.quit();
		
	}

}
