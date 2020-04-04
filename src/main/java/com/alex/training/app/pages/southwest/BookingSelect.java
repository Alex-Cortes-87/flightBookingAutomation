package com.alex.training.app.pages.southwest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.alex.training.app.pages.BasePage;


public class BookingSelect extends BasePage {

private final String DEPARTING_FLIGHTS_TITLE = "//*[@class=\"container container_standard\"]//h3[@class=\"heading heading_large price-matrix--sub-title\"]";
private final String DEPARTING_CONTAINER = "air-booking-product-0";
private final String DEPARTING_FARES_MATRIX = "//*[@class=\"transition-content price-matrix--details-area\"]//li";
private final String TIME_VALUE = "time--value";
private final String FLIGHT_FAIRS = "select-detail--fares";
private final String DETAILED_FAIR = ">div>button";
private final String FARE_INFO = "aria-label";
private final String NEXT_PAGE = ".search-results--actions > button";




	@FindBy(xpath = DEPARTING_FLIGHTS_TITLE)
	private WebElement DepartingFlightsTittle;
	
	@FindBy(id = DEPARTING_CONTAINER)
	private WebElement DepartingContainer;
	
	@FindBy(css = NEXT_PAGE)
	private WebElement nextPage;
	
		
	protected BookingSelect(WebDriver pDriver) {
		super(pDriver);
		
	}
	
	public void oneway_flight_selector(String hour, String fareProduct) {
		
		String flight = flightFaresSelector(DepartingContainer, hour);
		flightSpecificFareSelector(flight, fareProduct);
		//getWait().until(ExpectedConditions.elementToBeClickable(nextPage));
		//nextPage.click();
				
		}
	
	public BookingPrice submitSearchSelect() {
		
		getWait().until(ExpectedConditions.elementToBeClickable(nextPage));
		nextPage.click();
		getWait().until(ExpectedConditions.urlContains("price"));
		return new BookingPrice(getDriver());
	}
	
	
	
	public String flightFaresSelector(WebElement container, String hour_meridian) {
		
		String[] split_hour = hour_meridian.split(" ");

		getWait().until(ExpectedConditions.visibilityOf(DepartingFlightsTittle));
		String booking_fares_id = container.findElements(By.xpath(DEPARTING_FARES_MATRIX)).stream()
	    .filter(fares -> fares.findElement(By.className(TIME_VALUE)).getText().contains(split_hour[0]) && fares.findElement(By.className(TIME_VALUE)).getText().contains(split_hour[1]))
	    .findFirst().get().findElements(By.className(FLIGHT_FAIRS)).stream().findFirst().get().getAttribute("id").toString();
	    return ("#".concat(booking_fares_id.concat(DETAILED_FAIR)));
		//return DepartingFlightsTittle.getText();
	}
	


	public void flightSpecificFareSelector(String flightSelection, String fareSelection) {
	
		List <WebElement> fares_list = getDriver().findElements(By.cssSelector(flightSelection));
		fares_list.stream().filter(fareName -> fareName.getAttribute(FARE_INFO).contains(fareSelection) && fareName.isEnabled())
		.findFirst().get().click();
	}
	
}
