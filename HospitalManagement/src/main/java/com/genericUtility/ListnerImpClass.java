package com.genericUtility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerImpClass implements ITestListener
{

	ExtentReports report;
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		String Methodname = result.getMethod().getMethodName();
		test = report.createTest(Methodname);
        Reporter.log("execution starts from here",true);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String Methodname = result.getMethod().getMethodName();
		test.log(Status.PASS,Methodname);
		Reporter.log(Methodname+"passed",true);
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		String Methodname = result.getMethod().getMethodName();
	    try {
		 String screenshot = WebDriverUtility.getScreenShot(Baseclass.sdriver,"Methodname");
		test.log(Status.FAIL,Methodname+"--failed");
		test.log(Status.FAIL,result.getThrowable());
		test.addScreenCaptureFromPath(screenshot);
		
		Reporter.log(Methodname+"--failed",true);
	    } 
	    catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String Methodname = result.getMethod().getMethodName();
		test.log(Status.SKIP,Methodname);
		Reporter.log("execution starts from here",true);	
	}

	@Override
	public void onStart(ITestContext context) {
		ExtentSparkReporter htmlreport = new ExtentSparkReporter("./ExtentReport/Report.html");
		htmlreport.config().setDocumentTitle("HMS");
		htmlreport.config().setReportName("SDET-55");
		htmlreport.config().setTheme(Theme.STANDARD);
		
		report = new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("base platform","windows11");
		report.setSystemInfo("base browser","chrome");
		report.setSystemInfo("base url","http://rmgtestingserver/domain/Hospital_Management_System/index.html");
		report.setSystemInfo("reporter name","NAVYA");
		//http://rmgtestingserver/domain/Hospital_Management_System/index.html
			//http://rmgtestingserver/domain/Hospital_Management_System/hms/doctor/add-patient.php
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}

	
}
