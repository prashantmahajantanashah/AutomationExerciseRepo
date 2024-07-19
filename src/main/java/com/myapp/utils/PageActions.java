package com.myapp.utils;

import java.io.File;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.myapp.Context.Constants;

public class PageActions {
	WebDriver driver;
	WebDriverWait wait;
	
	public PageActions(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
	}
	
	public void waitUntilDisplayed(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitUntilClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void clickElement(WebElement element) {
		
		try {
		waitUntilDisplayed(element);
		waitUntilClickable(element);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
		} catch (Exception e) {
            System.out.println("Failed to click the element: " + e.getMessage());
            // Optionally, add more logging or rethrow the exception
        }
		
	}
	
	public boolean isElementDisplayed(WebElement element) {
		
		return element.isDisplayed();
	}
	
	public void enterText(WebElement element, String text) throws InterruptedException {
		waitUntilDisplayed(element);
		waitUntilClickable(element);
		shortWait();
		element.sendKeys(text);
	}
	
	public void shortWait() throws InterruptedException {
		Thread.sleep(2000);
	}
	
	public void scroll(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);

	}
	
	public void selectElementFromDropdown(WebElement ele, String text) {
		
		Select select =new Select(ele);
		select.selectByVisibleText(text);
		
	}
	
//	public void scrollByValue() {
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("window.scrollBy(0,1000)","");
//
//	}
	
	public String getElementText(WebElement ele) {
		return ele.getText();
	}
	
	public void getScreenshot() {
		
		TakesScreenshot screenshot=(TakesScreenshot)driver;
		File src=screenshot.getScreenshotAs(OutputType.FILE);
		
		File desc= new File(Constants.workingDirectory + "/Screenshots/screenshot" +  UniqueGenrator.getUniqueSting() +".png");
		
		
		
	}

}
