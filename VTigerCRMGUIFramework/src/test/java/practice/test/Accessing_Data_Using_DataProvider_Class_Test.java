package practice.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.vtiger.crm.generic.dataprovider.DataProviderClass;

public class Accessing_Data_Using_DataProvider_Class_Test {

	@Test(dataProvider = "getMobileProduct", dataProviderClass = DataProviderClass.class)
	public void getProductInfoTest(String brandName, String productName) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.amazon.in/");

		// Search Product
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandName);
		driver.findElement(By.id("twotabsearchtextbox")).submit();
		String priceXpath = "//span[text()='" + productName
				+ "']/../../../../div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/a/span/span[2]/span[2]";
		System.out.println(priceXpath);
		String priceTxt = driver.findElement(By.xpath(priceXpath)).getText();
		System.out.println(priceTxt);

		// Tear Down Browser
		driver.quit();
	}

}
