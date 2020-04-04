package com.alex.training.app.pages.wikipedia;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.alex.training.app.pages.BasePage;


public class HomePage extends BasePage {
	
	private final String SEARCH_INPUT = "searchInput";
	private final String SEARCH_BTN = "#search-form > fieldset > button";
	
	@FindBy(id = SEARCH_INPUT)
	private WebElement searchInput;
	
	@FindBy(css = SEARCH_BTN)
	private WebElement searchBtn;

	public HomePage(WebDriver pDriver) {
		super(pDriver);
		String url = "https://www.wikipedia.org/";
		getDriver().get(url);
		
	}
	
	public void setSearchTerm(String textToSearch) {
		searchInput.sendKeys(textToSearch);
	}
	
	public String getSearchTerm() {
		return searchInput.getAttribute("value");
	}
	
	public ResultPage submitSearch() {
		searchBtn.click();
		return new ResultPage(getDriver());
	}

}
