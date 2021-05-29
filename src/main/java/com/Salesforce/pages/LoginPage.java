package com.Salesforce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * @author Saumya
 *
 */

public class LoginPage extends BasePage {

	//Constructor
	public LoginPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);

	}
	//Object Repository
	
	By emailId = By.cssSelector("#username");
	By password = By.cssSelector("#password");
	By loginBtn = By.cssSelector("#Login");
	By forgetPwd = By.cssSelector("#forgot_password_link");
	By SignUp = By.cssSelector("#signup_link");
	By customeDomain = By.cssSelector("#mydomainLink");
	By salesForceLogo = By.cssSelector("#logo");
	
	
	//Action methods
	public String validateTitleOfPage()
	{
		return driver.getTitle();
	}
	
	public void validateLoginPage()
	{
		//all locators
		driver.findElement(emailId).isDisplayed();
		driver.findElement(password).isDisplayed();
		driver.findElement(loginBtn).isDisplayed();
		driver.findElement(forgetPwd).isDisplayed();
		driver.findElement(SignUp).isDisplayed();
		driver.findElement(customeDomain).isDisplayed();
		driver.findElement(salesForceLogo).isDisplayed();
		System.out.println("All Elements are present");
	}
	
	public void loginToApplication(String username, String pwd)
	{
		doSendKeys(emailId, username);
		doSendKeys(password, pwd);
		doClick(loginBtn);
	}
	
	public void forgetPassword()
	{
		doClick(forgetPwd);
	}
	
	public void signUpLink()
	{
		doClick(SignUp);
	}
	
	

}
