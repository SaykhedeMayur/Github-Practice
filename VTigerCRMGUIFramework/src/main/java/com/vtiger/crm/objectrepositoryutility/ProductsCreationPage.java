package com.vtiger.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsCreationPage {

	// Object Initialization
	public ProductsCreationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	

	// Object Creation/Identification
	@FindBy(name = "productname")
	private WebElement productNameTxtField;

	@FindBy(xpath = "//input[@name='sales_start_date']")
	private WebElement salesStartDateTxtField;

	@FindBy(xpath = "//input[@name='sales_end_date']")
	private WebElement salesEndDateTxtField;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	

	// Object Utilization -> Single Element Utilization
	public WebElement getProductNameTxtField() {
		return productNameTxtField;
	}

	public WebElement getSalesStartDateTxtField() {
		return salesStartDateTxtField;
	}

	public WebElement getSalesEndDateTxtField() {
		return salesEndDateTxtField;
	}
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	

	// Object Utilization -> Multiple Element Utilization
	public void createProduct(String productName) {
		getProductNameTxtField().sendKeys(productName);
		getSaveBtn().click();
	}
	
	public void createProduct(String productName, String salesStartDate, String salesEndDate) {
		getProductNameTxtField().sendKeys(productName);
		getSalesStartDateTxtField().sendKeys(salesStartDate);
		getSalesEndDateTxtField().sendKeys(salesEndDate);
		getSaveBtn().click();
	}
}
