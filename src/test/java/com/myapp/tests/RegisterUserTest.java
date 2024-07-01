package com.myapp.tests;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.myapp.utils.TestProperties;
public class RegisterUserTest extends BaseTest{
	
	@Test
	public void registerUser() throws InterruptedException, IOException {
		
		//validate homePage is displayed
		Assert.assertTrue(hp.isHomePageDisplayed(), "HomePage is not displayed");
		
		//click signup btn
		hp.clickSignUpBtn();
		
		//validate homepage is loaded successfully
		Assert.assertTrue(sp.isHomePageLoaded(), "New User SignUp not visible");
		
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
		String zipcode=faker.address().zipCode().toString();
		String mobNum=faker.number().toString();
		
		
		//Enter name and email and click submit
		sp.enterNameAndEmailAndSubmit(FirstName, email);
		
		//Validate acc label is displayed
		Assert.assertTrue(sp.isAccInfoLabel(), "Enter Account Information is not visible");
		
		sp.signUpFillDetails(password, FirstName, lastName, company, address, state, city, zipcode, mobNum);
		
		Assert.assertTrue(sp.isAccountCreated());
		
		sp.clickContinue();
		
		String loggedInUser=sp.getUserLoggedInValue();
		Properties prop=TestProperties.getProperties();
		Assert.assertEquals(loggedInUser, prop.getProperty("loggedInMsg")+FirstName);
		sp.clickDeleteBtn();
		Assert.assertTrue(sp.isAccountDeletedVissible());
		sp.clickContinue();
	}

}
