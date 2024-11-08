package com.vtiger.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsInfoPage {

	// Object Intialization
	public ProductsInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Object Creation
	@FindBy(id = "dtlview_Product Name")
	private WebElement actProductName;
	
	@FindBy(id = "dtlview_Sales Start Date")
	private WebElement actSalesStartDate;
	
	@FindBy(id = "dtlview_Sales End Date")
	private WebElement actSalesEndDate;

	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement headerMsg;

	
	// Object Utilization -> Single Element Utilization
	public WebElement getActProductName() {
		return actProductName;
	}

	public WebElement getActSalesStartDate() {
		return actSalesStartDate;
	}

	public WebElement getActSalesEndDate() {
		return actSalesEndDate;
	}
	
	public WebElement getHeaderMsg() {
		return headerMsg;
	}


}
