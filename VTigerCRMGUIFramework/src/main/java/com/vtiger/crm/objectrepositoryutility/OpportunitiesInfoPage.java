package com.vtiger.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunitiesInfoPage {

	// Object Initialization
	public OpportunitiesInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	

	// Object Creation/Identification
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headerMsg;

	@FindBy(id = "dtlview_Opportunity Name")
	private WebElement actOppoName;

	@FindBy(xpath = "//a[@title='Organizations']")
	private WebElement actRelatedTo;
	
	@FindBy(xpath = "//td[text()='Expected Close Date']/following-sibling::td")
	private WebElement actExpectedCloseDate;
	
	@FindBy(id = "dtlview_Amount")
	private WebElement actAmount;
	

	// Object Utilization -> Single Element Utilization
	public WebElement getHeaderMsg() {
		return headerMsg;
	}

	public WebElement getActOppoName() {
		return actOppoName;
	}

	public WebElement getActRelatedTo() {
		return actRelatedTo;
	}
	
	public WebElement getActExpectedCloseDate() {
		return actExpectedCloseDate;
	}
	
	public WebElement getActAmount() {
		return actAmount;
	}

}
