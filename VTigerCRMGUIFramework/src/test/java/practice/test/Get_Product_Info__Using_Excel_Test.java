package practice.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vtiger.crm.generic.fileutility.ExcelUtility;

public class Get_Product_Info__Using_Excel_Test {

	@Test(dataProvider = "getData")
	public void getProductInfoTest(String brandName, String productName) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.amazon.in/");

		// Search Product
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandName, Keys.ENTER);
		String priceXpath = "//span[text()='" + productName
				+ "']/../../../../div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/a/span/span[2]/span[2]";
		System.out.println(priceXpath);
		String priceTxt = driver.findElement(By.xpath(priceXpath)).getText();
		System.out.println(priceTxt);
		
		//Tear Down Browser
		driver.quit();
	}
	

	@DataProvider
	public Object[][] getData() throws Throwable {

		ExcelUtility eLib = new ExcelUtility();
		int rowCount = eLib.getRowCount("mobileProduct");

		Object[][] objArr = new Object[rowCount][2];

		for (int i = 0; i < rowCount; i++) {
			objArr[i][0] = eLib.getDataFromExcelFile("mobileProduct", i + 1, 0);
			objArr[i][1] = eLib.getDataFromExcelFile("mobileProduct", i + 1, 1);
		}

		return objArr;
	}

}
