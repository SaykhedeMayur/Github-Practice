package com.vtiger.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsInfoPage {
	
	// Object Initialization 
	public ContactsInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	// Object Creation/Identification 
	@FindBy(id = "dtlview_Last Name")
	private WebElement actLastName;
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headerMsg;
	
	@FindBy(id = "mouseArea_Organization Name")
	private WebElement actOrgName;
	
	@FindBy(id = "dtlview_Support Start Date")
	private WebElement actSupportStartDate;
	
	
	// Object Utilization -> Single Element Utilization 
	public WebElement getActLastName() {
		return actLastName;
	}

	public WebElement getHeaderMsg() {
		return headerMsg;
	}

	public WebElement getActOrgName() {
		return actOrgName;
	}

	public WebElement getActSupportStartDate() {
		return actSupportStartDate;
	}

	public WebElement getActSupprtEndDate() {
		return actSupprtEndDate;
	}

	@FindBy(id = "dtlview_Support End Date")
	private WebElement actSupprtEndDate;
	
	

}
