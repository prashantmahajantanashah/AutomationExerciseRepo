package com.myapp.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{
	
	WebDriver driver;
	
	public HomePage(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[text()=' Signup / Login']")
	private WebElement SignUpBtn;
	
	@FindBy(xpath="//a[text()=' Home']/i")
	protected WebElement HomePageBtn;
	
	@FindBy(xpath="//a[text()=' Contact us']/i")
	protected WebElement ContactUsBtn;
	
	@FindBy(xpath="//a[text()=' Products']/i")
	protected WebElement ProductsBtn;
	
	public boolean isHomePageDisplayed() {
		return isElementDisplayed(HomePageBtn);
	}
	
	public void clickSignUpBtn() {
		clickElement(SignUpBtn);
	}
	
	public void clickContactUsBtn() {
		clickElement(ContactUsBtn);
	}
	
	public void clickProductsBtn() {
		clickElement(ProductsBtn);
	}
	
	

}
