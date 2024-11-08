package com.vtiger.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgPage {
	
	// Object Initialization 
	public OrgPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	// Object Creation 
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement createOrgBtn;
	
	
	// Object Utilization -> Single Element Utilization 
	public WebElement getCreateOrgBtn() {
		return createOrgBtn;
	} 

}
