package com.vtiger.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.crm.generic.webdriverutility.WebDriverUtility;

public class LeadCreationPage {
	
	// Object Initialization 
	public LeadCreationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	// Object Creation/Identification 
	@FindBy(name = "lastname")
	private WebElement lastNameTxtField;

	@FindBy(name = "company")
	private WebElement companyNameTxtField;
		
	@FindBy(name = "industry")
	private WebElement industryDropDown;
	
	@FindBy(id = "phone")
	private WebElement phoneNumberTxtField;
		
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	
	// Object Utilization -> Single Element Utilization
	public WebElement getLastNameTxtField() {
		return lastNameTxtField;
	}

	public WebElement getCompanyNameTxtField() {
		return companyNameTxtField;
	}
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}

	
	// Object Utilization -> Multiple Element Utilization 
	public void createLead(String lastName, String companyName) {
		getLastNameTxtField().sendKeys(lastName);
		getCompanyNameTxtField().sendKeys(companyName);
		getSaveBtn().click();
	}
	
	public void createLead(String lastName, String companyName, String industryType) {
		getLastNameTxtField().sendKeys(lastName);
		getCompanyNameTxtField().sendKeys(companyName);
		WebDriverUtility wdu = new WebDriverUtility();
		wdu.selectByValue(industryDropDown, industryType);
		getSaveBtn().click();
	}
	
	public void createLeadWithPhoneNumber(String lastName, String companyName, String phoneNumber) {
		getLastNameTxtField().sendKeys(lastName);
		getCompanyNameTxtField().sendKeys(companyName);
		phoneNumberTxtField.sendKeys(phoneNumber);
		getSaveBtn().click();
	}

	


}
