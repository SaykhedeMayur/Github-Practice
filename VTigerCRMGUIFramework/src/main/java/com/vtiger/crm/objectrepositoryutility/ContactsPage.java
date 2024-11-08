package com.vtiger.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	
	// Object Initialization 
	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	// Object Creation/Identification 
	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement createContactBtn;

	
	// Object Utilization -> Single Element Utilization 
	public WebElement getCreateContactBtn() {
		return createContactBtn;
	}
	

}
