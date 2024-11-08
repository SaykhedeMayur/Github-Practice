package com.vtiger.crm.generic.webdriverutility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput.ScrollOrigin;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

/**
 * this class is for to use WebDriver methods, Select Class methods, Actions Class
 * methods, JavascriptExecutor methods, wait methods, TakesScreenshot methods, 
 * to work with popups etc.
 * 
 * @author Mayur
 */
public class WebDriverUtility {

	/** ====================== Wait Methods ====================== */
	
	/**
	 * this method is used to apply implicit wait
	 * @param driver
	 */
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	
	/**
	 * this method is used to apply explicit wait
	 * @param driver
	 * @param element
	 */
	public void waitForElementPresent(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
	}

	/** ====================== Switch To Methods ====================== */

	/**
	 * this method is used to switch the tab basis on url
	 * @param driver
	 * @param partialURL
	 */
	public void switchToTabOnURL(WebDriver driver, String partialURL) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();

		while (it.hasNext()) {
			String windowID = it.next();
			driver.switchTo().window(windowID);

			String actUrl = driver.getCurrentUrl();
			if (actUrl.contains(partialURL)) {
				break;
			}
		}
	}

	/**
	 * this method is used to switch the tab basis on title
	 * @param driver
	 * @param partialTitle
	 */
	public void switchToTabOnTitle(WebDriver driver, String partialTitle) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();

		while (it.hasNext()) {
			String windowID = it.next();
			driver.switchTo().window(windowID);

			String actUrl = driver.getTitle();
			if (actUrl.contains(partialTitle)) {
				break;
			}
		}

	}

	/**
	 * this method is used to switch the frame basis on index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * this method is used to switch the frame basis on name or id
	 * @param driver
	 * @param nameID
	 */
	public void switchToFrame(WebDriver driver, String nameID) {
		driver.switchTo().frame(nameID);
	}

	/**
	 * this method is used to switch the fram basis on WebElement
	 * @param driver
	 * @param element
	 */
	public void switchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	/** ====================== Select Class Methods ====================== */

	/**
	 * this method is used to work with drop down basis on index
	 * @param element
	 * @param index
	 */
	public void selectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	/**
	 * this method is used to work with drop down basis on value
	 * @param element
	 * @param value
	 */
	public void selectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	/**
	 * this method is used to work with drop down basis on visible text
	 * @param element
	 * @param text
	 */
	public void selectByVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	/** ====================== Actions Class Methods ====================== */

	/**
	 * this method is used to move the mouse cursor on a particular web element
	 * @param driver
	 * @param element
	 */
	public void mouseMoveOnElement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	/**
	 * this method is used to perform double click 
	 * @param driver
	 * @param element
	 */
	public void doubleClick(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();
	}

	/**
	 * this method is used to perform single click
	 * @param driver
	 * @param element
	 */
	public void clickOnElement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.click(element).perform();
	}

	/**
	 * this method is used to pass the data into WebElement
	 * @param driver
	 * @param element
	 * @param data
	 */
	public void passDataForElement(WebDriver driver, WebElement element, CharSequence... data) {
		Actions action = new Actions(driver);
		action.sendKeys(element, data).perform();
	}

	/**
	 * this method is used to perform right click
	 * @param driver
	 * @param element
	 */
	public void rightClickOnElement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
	}

	/**
	 * this method is used to drag and drop an element
	 * @param driver
	 * @param src
	 * @param dest
	 */
	public void dragAndDropElement(WebDriver driver, WebElement src, WebElement dest) {
		Actions action = new Actions(driver);
		action.dragAndDrop(src, dest).perform();
	}

	/**
	 * this method is used to drag and drop an element by offset(axis)
	 * @param driver
	 * @param ele
	 * @param XOffset
	 * @param YOffset
	 */
	public void dragAndDropElementByOffSet(WebDriver driver, WebElement ele, int XOffset, int YOffset) {
		Actions action = new Actions(driver);
		action.dragAndDropBy(ele, XOffset, YOffset).perform();
	}

	/**
	 * this method is used to scroll based on axis
	 * @param driver
	 * @param XoffSet
	 * @param YOffSet
	 */
	public void scrollBasedOnAxis(WebDriver driver, int XoffSet, int YOffSet) {
		Actions action = new Actions(driver);
		action.scrollByAmount(XoffSet, YOffSet).perform();
	}

	/**
	 * this method is used to scroll until an element is visible
	 * @param driver
	 * @param element
	 */
	public void scrollUntilElementIsVisible(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.scrollToElement(element).perform();
	}

	/** Method for Scroll Until Element Is Visible By Axis (By OffSet) */
	/**
	 * this method is used to scroll until an element is visible by axis
	 * @param driver
	 * @param element
	 * @param XoffSet
	 * @param YoffSet
	 */
	public void scrollUntilElementVisible(WebDriver driver, WebElement element, int XoffSet, int YoffSet) {
		Actions action = new Actions(driver);
		ScrollOrigin origin = ScrollOrigin.fromElement(element);
		action.scrollFromOrigin(origin, XoffSet, YoffSet).perform();
	}
 
	/** ====================== JavascriptExecutor<<I>> Methods ====================== */

	/**
	 * this method is used to click on an element through JavaascriptExecutor
	 * @param driver
	 * @param element
	 */

	public void jsClick(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	/**
	 * this method is used to send the data to a text field using JavascriptExecutor
	 * @param driver
	 * @param data
	 * @param element
	 */
	public void jsSendkeys(WebDriver driver, String data, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='" + data + "';", element);
	}

	/**
	 * this method is used to perform scrolling action in X and Y direction using JavascriptExecutor
	 * @param driver
	 * @param X
	 * @param Y
	 */
	public void jsScrollBy(WebDriver driver, int X, int Y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + X + "," + Y + ")");
	}

	/** 
	 * this method is used to perform scrolling action to a particular co-ordinates
	 * @param driver
	 * @param X
	 * @param Y
	 */
	public void jsScrollTo(WebDriver driver, int X, int Y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(" + X + "," + Y + ")");
	}

	/**
	 * this method is used to scroll upto an element
	 * @param driver
	 * @param bool
	 * @param element
	 */
	public void jsScrollIntoView(WebDriver driver, boolean bool, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(" + bool + ")", element);
	}

	/** ====================== Takesscreenshot <<I>> Method ====================== */

	/**
	 * this method is used to capture the screen (screenshot)
	 * @param driver
	 * @param testcasename
	 */
	public void captureScreen(WebDriver driver, String testcasename) {
		LocalDateTime systemDate = LocalDateTime.now();
		String timeStamp = systemDate.toString().replaceAll(":", "-");
		TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
		File tempFile = takeScreenShot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./screenshot/" + testcasename + timeStamp + ".png");
		try {
			FileHandler.copy(tempFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * this method is used to capture the webelement
	 * @param element
	 * @param testcasename
	 */
	public void captureElement(WebElement element, String testcasename) {
		LocalDateTime systemDate = LocalDateTime.now();
		String timeStamp = systemDate.toString().replaceAll(":", "-");
		File tempFile = element.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./screenshot" + testcasename + timeStamp + ".png");
		try {
			FileHandler.copy(tempFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * this method is used to capture the screen and attach with extent report
	 * @param driver
	 * @param testName
	 * @param test
	 */
		public void captureScreen(WebDriver driver, String testName, ExtentTest test) {
			LocalDateTime systemDate = LocalDateTime.now();
			String timeStamp = systemDate.toString().replaceAll(":", "-");
			TakesScreenshot eDriver = (TakesScreenshot) driver;
			String filePath = eDriver.getScreenshotAs(OutputType.BASE64);
			test.addScreenCaptureFromBase64String(filePath, testName+"_"+timeStamp);
		}
	
	
	

	/** ====================== Methods to Work on Popups ====================== */

	/**
	 * this method is used to switch to alert and accept it	
	 * @param driver
	 */
	public void switchToAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	/**
	 * this method is used to swithc to alert and dismiss it 
	 * @param driver
	 */
	public void switchToAlertAndDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * this method is used to fetch the text of prompt alert popup
	 * @param driver
	 * @return
	 */
	public String  switchToPromptAlertAndGetText(WebDriver driver) {
		String message = driver.switchTo().alert().getText();
		return message;
	}
	
	/**
	 * this method is used to pass the data in prompt alert popup
	 * @param driver
	 * @param data
	 */
	public void switchToPromptAlertAndPassData(WebDriver driver, String data) {
		driver.switchTo().alert().sendKeys(data);
	}

}
