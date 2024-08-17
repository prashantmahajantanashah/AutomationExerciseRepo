package com.myapp.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage extends BasePage{

	public ContactUsPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[@class='contact-form']/h2")
	private WebElement getInTouchLabel;
	
	@FindBy(xpath="//input[@placeholder='Name']")
	private WebElement NameInput;
	
	@FindBy(xpath="//input[@placeholder='Email']")
	private WebElement EmailInput;
	
	@FindBy(xpath="//input[@placeholder='Subject']")
	private WebElement SubjectInput;
	
	@FindBy(id="message")
	private WebElement MessageInput;
	
	@FindBy(xpath="//input[@name='upload_file']")
	private WebElement chooseFileUploadBtn;
	
	@FindBy(xpath="//input[@name='submit']")
	private WebElement submitBtn;
	
	
	public boolean isGetInTouchVisible() {
		return isElementDisplayed(getInTouchLabel);
	}
	
	
	
	
	

}
