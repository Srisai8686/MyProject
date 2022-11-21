/**
 * 
 */
package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

/**
 * @author kdsrisaichary
 *
 */
public class IndexPage extends BaseClass{
	
	@FindBy(xpath = "//a[@class='login']")
	WebElement signInBtn;
	
	@FindBy(xpath = "//img[@class='logo img-responsive']")
	WebElement myStoreLogo;
	
	@FindBy(id = "search_query_top")
	WebElement searchProductBox;
	
	@FindBy(xpath = "//button[@name='submit_search']")
	WebElement searchBtn;
	
	public IndexPage() {
		PageFactory.initElements(getDriver(), this);
	}
 
	public LoginPage clickOnSignIn() throws Throwable{
		Action.click(getDriver(), signInBtn);
		return new LoginPage();
	}
	
	public boolean myStoreLogo() throws Throwable{
		return Action.isDisplayed(getDriver(), myStoreLogo);
		
	}
	
	public String getTitle() {
		 String myPageTitle= getDriver().getTitle();
		 return myPageTitle;
	}
	
	public SearchResultPage searchProduct(String productName) {
		Action.type(searchProductBox, productName);
		Action.click(getDriver(), searchBtn);
		return new SearchResultPage();
	}
}
