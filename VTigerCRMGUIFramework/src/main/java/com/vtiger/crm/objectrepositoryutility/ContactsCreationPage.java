package com.vtiger.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsCreationPage {

	// Object Initialization
	public ContactsCreationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	

	// Object Creation/Identification
	@FindBy(name = "lastname")
	private WebElement lastNameTxtField;

	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img")
	private WebElement selectOrgBtn;

	@FindBy(id = "search_txt")
	private WebElement searchTxtField;

	@FindBy(name = "search")
	private WebElement searchBtn;
	
	@FindBy(name = "support_start_date")
	private WebElement supportStartDateTxtField;
	
	@FindBy(name = "support_end_date")
	private WebElement supportEndDateTxtField;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	

	// Object Utilization -> Single Element Utilization
	public WebElement getLastNameTxtField() {
		return lastNameTxtField;
	}

	public WebElement getSelectOrgBtn() {
		return selectOrgBtn;
	}

	public WebElement getSearchTxtField() {
		return searchTxtField;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
	public WebElement getSupportStartDateTxtField() {
		return supportStartDateTxtField;
	}

	public WebElement getSupportEndDateTxtField() {
		return supportEndDateTxtField;
	}
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	
	// Object Utilization -> Multiple Elements Utilization 
	public void createContact(String lastName) {
		getLastNameTxtField().sendKeys(lastName);
		getSaveBtn().click();
	}
	
	public void createContact(String lastName, String supportStartDate, String supportEndDate) {
		getLastNameTxtField().sendKeys(lastName);
		getSupportStartDateTxtField().clear();
		getSupportStartDateTxtField().sendKeys(supportStartDate);
		getSupportEndDateTxtField().clear();
		getSupportEndDateTxtField().sendKeys(supportEndDate);
		getSaveBtn().click();
	}
	
	

}
