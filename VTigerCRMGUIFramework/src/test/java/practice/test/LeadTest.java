package practice.test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.crm.basetest.BaseClass;

@Listeners(com.vtiger.crm.listenerutility.Listener_Implementation_Class.class)
public class LeadTest extends BaseClass {
	
	@Test(retryAnalyzer = com.vtiger.crm.listenerutility.Retry_Implementation_Class.class)
	public void createLeadTest() throws Throwable {
		System.out.println("Execute createLeadTest()");
		String actTitle = driver.getTitle();
		Assert.assertEquals(actTitle, "Login");
		System.out.println("Step-1");
		System.out.println("Step-2");
		System.out.println("Step-3");
		System.out.println("Step-4");
	}
	
	@Test
	public void createLeadWithIndustryTest() throws Throwable {
		System.out.println("Execute createLeadWithIndustryTest()");
		System.out.println("Step-1");
		System.out.println("Step-2");
		System.out.println("Step-3");
		System.out.println("Step-4");
	}

}
