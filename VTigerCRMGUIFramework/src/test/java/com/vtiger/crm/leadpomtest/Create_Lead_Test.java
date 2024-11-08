package com.vtiger.crm.leadpomtest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.vtiger.crm.basetest.BaseClass;
import com.vtiger.crm.generic.webdriverutility.UtilityClassObject;
import com.vtiger.crm.listenerutility.Listener_Implementation_Class;
import com.vtiger.crm.objectrepositoryutility.HomePage;
import com.vtiger.crm.objectrepositoryutility.LeadCreationPage;
import com.vtiger.crm.objectrepositoryutility.LeadsInfoPage;
import com.vtiger.crm.objectrepositoryutility.LeadsPage;


/**
 * Test Script of Lead Module
 * 
 * @author Mayur
 */

@Listeners(Listener_Implementation_Class.class)
public class Create_Lead_Test extends BaseClass {

	@Test
	public void createLeadTest() throws Throwable {

		/** Fetching the Data from Excel File */
		UtilityClassObject.getTest().log(Status.INFO, "Read the data from Excel File");
		String companyName = eLib.getDataFromExcelFile("lead", 1, 2) + jLib.getRandomNumber();
		String lastName = eLib.getDataFromExcelFile("lead", 1, 3) + jLib.getRandomNumber();

		/** Step 2 :- Navigate to Leads Module */
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Leads Module");
		HomePage hp = new HomePage(driver);
		hp.getLeadsLink().click();

		/** Step 3 :- Click on "Create Lead" Button */
		UtilityClassObject.getTest().log(Status.INFO, "On Create Lead Page");
		LeadsPage leadsPage = new LeadsPage(driver);
		leadsPage.getCreateLeadBtn().click();

		/** Step 4 :- Enter all the details & Create New Lead */
		UtilityClassObject.getTest().log(Status.INFO, "Create a New Lead");
		LeadCreationPage lcp = new LeadCreationPage(driver);
		lcp.createLead(lastName, companyName);
		UtilityClassObject.getTest().log(Status.INFO, "Created");

		/** Verify Header Message Expected Result */
		LeadsInfoPage lip = new LeadsInfoPage(driver);
		String actLeadName = lip.getHeaderMsg().getText();
		boolean status = actLeadName.contains(lastName);
		Assert.assertEquals(status, true);


	}

	@Test
	public void createLeadWithIndustryTest() throws Throwable {

		/** Reading the data from Excel File */
		UtilityClassObject.getTest().log(Status.INFO, "Read the data from Excel File");
		String companyName = eLib.getDataFromExcelFile("lead", 4, 2) + jLib.getRandomNumber();
		String lastName = eLib.getDataFromExcelFile("lead", 4, 3) + jLib.getRandomNumber();
		String industryName = eLib.getDataFromExcelFile("lead", 4, 5);

		/** Step 2 :- Navigate to Leads Module */
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Leads Module");
		HomePage hp = new HomePage(driver);
		hp.getLeadsLink().click();

		/** Step 3 :- Click on "Create Lead" Button */
		UtilityClassObject.getTest().log(Status.INFO, "On Create Lead Page");
		LeadsPage leadsPage = new LeadsPage(driver);
		leadsPage.getCreateLeadBtn().click();

		/** Fill The Necessary Details */
		/** Step 4 :- Enter all the details & Create New Lead */
		UtilityClassObject.getTest().log(Status.INFO, "Create a New Lead With Industry");
		LeadCreationPage lcp = new LeadCreationPage(driver);
		lcp.createLead(lastName, companyName, industryName);
		UtilityClassObject.getTest().log(Status.INFO, "Created");

		/** Verify Industry Name should be displayed */
		LeadsInfoPage lip = new LeadsInfoPage(driver);
		String actIndustryName = lip.getActIndustryName().getText();

		boolean status = actIndustryName.contains(industryName);
		Assert.assertEquals(status, true);
	}

	@Test
	public void createLeadWithPhoneNumberTest() throws Throwable {

		/** Reading the data from Excel File */
		UtilityClassObject.getTest().log(Status.INFO, "Read the data from Excel File");
		String companyName = eLib.getDataFromExcelFile("lead", 7, 2) + jLib.getRandomNumber();
		String lastName = eLib.getDataFromExcelFile("lead", 7, 3) + jLib.getRandomNumber();
		String phoneNumber = eLib.getDataFromExcelFile("lead", 7, 4);

		/** Step 2 :- Navigate to Leads Module */
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Leads Module");
		HomePage hp = new HomePage(driver);
		hp.getLeadsLink().click();

		/** Step 3 :- Click on "Create Lead" Button */
		UtilityClassObject.getTest().log(Status.INFO, "On Create Lead Page");
		LeadsPage leadsPage = new LeadsPage(driver);
		leadsPage.getCreateLeadBtn().click();

		/** Step 4 :- Enter all the details & Create New Lead */
		UtilityClassObject.getTest().log(Status.INFO, "Create a New Lead With Phone Number");
		LeadCreationPage lcp = new LeadCreationPage(driver);
		lcp.createLeadWithPhoneNumber(lastName, companyName, phoneNumber);
		UtilityClassObject.getTest().log(Status.INFO, "Created");

		/** Verify Industry Name should be displayed */
		LeadsInfoPage lip = new LeadsInfoPage(driver);
		String actPhoneNumber = lip.getActPhoneNumber().getText();
		boolean status = actPhoneNumber.contains(actPhoneNumber);
		Assert.assertEquals(status, true);

	}

}
