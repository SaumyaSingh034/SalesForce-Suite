package com.Salesforce.testCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.Salesforce.pages.BasePage;
import com.Salesforce.pages.Page;
import com.Salesforce.utilties.BaseUtility;

public class BaseTest{
	public WebDriver driver;
	public WebDriverWait wait;
	public Page page;
	public Properties prop;
	public static String browserName;
	
	public BaseTest() {
	
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(BaseUtility.CONFIG_PROPERTIES_FILEPATH);
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	
	@BeforeMethod
	public void setUp()
	{
		
		browserName = prop.getProperty("browser");
		
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"D:\\Selenium\\FrameworkPractice\\SalesForceSuite\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			

		} else if (browserName.equalsIgnoreCase("ie")) {

			driver = new InternetExplorerDriver();
			System.setProperty("webdriver.ie.driver",
					"D:\\Selenium\\FrameworkPractice\\SalesForceSuite\\drivers\\IEServer.exe");

		} else if (browserName.equalsIgnoreCase("firefox")) {

			driver = new FirefoxDriver();
			System.setProperty("webdriver.gecko.driver",
					"D:\\Selenium\\FrameworkPractice\\POMHybridFramework" + "\\drivers\\geckodriver.exe");

		} else if (browserName.equalsIgnoreCase("edge")) {

			driver = new EdgeDriver();
			System.setProperty("webdriver.edge.driver",
					"D:\\Selenium\\FrameworkPractice\\SalesForceSuite\\drivers\\edgedriver.exe");

		} else {
			System.out.println("Please Check Your Browser. You have enter wrong browser......");
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(BaseUtility.PAGE_LOAD_TIME, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(BaseUtility.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.get(prop.getProperty("url"));
		page = new Page(driver, wait);
		
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
