package com.myapp.Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.myapp.utils.ReporterNg;

public class ReportingListener implements ITestListener{
	ExtentReports extent=ReporterNg.getReporter();
	ExtentTest test;
	ThreadLocal<ExtentTest> extentTest= new ThreadLocal<ExtentTest>();

	
	public void onTestStart(ITestResult result) {
		test=extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}

	
	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, "test passed");
		
	}

	
	public void onTestFailure(ITestResult result) {
		extentTest.get().log(Status.FAIL, result.getThrowable());
		
	}

	
	public void onTestSkipped(ITestResult result) {
		extentTest.get().log(Status.SKIP, "test skipped");
	}

	
	public void onFinish(ITestContext context) {
		extent.flush();
	}
	
	
	
	

}
