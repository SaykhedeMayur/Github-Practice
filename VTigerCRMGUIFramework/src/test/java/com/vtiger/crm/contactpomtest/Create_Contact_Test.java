package com.vtiger.crm.contactpomtest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.vtiger.crm.basetest.BaseClass;
import com.vtiger.crm.generic.webdriverutility.UtilityClassObject;
import com.vtiger.crm.generic.webdriverutility.WebDriverUtility;
import com.vtiger.crm.listenerutility.Listener_Implementation_Class;
import com.vtiger.crm.objectrepositoryutility.ContactsCreationPage;
import com.vtiger.crm.objectrepositoryutility.ContactsInfoPage;
import com.vtiger.crm.objectrepositoryutility.ContactsPage;
import com.vtiger.crm.objectrepositoryutility.HomePage;
import com.vtiger.crm.objectrepositoryutility.OrgCreationPage;
import com.vtiger.crm.objectrepositoryutility.OrgInfoPage;
import com.vtiger.crm.objectrepositoryutility.OrgPage;

/**
 * Test Scripts of Contact Creation Module
 * 
 * @author Mayur
 * 
 */

@Listeners(Listener_Implementation_Class.class)
public class Create_Contact_Test extends BaseClass {

	@Test(groups = { "smokeTest", "regressionTest" })
	public void createContactTest() throws Throwable {

		/** Reading the data from Excel File */
		UtilityClassObject.getTest().log(Status.INFO, "Read the data from Excel File");
		String lastName = eLib.getDataFromExcelFile("contact", 1, 2) + jLib.getRandomNumber();

		/**  Step 2 :- Navigate to Contacts module */
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Contacts Module");
		HomePage hp = new HomePage(driver);
		hp.getContactsLink().click();

		/**  Step 3 :- Click on "Create Contact" Button */
		UtilityClassObject.getTest().log(Status.INFO, "On Contacts Page");
		ContactsPage contactsPage = new ContactsPage(driver);
		contactsPage.getCreateContactBtn().click();

		/**  Step 4 :- Enter all the details & Create new Contact */
		UtilityClassObject.getTest().log(Status.INFO, "Create a New Contact");
		ContactsCreationPage ccp = new ContactsCreationPage(driver);
		ccp.createContact(lastName);
		UtilityClassObject.getTest().log(Status.INFO, lastName + ":- Created");

		/**  Verify the Last Name Information Expected Result */
		ContactsInfoPage cip = new ContactsInfoPage(driver);
		String actHeaderMsg = cip.getHeaderMsg().getText();
		boolean status = actHeaderMsg.contains(lastName);
		Assert.assertEquals(status, true);

		String actLastName = cip.getActLastName().getText();
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actLastName, lastName);
		soft.assertAll();
	}

	@Test(groups = "regressionTest")
	public void createContactWithSupportDateTest() throws Throwable {

		/**  Reading the data from Excel File */
		UtilityClassObject.getTest().log(Status.INFO, "Read the data from Excel File");
		String lastName = eLib.getDataFromExcelFile("contact", 1, 2) + jLib.getRandomNumber();

		/**  Step 2 :- Navigate to Contacts module */
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Contacts Module");
		HomePage hp = new HomePage(driver);
		hp.getContactsLink().click();

		/**  Step 3 :- Click on "Create Contact" Button */
		UtilityClassObject.getTest().log(Status.INFO, "On Contacts Page");
		ContactsPage contactsPage = new ContactsPage(driver);
		contactsPage.getCreateContactBtn().click();

		/**  Step 4 :- Enter all the details & Create new Contact */
		UtilityClassObject.getTest().log(Status.INFO, "Create a New Contact with Sales Start & End Date");
		String startDate = jLib.getSystemDateYYYYMMDD();
		String endDate = jLib.getRequiredDateYYYYMMDD(30);

		ContactsCreationPage ccp = new ContactsCreationPage(driver);
		ccp.createContact(lastName, startDate, endDate);
		UtilityClassObject.getTest().log(Status.INFO, "Created");

		/**  Verify the start date Information Expected Result */
		ContactsInfoPage cip = new ContactsInfoPage(driver);
		String actStartDate = cip.getActSupportStartDate().getText();
		SoftAssert soft1 = new SoftAssert();
		soft1.assertEquals(actStartDate, startDate);

		/**  Verify the end date Information Expected Result */
		String actEndDate = cip.getActSupprtEndDate().getText();
		SoftAssert soft2 = new SoftAssert();
		soft2.assertEquals(actEndDate, endDate);

	}

	@Test(groups = "regressionTest")
	public void createContactWithOrganizationTest() throws Throwable {

		/**  Reading the data from Excel File */
		UtilityClassObject.getTest().log(Status.INFO, "Read the data from Excel File");
		String orgName = eLib.getDataFromExcelFile("contact", 7, 3) + jLib.getRandomNumber();
		String lastName = eLib.getDataFromExcelFile("contact", 7, 2) + jLib.getRandomNumber();

		/**  Creating Organization :- */

		/**  Step 2 :- Navigate to Organization module */
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Org Module");
		HomePage hp = new HomePage(driver);
		hp.getOrganizationsLink().click();

		/**  Step 3 :- Click on "Create Organization" Button */
		UtilityClassObject.getTest().log(Status.INFO, "On Create Org Page");
		OrgPage orgPage = new OrgPage(driver);
		orgPage.getCreateOrgBtn().click();

		/**  Step 4 :- Enter all the details & Create new Organization */
		UtilityClassObject.getTest().log(Status.INFO, "Create a New Org");
		OrgCreationPage ocp = new OrgCreationPage(driver);
		ocp.createOrg(orgName);
		UtilityClassObject.getTest().log(Status.INFO, orgName + ":- Created");

		/**  Step 5 :- Verify Organization name in header of the message */
		/**  Verify Header Message Expected Result */
		OrgInfoPage oip = new OrgInfoPage(driver);
		String headerMsg1 = oip.getHeaderMsg().getText();
		boolean status1 = headerMsg1.contains(orgName);
		Assert.assertEquals(status1, true);

		/**  Creating Contact with Organization */
		UtilityClassObject.getTest().log(Status.INFO, "Creating Contact With Organization");
		/**  Step 2 :- Navigate to Contacts module */
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Contacts Module");
		hp.getContactsLink().click();

		/**  Step 3 :- Click on "Create Contact" Button */
		UtilityClassObject.getTest().log(Status.INFO, "On Create Contact Page");
		ContactsPage contactsPage = new ContactsPage(driver);
		contactsPage.getCreateContactBtn().click();

		/**  Step 4 :- Enter all the details & Create new Contact with Org */
		UtilityClassObject.getTest().log(Status.INFO, "Create a New Contact With Org");
		ContactsCreationPage ccp = new ContactsCreationPage(driver);
		ccp.getLastNameTxtField().sendKeys(lastName);
		ccp.getSelectOrgBtn().click();

		/**  Switch to Child Window */
		WebDriverUtility wdu = new WebDriverUtility();
		wdu.switchToTabOnURL(driver, "module=Accounts");
		ccp.getSearchTxtField().sendKeys(orgName);
		ccp.getSearchBtn().click();
		driver.findElement(By.xpath("//a[text()='" + orgName + "']")).click();

		/**  Switch back to Parent Window */
		wdu.switchToTabOnURL(driver, "module=Contacts");

		ccp.getSaveBtn().click();

		/**  Verify Header Message Expected Result */
		ContactsInfoPage cip = new ContactsInfoPage(driver);
		String headerMsg2 = cip.getHeaderMsg().getText();
		boolean status2 = headerMsg2.contains(lastName);
		Assert.assertEquals(status2, true);

		/**  Verify Header orgName Information Expected Result */
		Thread.sleep(2000);
		String actOrgName = cip.getActOrgName().getText();
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actOrgName, orgName);
	}

}
