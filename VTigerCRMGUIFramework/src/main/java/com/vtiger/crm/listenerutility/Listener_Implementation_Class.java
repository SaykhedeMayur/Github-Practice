package com.vtiger.crm.listenerutility;

import java.time.LocalDateTime;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.vtiger.crm.basetest.BaseClass;
import com.vtiger.crm.generic.webdriverutility.UtilityClassObject;
import com.vtiger.crm.generic.webdriverutility.WebDriverUtility;

/**
 * Contains implementation for ITestListener and ISuiteListener default Methods 
 *  
 * @author Mayur
 */
public class Listener_Implementation_Class implements ITestListener, ISuiteListener {
	public ExtentReports report;
	public static ExtentTest test;

	/** Methods From ISuiteListener */
	@Override
	public void onStart(ISuite suite) {
		System.out.println("Report Configuration");

		LocalDateTime systemDate = LocalDateTime.now();
		String timeStamp = systemDate.toString().replaceAll(":", "-");

		/** Report Configuration */
		/** Spark Report Configuration */
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report" + timeStamp + ".html");
		spark.config().setDocumentTitle("CRM Test Suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);

		/** Adding Environment Information */
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows 10");
		report.setSystemInfo("BROWSER", "Chrome-100");
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("Report BackUp");

		/** Report BackUp */
		report.flush();
	}

	/** Methods From ITestListener */
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("====<" + result.getMethod().getMethodName() + ">==STARTED==");

		/** Creating Test Case */
		test = report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		test.log(Status.INFO, result.getMethod().getMethodName() + "==>STARTED<==");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("====<" + result.getMethod().getMethodName() + ">==ENDED==");
		test.log(Status.PASS, result.getMethod().getMethodName() + "==>COMPLETED<==");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		WebDriverUtility wLib = new WebDriverUtility();
		wLib.captureScreen(BaseClass.sdriver, testName, test);
		test.log(Status.FAIL, result.getMethod().getMethodName() + "==>FAILED<==");
		test.log(Status.FAIL, result.getThrowable()); // It will show Exception in Extent Report
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName() + "==>SKIPPED<==");
		test.log(Status.SKIP, result.getThrowable()); // It will show Exception in Extent Report
	}

}
