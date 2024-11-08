package com.vtiger.crm.opportunitiespomtest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.vtiger.crm.basetest.BaseClass;
import com.vtiger.crm.generic.webdriverutility.UtilityClassObject;
import com.vtiger.crm.listenerutility.Listener_Implementation_Class;
import com.vtiger.crm.objectrepositoryutility.HomePage;
import com.vtiger.crm.objectrepositoryutility.OpportunitiesInfoPage;
import com.vtiger.crm.objectrepositoryutility.OpportunitiesPage;
import com.vtiger.crm.objectrepositoryutility.OpportunityCreationPage;
import com.vtiger.crm.objectrepositoryutility.OrgCreationPage;
import com.vtiger.crm.objectrepositoryutility.OrgInfoPage;
import com.vtiger.crm.objectrepositoryutility.OrgPage;


/**
 * Test Script of Opportunities Module
 * 
 * @author Mayur
 */

@Listeners(Listener_Implementation_Class.class)
public class Create_Opportunities_Test extends BaseClass {

	@Test
	public void createOpportunitiesTest() throws Throwable {

		/** Reading The Data From Excel File */
		UtilityClassObject.getTest().log(Status.INFO, "Read the data from Excel File");
		String orgName = eLib.getDataFromExcelFile("Opportunities", 1, 3) + jLib.getRandomNumber();
		String oppoName = orgName + eLib.getDataFromExcelFile("Opportunities", 1, 2);

		/** Creating Organization */
		UtilityClassObject.getTest().log(Status.INFO, "Creating Organization");
		/** Step 2 :- Navigate to Organization module */
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Organization Module");
		HomePage hp = new HomePage(driver);
		hp.getOrganizationsLink().click();

		/** Step 3 :- Click on "Create Organization" Button */
		UtilityClassObject.getTest().log(Status.INFO, "On Create Org Page");
		OrgPage orgPage = new OrgPage(driver);
		orgPage.getCreateOrgBtn().click();

		/** Step 4 :- Enter all the details & Create new Organization */
		UtilityClassObject.getTest().log(Status.INFO, "Create a New Org");
		OrgCreationPage ocp = new OrgCreationPage(driver);
		ocp.createOrg(orgName);
		UtilityClassObject.getTest().log(Status.INFO, orgName + ":- Created");

		/** Step 5 :- Verify Organization name in header of the message */
		/** Verify Header Message Expected Result */
		OrgInfoPage oip = new OrgInfoPage(driver);
		String headerMsg1 = oip.getHeaderMsg().getText();
		boolean status = headerMsg1.contains(orgName);
		Assert.assertEquals(status, true);

		/** Verify orgName Information Expected Result */
		wLib.waitForElementPresent(driver, oip.getActOrgName());
		String actOrgName = oip.getActOrgName().getText();
		if (actOrgName.equals(orgName)) {
			System.out.println(orgName + " :- information is Created ==> PASS");
		} else {
			System.out.println(orgName + " :- information is Not Created ==> FAIL ");
		}

		/** Creating Opportunities */
		UtilityClassObject.getTest().log(Status.INFO, "Creating Opportunities");
		/** Step 2 :- Navigate to Opportunities Module */
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Opportunities Module");
		hp.getOpportunitiesLink().click();

		/** Step 3 :- Click on Create Opportunities Button */
		UtilityClassObject.getTest().log(Status.INFO, "On Crete Opportunities Page");
		OpportunitiesPage op = new OpportunitiesPage(driver);
		op.getCreateOpportunityBtn().click();

		/** Step 4 :- Fill The Details & Create An Opportunities */
		UtilityClassObject.getTest().log(Status.INFO, "Create a New Opportunities");
		OpportunityCreationPage ocp1 = new OpportunityCreationPage(driver);
		ocp1.createOpportunities(driver, oppoName, actOrgName, "module=Accounts&action=Popup",
				"module=Potentials&action=EditView");

		/** Verify Opportunity Message */
		OpportunitiesInfoPage oppoip = new OpportunitiesInfoPage(driver);
		String headerMsg2 = oppoip.getHeaderMsg().getText();
		boolean status2 = headerMsg2.contains(oppoName);
		Assert.assertEquals(status2, true);

	}

