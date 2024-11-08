package practice.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Get_Product_Info_Test {
	
	@Test (dataProvider = "getData")
	public void getProductInfoTest(String brandName, String productName) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.amazon.in/");
		
		//Search Product
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandName, Keys.ENTER);
		String priceXpath = "//span[text()='"+productName+"']/../../../../div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/a/span/span[2]/span[2]";
		String priceTxt = driver.findElement(By.xpath(priceXpath)).getText();
		System.out.println(priceTxt);
	}
	
	@DataProvider
	public Object[][] getData() {
	
		Object[][] objArr = new Object[3][2];
		
		objArr[0][0] = "iphone";
		objArr[0][1] = "Apple iPhone 13 (128GB) - Starlight";
		
		objArr[1][0] = "iphone";
		objArr[1][1] = "Apple iPhone 13 (128GB) - Blue";
		
		objArr[2][0] = "iphone";
		objArr[2][1] = "Apple iPhone 13 (128GB) - (Product) RED";
		
		
		return objArr;
	}

}
