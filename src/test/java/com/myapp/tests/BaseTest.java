package com.myapp.tests;

import org.testng.annotations.AfterMethod;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.myapp.Context.DriverManager;
import com.myapp.pageobjects.HomePage;
import com.myapp.pageobjects.SignUpPage;
import com.myapp.utils.TestProperties;

public class BaseTest {
	
	WebDriver driver= null;
	Properties prop;
	
	@BeforeMethod
	@Parameters({"browserName"})
	public void setup(@Optional String browserName) throws Exception {
		
		browserName=prop.getProperty("browserName");
		
		if(browserName.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		} else if(browserName.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		} else {
			System.out.println("Browser does not exist");
		}
		
		String env=prop.getProperty("env");
		String URL= prop.getProperty(env);
		System.out.println("Executing in "+ env);
		
		initPages();
		DriverManager.setDriver(driver);
		DriverManager.getDriver();
		DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		DriverManager.getDriver().manage().deleteAllCookies();
		DriverManager.getDriver().manage().window().maximize();
		DriverManager.getDriver().get(URL);
		
		
	}
	
	HomePage hp;
	SignUpPage sp;
	
	
	public void initPages() {
		hp=new HomePage(driver);
		sp= new SignUpPage(driver);
	}
	
	
	@BeforeSuite
	public void presetup() throws IOException {
		prop=TestProperties.getProperties();
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
