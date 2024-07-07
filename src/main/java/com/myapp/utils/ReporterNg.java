package com.myapp.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.myapp.Context.Constants;

public class ReporterNg {
	
	static ExtentReports extent;
	
	public static ExtentReports getReporter() {
	ExtentSparkReporter reporter = new ExtentSparkReporter(Constants.reportPath);
	reporter.config().setDocumentTitle("Dummy report title");
	reporter.config().setReportName("Testing setting report name");
	extent = new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("QA Name", "Prashant");
	extent.setSystemInfo("Env", "QA");
	return extent;


	
	}
}