	@Test
	public void createOpportunitiesWithAmountTest() throws Throwable {

		/** Reading The Data From Excel File */
		UtilityClassObject.getTest().log(Status.INFO, "Read the data from Excel File");
		String orgName = eLib.getDataFromExcelFile("Opportunities", 7, 3) + jLib.getRandomNumber();
		String oppoName = orgName + eLib.getDataFromExcelFile("Opportunities", 7, 2);
		String amount = eLib.getDataFromExcelFile("Opportunities", 7, 4);

		/** Creating Organization */
		UtilityClassObject.getTest().log(Status.INFO, "Creating Organization");
		/** Step 2 :- Navigate to Organization module */
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Organization Module");
		HomePage hp = new HomePage(driver);
		hp.getOrganizationsLink().click();

		/** Step 3 :- Click on "Create Organization" Button */
		UtilityClassObject.getTest().log(Status.INFO, "On Create Org Page");
		OrgPage orgPage = new OrgPage(driver);
		orgPage.getCreateOrgBtn().click();

		/** Step 4 :- Enter all the details & Create new Organization */
		UtilityClassObject.getTest().log(Status.INFO, "Create a New Org");
		OrgCreationPage ocp = new OrgCreationPage(driver);
		ocp.createOrg(orgName);
		UtilityClassObject.getTest().log(Status.INFO, orgName + ":- Created");

		/** Step 5 :- Verify Organization name in header of the message */
		/** Verify Header Message Expected Result */
		OrgInfoPage oip = new OrgInfoPage(driver);
		String headerMsg1 = oip.getHeaderMsg().getText();
		boolean status1 = headerMsg1.contains(orgName);
		Assert.assertEquals(status1, true);

		/** Verify Header orgName Information Expected Result */
		Thread.sleep(2000);
		String actOrgName = oip.getActOrgName().getText();
		boolean status2 = actOrgName.contains(orgName);
		Assert.assertEquals(status2, true);

		/** Creating Opportunities */
		UtilityClassObject.getTest().log(Status.INFO, "Creating Opportunities");
		/** Step 2 :- Click on Opportunities Module
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Opportunities Module");
		hp.getOpportunitiesLink().click();

		/** Step 3 :- Click on Create Opportunities Button */
		UtilityClassObject.getTest().log(Status.INFO, "On Create Opportunities Page");
		OpportunitiesPage op = new OpportunitiesPage(driver);
		op.getCreateOpportunityBtn().click();

		/** Step 4 :- Fill The Details & Create An Opportunities */
		UtilityClassObject.getTest().log(Status.INFO, "Create a New Opportunities With Amount");
		OpportunityCreationPage ocp1 = new OpportunityCreationPage(driver);
		ocp1.createOpportunitiesWithAmount(driver, oppoName, actOrgName, "module=Accounts&action=Popup",
				"module=Potentials&action=EditView", amount);

		/** Verify Actual Amount Message */
		OpportunitiesInfoPage oppoip = new OpportunitiesInfoPage(driver);
		String actAmount = oppoip.getActAmount().getText();
		boolean status = actAmount.contains(amount);
		Assert.assertEquals(status, true);
	}

	@Test
	public void createOpportunitiesWithExpectedCloseDateTest() throws Throwable {

		/** Reading The Data From Excel File */
		UtilityClassObject.getTest().log(Status.INFO, "Read the data from Excel File");
		String orgName = eLib.getDataFromExcelFile("Opportunities", 4, 3) + jLib.getRandomNumber();
		String oppoName = orgName + eLib.getDataFromExcelFile("Opportunities", 4, 2);

		/** Creating Organization [Pre Condition] */
		UtilityClassObject.getTest().log(Status.INFO, "Creating Organization");
		/** Step 2 :- Navigate to Organization module */
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Organization Module");
		HomePage hp = new HomePage(driver);
		hp.getOrganizationsLink().click();

		/** Step 3 :- Click on "Create Organization" Button */
		UtilityClassObject.getTest().log(Status.INFO, "On Create Org Page");
		OrgPage orgPage = new OrgPage(driver);
		orgPage.getCreateOrgBtn().click();

		/** Step 4 :- Enter all the details & Create new Organization */
		UtilityClassObject.getTest().log(Status.INFO, "Create a New Org");
		OrgCreationPage ocp = new OrgCreationPage(driver);
		ocp.createOrg(orgName);
		UtilityClassObject.getTest().log(Status.INFO, orgName + ":- Created");

		/** Step 5 :- Verify Organization name in header of the message */
		/** Verify Header Message Expected Result */
		OrgInfoPage oip = new OrgInfoPage(driver);
		String headerMsg1 = oip.getHeaderMsg().getText();
		boolean status1 = headerMsg1.contains(orgName);
		Assert.assertEquals(status1, true);

		/** Verify Header orgName Information Expected Result */
		Thread.sleep(2000);
		String actOrgName = oip.getActOrgName().getText();
		boolean status2 = actOrgName.contains(orgName);
		Assert.assertEquals(status2, true);

		/** Creating Opportunities */
		UtilityClassObject.getTest().log(Status.INFO, "Creating Opportunities");
		/** Step 2 :- Navigate to Opportunities Module */
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Opportunities Module");
		hp.getOpportunitiesLink().click();

		/** Step 3 :- Click on Create Opportunities Button */
		UtilityClassObject.getTest().log(Status.INFO, "On Create Opportunities Page");
		OpportunitiesPage op = new OpportunitiesPage(driver);
		op.getCreateOpportunityBtn().click();

		/** Step 4 :- Fill The Details & Create An Opportunities */
		UtilityClassObject.getTest().log(Status.INFO, "Create a New Opportunities With Expected Close Date");
		String expectedCloseDate = jLib.getRequiredDateYYYYMMDD(30);
		OpportunityCreationPage ocp1 = new OpportunityCreationPage(driver);
		ocp1.createOpportunities(driver, oppoName, actOrgName, "module=Accounts&action=Popup",
				"module=Potentials&action=EditView", expectedCloseDate);

		/** Verify Header Message */
		OpportunitiesInfoPage oppoip = new OpportunitiesInfoPage(driver);
		String actExpectedCloseDate = oppoip.getActExpectedCloseDate().getText();
		boolean status = actExpectedCloseDate.contains(expectedCloseDate);
		Assert.assertEquals(status, true);

	}

}
