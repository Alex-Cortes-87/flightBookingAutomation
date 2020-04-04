package com.alex.training.app.pages.southwest;

import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.alex.training.app.pages.BasePage;


public class BookingIndex extends BasePage {
	
	//private final String SEARCH_INPUT = "searchInput";
	private final String SEARCH_BTN = "form-mixin--submit-button";
	private final String SELECT_FLIGHT_TYPES = ".check-fares-search--flight > fieldset > .input-group--list > .input-group--item";
	private final String DEPARTURE_FIELD = "originationAirportCode";
	private final String ARRIVAL_FIELD ="destinationAirportCode";
	private final String ENGLISH_LANGUAGE = "#cta-wrapper >li >#en";
	private final String SPANISH_LANGUAGE = "#cta-wrapper >li >#es";
	private final String CALENDAR_BUTTON = "//*[@id=\"departureDate\"]/parent::node()/*[@class=\"input--icon-separator\"]";
	private final String RETURN_DATE = "returnDate";
	private final String MONTH_NAME = ".calendar-month >.calendar-month--watermark";
	private final String NEXT_CALENDARS_BUTTON = ".calendar-controls > button >span[icon=swa-icon_arrow-right]";
	private final String CALENDAR1 = ".calendar-controls > div:nth-child(2)> .calendar-month--days  > button";
	private final String CALENDAR2 = ".calendar-controls > div:nth-child(3)> .calendar-month--days  > button";
	private final String PASSENGERS_SELECTION = "adultPassengersCount";
	private final String NUMBER_OF_PASSENGERS = "#adultPassengersCount--menu > li";
	private final String MONTHS[] = {"Jan", "Feb", "Mar", "Apr", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

	
	
	@FindBy(id = SEARCH_BTN)
	private WebElement searchBtn;
	
	@FindBy(css = SELECT_FLIGHT_TYPES)
	private List<WebElement> selectFlightTypes;
	
	@FindBy(id= DEPARTURE_FIELD)
	private WebElement departure_field;
	
	@FindBy(id= ARRIVAL_FIELD)
	private WebElement arrival_field;
	
	@FindBy(css= ENGLISH_LANGUAGE)
	private WebElement english_language;
	
	@FindBy(css= SPANISH_LANGUAGE)
	private WebElement spanish_language;
	
	@FindBy(id= RETURN_DATE)
	private WebElement return_date;
	
	@FindBy(xpath = CALENDAR_BUTTON)
	private WebElement calendar_button;
	
	@FindBy(css = NEXT_CALENDARS_BUTTON)
	private WebElement next_calendars_button;
	
	@FindBy(css = CALENDAR1)
	private List <WebElement> calendar1;
	
	@FindBy(css = CALENDAR2)
	private List <WebElement> calendar2;
	
	@FindBy(css = MONTH_NAME)
	private List <WebElement> month_name;
	
	@FindBy(id= PASSENGERS_SELECTION)
	private WebElement passengers_selection;
	
	@FindBy(css= NUMBER_OF_PASSENGERS)
	private List<WebElement> number_of_passengers;
	
	public BookingIndex(WebDriver pDriver) {
		super(pDriver);
		//String url = "https://www.wikipedia.org/";
		String url = "https://southwest.dev8.southwest.com/air/booking/index.html";
		getDriver().get(url);
	}
	
	public void select_language(String language) {
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		getDriver().switchTo().frame("lightbox_pop");
		if (language == "English") {
			english_language.click();
		}
		else if (language == "Spanish") {
			spanish_language.click();
		}
		
		getDriver().switchTo().parentFrame();
		
	}
	
	public void selectFlightType (String flighttype) {
		
		for(WebElement type:selectFlightTypes) {
			if(flighttype.equals(type.getText())) {
				type.click();
				
			}
			
		}
	}
	
	public void select_flights(String departure, String arrival, String departureDate, int passengersAmount) {
		
		String splitdate[] = departureDate.split("/");
		int month = Integer.parseInt(splitdate[0]);
		String day = splitdate[1];
		int release = 0;
		int calendar_picker =0;
		departure_field.sendKeys(departure);
		arrival_field.sendKeys(arrival);
		calendar_button.click();
		
		do {
			if(MONTHS[month-1].equals(month_name.get(calendar_picker).getText())) {
				day_selector(day, calendar1);
				release = 1;
				
			}
			else if (MONTHS[month-1].equals(month_name.get(calendar_picker+1).getText())) {
				day_selector(day, calendar2);
				release = 1;
				
			}
			else next_calendars_button.click();
			
		}while(next_calendars_button.isEnabled()==true && release==0);
		
		passengers_amount_selector(passengersAmount);
		
			
	}
	
		
	public BookingSelect submitSearch() {
		getWait().until(ExpectedConditions.elementToBeClickable(searchBtn));
		searchBtn.click();
		getWait().until(ExpectedConditions.urlContains("select"));
		return new BookingSelect(getDriver());
	}


//Metodos Auxiliares

    public void passengers_amount_selector(int amount) {
	
	   getWait().until(ExpectedConditions.elementToBeClickable(passengers_selection));
	   passengers_selection.click();
	   getWait().until(ExpectedConditions.visibilityOfAllElements(number_of_passengers));
	   number_of_passengers.stream().filter(k -> Integer.parseInt(k.getText()) == amount)
	   .findFirst().get().click();
	   //forEach(k -> System.out.println(k.getText()));
	   
	
   }

   public void day_selector(String selected_day, List <WebElement> calendar) {
	  	   calendar.stream().filter(day -> day.getText().equals(selected_day)).findFirst().get().click();
   }

}

	


