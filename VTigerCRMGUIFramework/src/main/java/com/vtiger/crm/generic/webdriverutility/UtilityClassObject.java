package com.vtiger.crm.generic.webdriverutility;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

/**
 * this class is to work with static variables in parallel execution
 * 
 * @author Mayur
 */
public class UtilityClassObject {
	
	/**creating an object for ThreadLocal class to store only ExtentTest type value*/
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();
	/**creating an object for ThreadLocal class to store only WebDriver type value*/
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	/**this method is for to get the value present inside test variable*/
	public static ExtentTest getTest() {
		return test.get();
	}
	
	/**this method is for to set the value into test variable*/
	public static void setTest(ExtentTest actTest) {
		test.set(actTest);;
	}
	
	/**this method is for to get the value present inside driver variable*/
	public static WebDriver getDriver() {
		return driver.get();
	}
	
	/**this method is for to set the value into driver variable*/
	public static void setDriver(WebDriver actDriver) {
		driver.set(actDriver);;
	}


}
