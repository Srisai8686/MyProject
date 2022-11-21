package com.mystore.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeSuite;

import com.mystore.actiondriver.Action;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static Properties prop;
	//public static WebDriver driver;
	
	
	// Declare ThreadLocal Driver
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
	
	
	
	@BeforeSuite()
	public void loadConfig() {
		DOMConfigurator.configure("log4j.xml");

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\Configuration\\Config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static WebDriver getDriver() {
		// Get Driver from threadLocalmap
		return driver.get();
	}
	
	public void launchApp() {
		WebDriverManager.chromedriver().setup();
		String browserName1= prop.getProperty("browser");
		
		if(browserName1.contains("Chrome")) {
			//driver = new ChromeDriver();
			driver.set(new ChromeDriver());
			
		}else if(browserName1.contains("Frefox")) {
			//driver  = new FirefoxDriver();
			driver.set(new FirefoxDriver());
		}else if(browserName1.contains("IE")) {
			//driver = new InternetExplorerDriver();
			driver.set(new InternetExplorerDriver());
		}
		
		//Maximize the screen
		getDriver().manage().window().maximize();
		//Delete all the cookies
		getDriver().manage().deleteAllCookies();
		Action.implicitWait(getDriver(), 10);
		Action.pageLoadTimeOut(getDriver(), 20);
		getDriver().get(prop.getProperty("url"));
	
		
	}
	
}
