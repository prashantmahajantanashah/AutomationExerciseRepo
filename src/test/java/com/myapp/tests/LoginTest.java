package com.myapp.tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.myapp.utils.CommonAssertions;

public class LoginTest extends BaseTest{
	
	@Test
	public void testLogin() throws InterruptedException {
		
		hp.clickSignUpBtn();
		CommonAssertions.verifyTrue(sp.isLoginAccountLabelVisible());
		String email=prop.getProperty("loginEmail");
		String password=prop.getProperty("loginPassword");
//		sp.enterCredsAndLogin(email, password);
//		sp.clickDeleteBtn();
//		CommonAssertions.verifyTrue(sp.isAccountDeletedVissible());
		
	}

}
