package com.vtiger.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsInfoPage {

	// Object Initialization
	public LeadsInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Object Creation
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headerMsg;

	@FindBy(id = "dtlview_Industry")
	private WebElement actIndustryName;
	
	@FindBy(id = "dtlview_Phone")
	private WebElement actPhoneNumber;


	// Object Utilization -> Single Element Utilization
	public WebElement getHeaderMsg() {
		return headerMsg;
	}

	public WebElement getActIndustryName() {
		return actIndustryName;
	}
	
	public WebElement getActPhoneNumber() {
		return actPhoneNumber;
	}

}
