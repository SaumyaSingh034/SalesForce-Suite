package com.Salesforce.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Salesforce.utilties.BaseUtility;

public class BasePage extends Page{
	
	public static Properties prop;
	public static String browserName;

	public BasePage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		
	}
	
	
	//generic until wrappers--->>>>>
	
	public void doClick(By locator)
	{
		driver.findElement(locator).click();
	}
	
	public void doSendKeys(By locator, String text)
	{
		driver.findElement(locator).sendKeys(text);
	}
	
	public void doGetText(By locator)
	{
		driver.findElement(locator).getText();
	}
	
	


}
