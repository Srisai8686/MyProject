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
public class AddToCartPage extends BaseClass{
 
	@FindBy(id="quantity_wanted")
	private WebElement quantity;
	
	@FindBy(name="group_1")
	private WebElement size;
	
	@FindBy(xpath="//span[text()='Add to cart']")
	private WebElement addToCartBtn;
	
	@FindBy(xpath="//*[@id=\"layer_cart\"]//h2/i")
	private WebElement addToCartMessag;;
	
	@FindBy(xpath="//span[contains(text(),'Proceed to checkout')]")
	private WebElement proceedToCheckOutBtn;
	
	public AddToCartPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public void enterQuantity(String QuantityNum) {
		Action.type(quantity, QuantityNum);
	}
	
	public void selectSize(String sizeNum) {
		Action.selectByVisibleText(sizeNum,size);
	}
	
	public void clickAddToCart() {
		//Action.fluentWait(driver, addToCartBtn, 10);
		Action.click(getDriver(), addToCartBtn);
	}
	
	public boolean validateAddToCart() {
		//Action.fluentWait(driver, addToCartBtn, 10);
		Action.fluentWait(getDriver(), addToCartMessag, 10);
		return Action.isDisplayed(getDriver(), addToCartMessag);
		
	}
	public OrderPage clickProceedCheckout() {
		Action.fluentWait(getDriver(), proceedToCheckOutBtn, 10);
		Action.JSClick(getDriver(), proceedToCheckOutBtn);
		return new OrderPage();
	}
}
