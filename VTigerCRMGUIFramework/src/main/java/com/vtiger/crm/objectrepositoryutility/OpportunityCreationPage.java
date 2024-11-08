package com.vtiger.crm.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.crm.generic.webdriverutility.WebDriverUtility;

public class OpportunityCreationPage {

	// Object Initialization
	public OpportunityCreationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Object Creation/Identification
	@FindBy(name = "potentialname")
	private WebElement oppoNameTxtField;

	@FindBy(xpath = "//img[@title='Select']")
	private WebElement ralatedToBtn;

	@FindBy(id = "search_txt")
	private WebElement searchTxtField;

	@FindBy(name = "search")
	private WebElement searchBtn;
	
	@FindBy(id = "jscal_field_closingdate")
	private WebElement expectedCloseDateTxtField;
	
	@FindBy(name = "amount")
	private WebElement amountTxtField;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	
	// Object Utilization -> Single Element Utilization
	public WebElement getOppoNameTxtField() {
		return oppoNameTxtField;
	}

	public WebElement getRalatedToBtn() {
		return ralatedToBtn;
	}

	public WebElement getSearchTxtField() {
		return searchTxtField;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getExpectedCloseDateTxtField() {
		return expectedCloseDateTxtField;
	}
	
	public WebElement getAmountTxtField() {
		return amountTxtField;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	// Object Utilization -> Multiple Elements Utilization
	public void createOpportunities(WebDriver driver, String oppoName, String orgName, String childUrl, String parentUrl) {
		getOppoNameTxtField().sendKeys("-" + oppoName);
		getRalatedToBtn().click();
		WebDriverUtility wdu = new WebDriverUtility();
		wdu.switchToTabOnURL(driver, childUrl);
		getSearchTxtField().sendKeys(orgName);
		getSearchBtn().click();
		driver.findElement(By.xpath("//a[text()='" + orgName + "']")).click();
		wdu.switchToTabOnURL(driver, parentUrl);
		getSaveBtn().click();
	}
	
	public void createOpportunities(WebDriver driver, String oppoName, String orgName, String childUrl, String parentUrl, String expectedCloseDate) {
		getOppoNameTxtField().sendKeys("-" + oppoName);
		getRalatedToBtn().click();
		WebDriverUtility wdu = new WebDriverUtility();
		wdu.switchToTabOnURL(driver, childUrl);
		getSearchTxtField().sendKeys(orgName);
		getSearchBtn().click();
		driver.findElement(By.xpath("//a[text()='" + orgName + "']")).click();
		wdu.switchToTabOnURL(driver, parentUrl);
		getExpectedCloseDateTxtField().clear();
		getExpectedCloseDateTxtField().sendKeys(expectedCloseDate);
		getSaveBtn().click();
	}
	
	public void createOpportunitiesWithAmount(WebDriver driver, String oppoName, String orgName, String childUrl, String parentUrl, String amount) {
		getOppoNameTxtField().sendKeys("-" + oppoName);
		getRalatedToBtn().click();
		WebDriverUtility wdu = new WebDriverUtility();
		wdu.switchToTabOnURL(driver, childUrl);
		getSearchTxtField().sendKeys(orgName);
		getSearchBtn().click();
		driver.findElement(By.xpath("//a[text()='" + orgName + "']")).click();
		wdu.switchToTabOnURL(driver, parentUrl);
		getAmountTxtField().clear();
		getAmountTxtField().sendKeys(amount);
		getSaveBtn().click();
	}
	
	
	
	
	

}
