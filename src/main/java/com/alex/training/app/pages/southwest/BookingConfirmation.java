package com.alex.training.app.pages.southwest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.alex.training.app.pages.BasePage;

public class BookingConfirmation extends BasePage {

private final String CONFIRMATION_NUMBER = ".trip-summary-item--confirmation > div:nth-child(2)";
	
	@FindBy(css = CONFIRMATION_NUMBER)
	WebElement confirmation_number;
	
	BookingConfirmation(WebDriver pDriver){
		super(pDriver);
	}
	
	public String confirmationNumber() {
		getWait().until(ExpectedConditions.visibilityOf(confirmation_number));
		return confirmation_number.getText();
	}

}
