package com.vtiger.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsPage {
	
	// Object Initialization 
	public LeadsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	// Object Creation/Identification 
	@FindBy(xpath = "//img[@title='Create Lead...']")
	private WebElement createLeadBtn;

	
	// Object Utilization -> Single Elemenet Utilization
	public WebElement getCreateLeadBtn() {
		return createLeadBtn;
	}
	
	

}
