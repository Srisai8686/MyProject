/**
 * 
 */
package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

/**
 * @author kdsri
 *
 */
public class AccountCreationTest extends BaseClass{
	
	 IndexPage indexPage;
		
	 LoginPage loginPage;
	 
	 AccountCreationPage accountCreationPage;
	
	@BeforeMethod
	public void setup() {
		launchApp();
	}
	
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}
	@Test
	public void verifyAccountCreationPageTest() throws Throwable {
		indexPage = new IndexPage();
		loginPage= indexPage.clickOnSignIn();
		accountCreationPage = loginPage.createNewAccount("fghgfdf@gmail.com");
		boolean result = accountCreationPage.verifyAccountCreationPage();
		Assert.assertTrue(result);
	}

}
