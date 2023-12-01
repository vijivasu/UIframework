package com.w3schools.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Report_practise {
	
	public static ExtentSparkReporter sparkReporter;
	public static ExtentReports extentReport;
	public static ExtentTest extentTest;
	
	public void startReport() {
		try {
			sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/WebAutomationReportLatest.html");
			sparkReporter.config().setDocumentTitle("W3 Schools Report generation");
			sparkReporter.config().setReportName("UI Latest Report");
			
			extentReport = new ExtentReports();
			extentReport.attachReporter(sparkReporter);
			
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void setTCDesc(String testcaseName) {
		try {
			extentTest = extentReport.createTest(testcaseName);
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void reportStep(String status, String desc) {
		try {
			if(status.toUpperCase().equals("PASS")) {
				extentTest.log(Status.PASS, desc);
			}
			else if(status.toUpperCase().equals("FAIL")){
				extentTest.log(Status.FAIL, desc);
			}
			else if(status.toUpperCase().equals("INFO")) {
				extentTest.log(Status.INFO, desc);
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	public void endReport() {
		extentReport.flush();
	}

}
