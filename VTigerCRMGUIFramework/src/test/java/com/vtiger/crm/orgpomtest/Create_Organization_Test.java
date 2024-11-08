package com.vtiger.crm.orgpomtest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.vtiger.crm.basetest.BaseClass;
import com.vtiger.crm.generic.webdriverutility.UtilityClassObject;
import com.vtiger.crm.listenerutility.Listener_Implementation_Class;
import com.vtiger.crm.objectrepositoryutility.HomePage;
import com.vtiger.crm.objectrepositoryutility.OrgCreationPage;
import com.vtiger.crm.objectrepositoryutility.OrgInfoPage;
import com.vtiger.crm.objectrepositoryutility.OrgPage;


/**
 * Test Script of Organization Module
 * 
 * @author Mayur
 */

@Listeners(Listener_Implementation_Class.class)
public class Create_Organization_Test extends BaseClass {

	@Test (groups = "smokeTest")
	public void createOrgTest() throws Throwable {
		
		/** Reading the data from Excel File */
		UtilityClassObject.getTest().log(Status.INFO, "read the data from Excel");
		String orgName = eLib.getDataFromExcelFile("org", 1, 2) + jLib.getRandomNumber();
 
		/** Step 2 :- Navigate to Organization module */
		UtilityClassObject.getTest().log(Status.INFO, " Navigate to Organization Page");
		HomePage hp = new HomePage(driver);
		hp.getOrganizationsLink().click();

		/** Step 3 :- Click on "Create Organization" Button */
		UtilityClassObject.getTest().log(Status.INFO, " Navigate to Create Organization Page");
		OrgPage orgPage = new OrgPage(driver);
		orgPage.getCreateOrgBtn().click();

		/** Step 4 :- Enter all the details & Create new Organization */
		UtilityClassObject.getTest().log(Status.INFO, " Create a New Organization");
		OrgCreationPage ocp = new OrgCreationPage(driver);
		ocp.createOrg(orgName);
		UtilityClassObject.getTest().log(Status.INFO, orgName + ":- Created");


		/** Step 5 :- Verify Organization name in header of the message */
		/** Verify Header Message Expected Result */
		OrgInfoPage oip = new OrgInfoPage(driver);
		String headerMsg = oip.getHeaderMsg().getText();
		boolean status1 = headerMsg.contains(orgName);
		Assert.assertEquals(status1, true);

		/** Verify Header orgName Information Expected Result */
		Thread.sleep(2000);
		String actOrgName = oip.getActOrgName().getText();
		boolean status2 = actOrgName.contains(orgName);
		Assert.assertEquals(status2, true);

	}

	@Test (groups = "regressionTest")
	public void createOrgWithIndustryTest() throws Throwable {
		
		
		/** Reading the data from Excel File */
		UtilityClassObject.getTest().log(Status.INFO, "read the data from Excel");
		String orgName = eLib.getDataFromExcelFile("org", 4, 2) + jLib.getRandomNumber();
		String indName = eLib.getDataFromExcelFile("org", 4, 3);
		String type = eLib.getDataFromExcelFile("org", 4, 4);

		/** Step 2 :- Navigate to Organization module */
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Org Module");
		HomePage hp = new HomePage(driver);
		hp.getOrganizationsLink().click();

		/** Step 3 :- Click on "Create Organization" Button */
		UtilityClassObject.getTest().log(Status.INFO, "On Organization Page");
		OrgPage orgPage = new OrgPage(driver);
		orgPage.getCreateOrgBtn().click();

		/** Step 4 :- Enter all the details & Create new Organization */
		UtilityClassObject.getTest().log(Status.INFO, "Create a New Org with Industry & Test");
		OrgCreationPage ocp = new OrgCreationPage(driver);
		ocp.createOrg(orgName, indName, type);
		UtilityClassObject.getTest().log(Status.INFO, orgName + ":- Created");

		/** Verify the Industry Information */
		OrgInfoPage oip = new OrgInfoPage(driver);
		String actIndustryName = oip.getActIndustryName().getText();
		boolean status1 = actIndustryName.contains(indName);
		Assert.assertEquals(status1, true);

		/** Verify the Type Information */
		String actType = oip.getActIndustryType().getText();
		boolean status2 = actType.contains(type);
		Assert.assertEquals(status2, true);

	}

	@Test (groups = "regressionTest")
	public void createOrgWithPhoneNumberTest() throws Throwable {

		/** Reading the data from Excel File */
		UtilityClassObject.getTest().log(Status.INFO, "Reading the data from Excel File");
		String orgName = eLib.getDataFromExcelFile("org", 7, 2) + jLib.getRandomNumber();
		String phNumber = eLib.getDataFromExcelFile("org", 7, 3);

		/** Step 2 :- Navigate to Organization module */
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Org Module");
		HomePage hp = new HomePage(driver);
		hp.getOrganizationsLink().click();

		/** Step 3 :- Click on "Create Organization" Button */
		UtilityClassObject.getTest().log(Status.INFO, "On Organization Page");
		OrgPage orgPage = new OrgPage(driver);
		orgPage.getCreateOrgBtn().click();

		/** Step 4 :- Enter all the details & Create new Organization */
		UtilityClassObject.getTest().log(Status.INFO, "Create a New Org With Phone Number");
		OrgCreationPage ocp = new OrgCreationPage(driver);
		ocp.createOrgByPhoneNumber(orgName, phNumber);

		/** Verify the Phone Number Information Expected Result */
		OrgInfoPage oip = new OrgInfoPage(driver);
		String actPhNumber = oip.getActPhoneNumber().getText();
		boolean status = actPhNumber.contains(phNumber);
		Assert.assertEquals(status, true);

	}

}
                                                                                                                                                                                   