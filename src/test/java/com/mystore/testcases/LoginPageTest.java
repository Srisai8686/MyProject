/**
 * 
 */
package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;

/**
 * @author kdsri
 *
 */
public class LoginPageTest extends BaseClass{
	
	IndexPage indexPage;
	
	LoginPage loginPage;
	HomePage homePage;
	
	@BeforeMethod
	public void setup() {
		launchApp();
	}
	
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test
	public void loginTest() throws Throwable {
		Log.startTestCase("loginTest");
		indexPage = new IndexPage();
		Log.info("User is going to click on signin");
		  loginPage= indexPage.clickOnSignIn();
		  Log.info("Getting username and password from properties file");
		  homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		  Log.info("getting current url from page");
		  String ActualURL = homePage.getCurrentUrl();
		  Log.info("Validating if user is on login page");
		  String expectedURL = "http://automationpractice.com/index.php?controller=my-account";
		  Assert.assertEquals(ActualURL, expectedURL);
		  Log.info("Login is successful");
		  Log.endTestCase("loginTest");
		  
		  
	}

}
