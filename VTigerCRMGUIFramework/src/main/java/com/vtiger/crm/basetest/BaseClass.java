package com.vtiger.crm.basetest;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.vtiger.crm.generic.databaseutility.DataBaseUtility;
import com.vtiger.crm.generic.fileutility.ExcelUtility;
import com.vtiger.crm.generic.fileutility.FileUtility;
import com.vtiger.crm.generic.webdriverutility.JavaUtility;
import com.vtiger.crm.generic.webdriverutility.UtilityClassObject;
import com.vtiger.crm.generic.webdriverutility.WebDriverUtility;
import com.vtiger.crm.objectrepositoryutility.HomePage;
import com.vtiger.crm.objectrepositoryutility.LoginPage;

/**
 * this class is created for Configuration steps. Like connecting to DB,
 * Lunching and Tearing the browser instance, login and logout etc.
 * 
 * @author Mayur
 */
public class BaseClass {

	/** Create Object */
	public DataBaseUtility dbLib = new DataBaseUtility();
	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public JavaUtility jLib = new JavaUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public WebDriver driver = null;
	public static WebDriver sdriver = null;

	@BeforeSuite(groups = { "smokeTest", "regressionTest" })
	public void configBeforeSuite() {
		System.out.println("==== Connect To DB ====");

		/** Connecting To DataBase */
		dbLib.getDBConnection();
	}

	// @Parameters("BROWSER")
	@BeforeClass(groups = { "smokeTest", "regressionTest" })
	public void configBeforeClass() throws Throwable {
		System.out.println("==Launch The Browser==");

		// @Optional("chrome") String browser
		/** Getting the data from testng.xml file */
		// String BROWSER = browser;

		/** Fetching the data from maven command line */
		String BROWSER = System.getProperty("browser", fLib.getDataFromPropertiesFile("browser"));
		/** Launching Browser using RunTime Polymorphism */
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		sdriver = driver;
		UtilityClassObject.setDriver(sdriver);
	}

	@BeforeMethod(groups = { "smokeTest", "regressionTest" })
	public void configBeforeMethod() throws Throwable {
		System.out.println("==Login To App==");

		/** Reading the data from Properties File */
//		String URL = fLib.getDataFromPropertiesFile("url");
//		String USERNAME = fLib.getDataFromPropertiesFile("username");
//		String PASSWORD = fLib.getDataFromPropertiesFile("password");

		/** Fetching the data from maven command line or .properties file */
		/**
		 * If we forget to pass data from maven cmd line then below method will fetch
		 * the data from .properties file
		 */
		String URL = System.getProperty("url", fLib.getDataFromPropertiesFile("url"));
		String USERNAME = System.getProperty("username", fLib.getDataFromPropertiesFile("username"));
		String PASSWORD = System.getProperty("password", fLib.getDataFromPropertiesFile("password"));

		/** Login From Application */
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(URL, USERNAME, PASSWORD);
	}

	@AfterMethod(groups = { "smokeTest", "regressionTest" })
	public void configAfterMethod() {
		System.out.println("==Logout From App==");

		/** Logout From Application */
		HomePage hp = new HomePage(driver);
		hp.logout();
	}

	@AfterClass(groups = { "smokeTest", "regressionTest" })
	public void configAfterClass() {
		System.out.println("==Close The Browser==");

		/** Tear Down The Browser */
		driver.quit();
	}

	@AfterSuite(groups = { "smokeTest", "regressionTest" })
	public void configAfterSuite() throws SQLException {
		System.out.println("====Close DB, Report BackUp====");

		/** Closing The Connection From DataBase */
		dbLib.closeDBConnection();
	}

}
