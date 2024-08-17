package com.myapp.pageobjects;

import org.openqa.selenium.WebDriver;


import org.openqa.selenium.support.PageFactory;


import com.myapp.utils.PageActions;

public class BasePage extends PageActions {
	
	WebDriver driver;
	
	public BasePage(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

}
