package com.vtiger.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgInfoPage {
	
	// Object Initialization 
	public OrgInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	// Object Creation/Identification 
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headerMsg;
	
	@FindBy(xpath = "//span[@id='dtlview_Organization Name']")
	private WebElement actOrgName;
	
	@FindBy(id = "dtlview_Industry")
	private WebElement actIndustryName;
	
	@FindBy(id = "dtlview_Type") 
	private WebElement actIndustryType;
	
	@FindBy(id = "dtlview_Phone") 
	private WebElement actPhoneNumber;
	
	
	// Object Utilization -> Single Element Utilization 
	public WebElement getHeaderMsg() {
		return headerMsg;
	}

	public WebElement getActOrgName() {
		return actOrgName;
	}

	public WebElement getActIndustryName() {
		return actIndustryName;
	}

	public WebElement getActIndustryType() {
		return actIndustryType;
	}

	public WebElement getActPhoneNumber() {
		return actPhoneNumber;
	}
	
	
	
	

}
