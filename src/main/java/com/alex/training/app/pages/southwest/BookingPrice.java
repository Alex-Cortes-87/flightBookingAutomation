package com.alex.training.app.pages.southwest;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.alex.training.app.pages.BasePage;

public class BookingPrice extends BasePage {
	
	private final String  CONTINUE_TO_PAYMENT_BUTTONS = ".price--continue-button";
	
	
	@FindBy(css = CONTINUE_TO_PAYMENT_BUTTONS )
	List <WebElement> continue_to_payment_buttons;
	
	
	protected BookingPrice(WebDriver pDriver) {
		super(pDriver);
		
	}
	

	public BookingPurchase submitSearchPrice() {
		
			getWait().until(ExpectedConditions.visibilityOfAllElements(continue_to_payment_buttons));
			continue_to_payment_buttons.get(0).click();
			getWait().until(ExpectedConditions.urlContains("purchase"));
			return new BookingPurchase(getDriver());
			
			}

}
