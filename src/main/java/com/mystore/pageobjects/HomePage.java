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
public class HomePage extends BaseClass{

	@FindBy(xpath="//span[text()='My wishlists']")
	WebElement myWishListBtn;
	
	@FindBy(xpath="//span[text()='Order history and details']")
	WebElement orderAndHistoryDetailsBtn;
	
	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean verifyMyWishList() {
		return Action.isDisplayed(getDriver(), myWishListBtn);
	}
	
	public boolean verifyOrderHistory() {
		return Action.isDisplayed(getDriver(), orderAndHistoryDetailsBtn);
	}
	
	public String getCurrentUrl() {
		String currentUrl = getDriver().getCurrentUrl();
		return currentUrl;
	}
}
