package com.myapp.Context;

import org.openqa.selenium.WebDriver;

public class DriverManager {
	
	private static ThreadLocal<WebDriver> driverInstance=new ThreadLocal<WebDriver>();
	
	public static WebDriver getDriver() throws Exception{
		if(driverInstance.get()==null) {
			throw new Exception("driver not available");
		} else {
			return driverInstance.get();
		}
		
	}
	
	public static void setDriver(WebDriver driver) {
		driverInstance.set(driver);
	}
	
	

}
