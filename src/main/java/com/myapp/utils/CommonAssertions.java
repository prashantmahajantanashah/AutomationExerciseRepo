package com.myapp.utils;

import org.testng.Assert;

public class CommonAssertions {
	
	public static void verfiyEqual(String actual, String expected, String failedMsg) {
		Assert.assertEquals(actual, expected, failedMsg);
	}
	
	public static void verifyTrue( boolean condition) {
		Assert.assertTrue(condition, "Unable to authenticate");
	}
	
	public static void verifyFalse( boolean condition) {
		Assert.assertTrue(condition, "Unable to authenticate");
	}
	
	

}
