package com.myapp.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage extends BasePage {
	
	WebDriver driver;
	public SignUpPage (WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//h2[text()='New User Signup!']")
	private WebElement SignUpLabel;
	
	@FindBy(xpath="//input[@data-qa='signup-name']")
	private WebElement enterSignUpName;
	
	@FindBy(xpath="//input[@data-qa='signup-email']")
	private WebElement enterSignUpEmail;
	
	@FindBy(xpath="//button[@data-qa='signup-button']")
	private WebElement submitBtn;
	
	@FindBy(xpath="//b[text()='Enter Account Information']")
	private WebElement accInfoLabel;
	
	@FindBy(id="id_gender1")
	private WebElement MrRadioBtn;
	
	@FindBy(id="password")
	private WebElement fillPassword;
	
	@FindBy(xpath="//*[text()='Date of Birth']")
	private WebElement dateOfBirth;
	
	@FindBy(xpath="//*[@id='days']")
	private WebElement dateValue;
	
	@FindBy(xpath="//*[@id='months']")
	private WebElement monthValue;
	
	@FindBy(xpath="//*[@id='years']")
	private WebElement yearValue;
	
	@FindBy(xpath="//*[@id='first_name']")
	private WebElement firstNameField;
	
	@FindBy(xpath="//*[@id='last_name']")
	private WebElement lastNameField;
	
	@FindBy(xpath="//*[@id='company']")
	private WebElement companyField;
	
	@FindBy(xpath="//*[@id='address1']")
	private WebElement addressField;
	
	@FindBy(xpath="//*[@id='country']")
	private WebElement selectCountry;
	
	@FindBy(id="state")
	private WebElement selectState;
	
	@FindBy(id="city")
	private WebElement selectCity;
	
	@FindBy(id="zipcode")
	private WebElement selectZipcode;
	
	@FindBy(id="mobile_number")
	private WebElement selectMobileNum;
	
	@FindBy(xpath="//input[@id='address2']")
	private WebElement addressLabel;
	
	@FindBy(xpath="//button[@data-qa='create-account']")
	private WebElement createAccountBtn;
	
	@FindBy(xpath="//h2[@class='title text-center']/b")
	private WebElement accountCreatedBtn;
	
	@FindBy(xpath="//a[text()='Continue']")
	private WebElement continueBtn;
	
	@FindBy(xpath="//ul[@class='nav navbar-nav']/li[10]/a")
	private WebElement userLoggedInBtn;
	
	@FindBy(xpath="//ul[@class='nav navbar-nav']/li")
	private List<WebElement> headerItems;
	
	@FindBy(css=".fa.fa-trash-o")
	private WebElement DeleteBtn;
	
	@FindBy(xpath="//b[text()='Account Deleted!']")
	private WebElement AccDeletedLabel;
	
	
	
	public boolean isHomePageLoaded() {
		return isElementDisplayed(SignUpLabel);
	}
	
	public boolean isAccInfoLabel() {
		return isElementDisplayed(accInfoLabel);
	}
	
	
	public boolean isAccountCreated() {
		return isElementDisplayed(accountCreatedBtn);
	}
	
	public void enterNameAndEmailAndSubmit(String name, String email) throws InterruptedException {
		enterText(enterSignUpName, name);
		enterText(enterSignUpEmail, email);
		clickElement(submitBtn);

	}
	
	public void signUpFillDetails(String password, String firstName, String lastName, String company, String address, 
			String State, String city, String zipcode, String mobileNum) throws InterruptedException {
		clickElement(MrRadioBtn);
		enterText(fillPassword, password);
		scroll(dateOfBirth);
		shortWait();
		selectDateMonthYear("25","September","1992");
		enterText(firstNameField, firstName);
		enterText(lastNameField, lastName);
		enterText(companyField, company);
		enterText(addressField, address);
		scroll(addressLabel);
		shortWait();
		enterText(addressField, address);
		enterText(selectCountry, "Canada");
		enterText(selectState, State);
		enterText(selectCity, city);
		enterText(selectZipcode, zipcode);
		enterText(selectMobileNum, mobileNum);
		createAccountBtn.click();
		
	}
	
	public void selectDateMonthYear(String date, String month, String year) {
		selectElementFromDropdown(dateValue, date);
		selectElementFromDropdown(monthValue, month);
		selectElementFromDropdown(yearValue, year);
	}
	
	public void clickContinue() {
		continueBtn.click();
	}
	
	public String getUserLoggedInValue() {
		return getElementText(userLoggedInBtn);
	}
	
	
	public void clickDeleteBtn(){
		clickElement(DeleteBtn);
	}
	
	public boolean isAccountDeletedVissible() {
		return isElementDisplayed(AccDeletedLabel);
	}
	
//	public void clickElementMatchingTheLinkText(String text) throws InterruptedException {
//		
//		shortWait();
//		for(WebElement e: headerItems) {
//			try {
//			if(e. equalsIgnoreCase(text)) {
//				clickElement(e);
//				break;
//			}
//			}catch (NullPointerException E) {
//				System.out.println("Attribute not present");
//			}
//		}
//	}

}
