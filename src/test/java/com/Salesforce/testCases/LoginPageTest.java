package com.Salesforce.testCases;

import org.testng.annotations.Test;

import com.Salesforce.pages.LoginPage;
import com.Salesforce.utilties.BaseUtility;

import junit.framework.Assert;

public class LoginPageTest extends BaseTest {

	
	
	@SuppressWarnings("deprecation")
	@Test(priority=1)
	public void validateTitleOfLoginPage() 
	{
		String ACTUAL_TITLE = page.getInstance(LoginPage.class).validateTitleOfPage();
		System.out.println(ACTUAL_TITLE);
		Assert.assertEquals(BaseUtility.EXPECTED_TITLE_LOGIN_PAGE, ACTUAL_TITLE);
	}
	@Test(priority=2)
	public void validateLoginPage() 
	{
		page.getInstance(LoginPage.class).validateLoginPage();
	}
	@Test(priority=3)
	public void loginApplication()
	{

			page.getInstance(LoginPage.class).loginToApplication(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	

}
