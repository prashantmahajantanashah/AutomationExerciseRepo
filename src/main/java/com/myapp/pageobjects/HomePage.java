package com.myapp.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myapp.utils.PageActions;

public class HomePage extends BasePage{
	
	WebDriver driver;
	public HomePage(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[text()=' Signup / Login']")
	private WebElement SignUpBtn;
	
	public boolean isHomePageDisplayed() {
		return isElementDisplayed(HomePageBtn);
	}
	
	public void clickSignUpBtn() {
		clickElement(SignUpBtn);
	}
	
	

}
