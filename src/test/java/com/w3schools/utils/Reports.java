package com.w3schools.utils;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports 
{
	
	/*
	 * ExtentSparkReporter  --> This class is generate the output html file
	 * ExtentReports --> This is used to create tests for our testcases
	 * ExtentTest --> This used to generate logs for each test case
	 */
	
	public static ExtentSparkReporter sparkReporter;
	public static ExtentReports extentReport;
	public static ExtentTest extentTest;
	
	@BeforeSuite(alwaysRun=true)
	public void startReport()
	{
		try
		{
		sparkReporter= new ExtentSparkReporter(System.getProperty("user.dir")+"/WebAutomationReport.html");
		sparkReporter.config().setDocumentTitle("W3Schools Automation Report");
		sparkReporter.config().setReportName("UI Reports");
		
		extentReport= new ExtentReports();
		extentReport.attachReporter(sparkReporter);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}
	
	// Test Description for the test cases in Report
	public void setTCDesc(String testcaseName)
	
	{
		try
		{
			extentReport= new ExtentReports();
			extentTest=extentReport.createTest(testcaseName);
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public static void reportStep(String status, String desc)
	{
		try
		{
			
			if(status.toUpperCase().equals("PASS"))
			{
				extentTest.log(Status.PASS, desc);
			}
			else if(status.toUpperCase().equals("FAIL"))
			{
				extentTest.log(Status.FAIL, desc);
			}
			else if(status.toUpperCase().equals("INFO"))
			{
				extentTest.log(Status.INFO, desc);
			}
				
					
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	@AfterSuite(alwaysRun=true)
	public void endReport()
	{
		extentReport.flush();
	}
	
	

}
