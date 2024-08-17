package com.myapp.tests;

import org.testng.annotations.Test;

import com.myapp.utils.CommonAssertions;

public class ContactUsTest extends BaseTest{
	
	@Test
	public void contactUsTest() {
		hp.clickContactUsBtn();
		CommonAssertions.verifyTrue(cp.isGetInTouchVisible());
	}

}
