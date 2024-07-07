package com.myapp.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.Properties;
import org.testng.Assert;
import com.github.javafaker.Faker;
import com.myapp.utils.CommonAssertions;
import com.myapp.utils.TestProperties;
public class RegisterUserTest extends BaseTest{
	
	
	@Test
	public void registerUser() throws InterruptedException, IOException {
		
		//validate homePage is displayed
		CommonAssertions.verifyTrue(hp.isHomePageDisplayed());
		
		//click signup btn
		hp.clickSignUpBtn();
		
		//validate homepage is loaded successfully
		CommonAssertions.verifyTrue(sp.isHomePageLoaded());
		
		//Create faker object
		Faker faker = new Faker();
		
		//Generate random name
		String FirstName=faker.name().firstName();
		String email=faker.internet().emailAddress().toString();
		String lastName=faker.name().lastName().toString();
		String password=faker.internet().password();
		String company=faker.company().toString();
		String address=faker.address().toString();
		String state=faker.address().state().toString();
		String city=faker.address().city().toString();
		String country=prop.getProperty("country");
		String zipcode=faker.address().zipCode().toString();
		String mobNum=faker.number().toString();
		System.out.println(email);
		System.out.println(password);
		//Enter name and email and click submit
		sp.enterNameAndEmailAndSubmit(FirstName, email);
		
		//Validate acc label is displayed
		CommonAssertions.verifyTrue(sp.isAccInfoLabel());
		
		sp.signUpFillDetails(password, FirstName, lastName, company, address, state, city, country, zipcode, mobNum);
		
		CommonAssertions.verifyTrue(sp.isAccountCreated());
		
		sp.clickContinue();
		
		String loggedInUser=sp.getUserLoggedInValue();
		Properties prop=TestProperties.getProperties();
		
		CommonAssertions.verfiyEqual(loggedInUser, prop.getProperty("loggedInMsg")+FirstName , "Mismatch");
		sp.clickDeleteBtn();
		CommonAssertions.verifyTrue(sp.isAccountDeletedVissible());
		sp.clickContinue();
		
		
		
	}

}
