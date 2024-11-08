package com.vtiger.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunitiesPage {
	
	// Object Initialization 
	public OpportunitiesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	// Object Creation/Identification 
	@FindBy(xpath = "//img[@title='Create Opportunity...']")
	private WebElement createOpportunityBtn;
	
	
	// Object Utilization -> Single Element Utilization 
	public WebElement getCreateOpportunityBtn() {
		return createOpportunityBtn;
	}
	
	
}
