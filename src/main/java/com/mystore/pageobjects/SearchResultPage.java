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
 * @author kdsri
 *
 */
public class SearchResultPage extends BaseClass{

	@FindBy(xpath="//img[@title='Faded Short Sleeve T-shirts']")
	WebElement productResult;
	
	public SearchResultPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean isProductDisplayed() {
		return Action.isDisplayed(getDriver(), productResult);
	}
	
	public AddToCartPage clickOnproduct() {
		Action.click(getDriver(), productResult);
		return new AddToCartPage();
	}
}
