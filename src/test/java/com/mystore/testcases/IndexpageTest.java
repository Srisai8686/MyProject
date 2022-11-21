/**
 * 
 */
package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;

/**
 * @author kdsri
 *
 */
public class IndexpageTest extends BaseClass {
	
	IndexPage indexpage;
   
	@BeforeMethod
	public void setup() {
		launchApp();
	}
	
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test
	public void verifyLogo() throws Throwable {
		indexpage = new IndexPage();
		boolean isdisplayed = indexpage.myStoreLogo();
		Assert.assertTrue(isdisplayed);
		System.out.println("Logo is validated");
	}
	
	@Test
	public void verifyTitle() {
		indexpage = new IndexPage();
		String pageTitle = indexpage.getTitle();
		Assert.assertEquals(pageTitle, "My Store");
		
	}
}
