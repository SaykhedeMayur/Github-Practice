package com.vtiger.crm.productpomtest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.vtiger.crm.basetest.BaseClass;
import com.vtiger.crm.generic.webdriverutility.UtilityClassObject;
import com.vtiger.crm.listenerutility.Listener_Implementation_Class;
import com.vtiger.crm.objectrepositoryutility.HomePage;
import com.vtiger.crm.objectrepositoryutility.ProductsCreationPage;
import com.vtiger.crm.objectrepositoryutility.ProductsInfoPage;
import com.vtiger.crm.objectrepositoryutility.ProductsPage;


/**
 * Test Script of Products Module
 * 
 * @author Mayur
 */

@Listeners(Listener_Implementation_Class.class)
public class Create_Product_Test extends BaseClass {

	@Test
	public void createProductTest() throws Throwable {

		/** Reading the data from Excel File */
		UtilityClassObject.getTest().log(Status.INFO, "Read the data from Excel File");
		String productName = eLib.getDataFromExcelFile("product", 7, 2) + jLib.getRandomNumber();

		/** Step 2 :- Navigate to Products Module */
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Products Module");
		HomePage hp = new HomePage(driver);
		hp.getProductsLink().click();

		/** Step 3 :- Click on "Create Products" Button */
		UtilityClassObject.getTest().log(Status.INFO, "On Create Products Page");
		ProductsPage productsPage = new ProductsPage(driver);
		productsPage.getCreateProductsBtn().click();

		/** Step 4 :- Enter all the details & Create New Product */
		UtilityClassObject.getTest().log(Status.INFO, "Create a New Product");
		ProductsCreationPage pcp = new ProductsCreationPage(driver);
		pcp.createProduct(productName);

		/** Verify Header Message -> Expected Result */
		ProductsInfoPage pip = new ProductsInfoPage(driver);
		String headerInfo = pip.getHeaderMsg().getText();
		boolean status1 = headerInfo.contains(productName);
		Assert.assertEquals(status1, true);

		/** Verify Product Name should be displayed in Product Info Page */
		String actProductName = pip.getActProductName().getText();
		boolean status2 = actProductName.contains(productName);
		Assert.assertEquals(status2, true);

	}

	@Test
	public void createProductAndSearchByProductNameTest() throws Throwable {

		/** Reading the data from Excel File */
		UtilityClassObject.getTest().log(Status.INFO, "Read the data from Excel File");
		String productName = eLib.getDataFromExcelFile("product", 7, 2) + jLib.getRandomNumber();

		/** Step 2 :- Navigate to Products Module */
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Products Module");
		HomePage hp = new HomePage(driver);
		hp.getProductsLink().click();

		/** Step 3 :- Click on "Create Products" Button */
		UtilityClassObject.getTest().log(Status.INFO, "On Create Products Page");
		ProductsPage productsPage = new ProductsPage(driver);
		productsPage.getCreateProductsBtn().click();

		/** Step 4 :- Enter all the details & Create New Product */
		UtilityClassObject.getTest().log(Status.INFO, "Create a New Product");
		ProductsCreationPage pcp = new ProductsCreationPage(driver);
		pcp.createProduct(productName);

		/** Navigate to Products Details Page */
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Products Details Page");
		hp.getProductsLink().click();

		WebElement searchProductDropDown = driver.findElement(By.id("bas_searchfield"));
		wLib.selectByValue(searchProductDropDown, "productname");
		driver.findElement(By.name("search_text")).sendKeys(productName, Keys.ENTER);

		/** Verify Product Name should be displayed in Products Details Page */
		Thread.sleep(2000);
		
		String actProductName = driver.findElement(By.xpath("//a[@title='Products']")).getText();
		boolean status = actProductName.contains(productName);
		Assert.assertEquals(status, true);
	}

	@Test
	public void createProductWithSalesStartAndEndDateTest() throws Throwable {

		/** Reading the data from Excel File */
		UtilityClassObject.getTest().log(Status.INFO, "Read the data from Excel File");
		String productName = eLib.getDataFromExcelFile("product", 4, 2) + jLib.getRandomNumber();

		/** Step 2 :- Navigate to Products Module */
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Products Module");
		HomePage hp = new HomePage(driver);
		hp.getProductsLink().click();

		/** Step 3 :- Click on "Create Lead" Button */
		UtilityClassObject.getTest().log(Status.INFO, "On Create Lead Page");
		ProductsPage productsPage = new ProductsPage(driver);
		productsPage.getCreateProductsBtn().click();

		/** Step 4 :- Enter all the details & Create New Lead */
		UtilityClassObject.getTest().log(Status.INFO, "Create a New Product With Sales Start & End Date");

		/** Fetching The Current and RequiedDate */
		String salesStartDate = jLib.getSystemDateYYYYMMDD();
		String salesEndDate = jLib.getRequiredDateYYYYMMDD(8);

		ProductsCreationPage pcp = new ProductsCreationPage(driver);
		pcp.createProduct(productName, salesStartDate, salesEndDate);

		/** Verify Sales Start Date should be displayed in Product Info Page */
		ProductsInfoPage pip = new ProductsInfoPage(driver);
		String actStartDate = pip.getActSalesStartDate().getText();
		boolean status1 = actStartDate.contains(salesStartDate);
		Assert.assertEquals(status1, true);

		/** Verify Sales End Date should be displayed in Product Info Page */
		String actEndDate = pip.getActSalesEndDate().getText();
		boolean status2 = actEndDate.contains(salesEndDate);
		Assert.assertEquals(status2, true);
	}

}
