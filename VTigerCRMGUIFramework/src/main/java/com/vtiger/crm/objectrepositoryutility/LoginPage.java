package com.vtiger.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.crm.generic.webdriverutility.WebDriverUtility;

public class LoginPage extends WebDriverUtility {
	WebDriver driver;
	// Rule-3 :- Object Initialization
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// Rule-1 :- Create a Separate Java Class for Each WebPage of Application
	// Rule-2 :- Object Creation/ Object Identification  
	
	@FindBy(name="user_name")
	private WebElement usernameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;

	
	// Rule-4 :- Object Encapsulation 
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	
	// Rule-5 :- Provide Action / Business Liabraries 
	public void loginToApp(String url, String username, String password) {
		driver.manage().window().maximize();
		waitForPageToLoad(driver);
		driver.get(url);
		getUsernameEdt().sendKeys(username);
		getPasswordEdt().sendKeys(password);
		getLoginBtn().click();
	}
	
	
	

}
