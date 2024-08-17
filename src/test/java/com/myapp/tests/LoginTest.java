package com.myapp.tests;

import org.testng.annotations.Test;
import com.myapp.utils.CommonAssertions;

public class LoginTest extends BaseTest{
	
	@Test
	public void testLogin() throws InterruptedException {
		
		hp.clickSignUpBtn();
		CommonAssertions.verifyTrue(sp.isLoginAccountLabelVisible());
		String email=prop.getProperty("loginEmail");
		String password=prop.getProperty("loginPassword");
		sp.enterCredsAndLogin(email, password);
//		sp.clickDeleteBtn();
//		CommonAssertions.verifyTrue(sp.isAccountDeletedVissible());
		
	}
	
	
	@Test
	public void testLoginWithIncorrectCreds() throws InterruptedException {
		
		hp.clickSignUpBtn();
		CommonAssertions.verifyTrue(sp.isLoginAccountLabelVisible());
		String incorrectEmail=prop.getProperty("incorrectEmail");
		String incorrectPassword=prop.getProperty("incorrectPassword");
		sp.enterCredsAndLogin(incorrectEmail, incorrectPassword);
		CommonAssertions.verifyTrue(sp.isLoginAccountLabelVisible());
		
	}

}
