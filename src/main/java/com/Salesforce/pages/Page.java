package com.Salesforce.pages;

import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * @author Saumya
 * Craete Hybid Page Object Model---> Using ava Generics
 *
 */

public class Page {
	
	public WebDriver driver;
	public WebDriverWait wait;
	
	
	//Creating Constructor
	public Page(WebDriver driver, WebDriverWait wait)
	{
		
		this.driver = driver;
		this.wait = wait;
	}
	
	
	//create a method with Java Generics and return a new Page
	public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass) 
	{
			try {
				return pageClass.getDeclaredConstructor(WebDriver.class, WebDriverWait.class).newInstance(this.driver, this.wait);
			} catch (InstantiationException e) {
				
				e.printStackTrace();
			} catch (IllegalAccessException e) {
		
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				
				e.printStackTrace();
			} catch (InvocationTargetException e) {
			
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				
				e.printStackTrace();
			} catch (SecurityException e) {
				
				e.printStackTrace();
			}
			return null;
	
	}
}
