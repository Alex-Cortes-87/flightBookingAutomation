package com.alex.training.app.pages.wikipedia;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.alex.training.app.pages.BasePage;

public class ResultPage extends BasePage {
	private final String RESULT_TITLE_ID = "firstHeading";
	private final String TABLE_OF_CONTENT_BOX__ID = "toc";
	
	@FindBy(id = RESULT_TITLE_ID)
	private WebElement resultTitle;
	
	@FindBy(id = TABLE_OF_CONTENT_BOX__ID)
	WebElement tocBox;
	
	protected ResultPage(WebDriver pDriver) {
		super(pDriver);
	}
	
	public String getHeadingTitle() {
		return resultTitle.getText();
	}

	public boolean isTocVisible() {
		getWait().until(ExpectedConditions.visibilityOf(tocBox));
		return tocBox.isDisplayed();
	}

}
