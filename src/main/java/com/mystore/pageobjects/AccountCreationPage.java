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
public class AccountCreationPage extends BaseClass{

	@FindBy(xpath="//h1[text()='Create an account']")
	WebElement formTitle;
	
	public AccountCreationPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean verifyAccountCreationPage() {
		return Action.isDisplayed(getDriver(), formTitle);
	}
}
