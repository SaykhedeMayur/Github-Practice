package com.vtiger.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.crm.generic.webdriverutility.WebDriverUtility;

public class OrgCreationPage {
	
	// Object Initialization 
	public OrgCreationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	// Object Creation 
	@FindBy(name = "accountname")
	private WebElement orgNameTxtField;
	
	@FindBy(name = "industry")
	private WebElement industryDropDown;
	
	@FindBy(name = "accounttype")
	private WebElement typeDropDown;
	
	@FindBy(id = "phone")
	private WebElement phoneNumberTxtField;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	

	// Object Utilization -> Single Element UtilizaTion
	public WebElement getOrgNameTxtField() {
		return orgNameTxtField;
	}

	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}
	

	public WebElement getTypeDropDown() {
		return typeDropDown;
	}

	public WebElement getPhoneNumberTxtField() {
		return phoneNumberTxtField;
	}
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	
	// Object Utilization -> Multiple Elements Utilization 
	public void createOrg(String orgName) {
		getOrgNameTxtField().sendKeys(orgName);
		getSaveBtn().click();
	}
	
	public void createOrg(String orgName, String industryName, String type) {
		getOrgNameTxtField().sendKeys(orgName);
		WebDriverUtility wdu= new WebDriverUtility();
		wdu.selectByValue(industryDropDown, industryName);
		wdu.selectByValue(typeDropDown, type);
		getSaveBtn().click();
	}
	
	public void createOrgByPhoneNumber(String orgName, String phoneNumber) {
		getOrgNameTxtField().sendKeys(orgName);
		getPhoneNumberTxtField().sendKeys(phoneNumber);
		getSaveBtn().click();
	}
	
}
