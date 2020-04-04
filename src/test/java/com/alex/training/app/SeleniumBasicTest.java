package com.alex.training.app;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.*;

//import com.alex.training.app.pages.wikipedia.HomePage;
//import com.alex.training.app.pages.wikipedia.ResultPage;
import com.alex.training.app.pages.southwest.BookingIndex;
import com.alex.training.app.pages.southwest.BookingPrice;
import com.alex.training.app.pages.southwest.BookingPurchase;
import com.alex.training.app.pages.southwest.BookingSelect;

public class SeleniumBasicTest extends BaseTest {
	
	/*@Ignore
	@Test()
	public void doWikiSearch() {
		HomePage home = getHomePage();
		
		Assert.assertEquals(home.getTitle(), "Wikipedia");
		
		String itemtoSearch = "Grumpy Cat";
		
		home.setSearchTerm(itemtoSearch);
		Assert.assertEquals(home.getSearchTerm(), itemtoSearch);
		
		ResultPage result = home.submitSearch();
		Assert.assertTrue(result.getTitle().contains(itemtoSearch));
		Assert.assertEquals(result.getHeadingTitle(), itemtoSearch);
		Assert.assertTrue(result.isTocVisible());
	}*/
	
	@Test()
	public void swa() {
		
		BookingIndex index = getBookingIndex();
		//index.select_language("English");
		index.selectFlightType("One-way");
		index.select_flights("HOU", "DAL", "2/20", 2);
		
		BookingSelect select = index.submitSearch();
		//Assert.assertEquals(select.OneWay_FlightFareSelector(), "Departing flights");
		select.oneway_flight_selector("9:00 AM", "Business Select");
		
		BookingPrice price = select.submitSearchSelect();
		System.out.println(price.getTitle());
		//Assert.assertEquals(price.getTitle(), "Southwest Airlines - Select Flights");
		
		BookingPurchase purchase = price.submitSearchPrice();
		purchase.pruebando("Alex", "", "Cortes", "Paola", "", "Umbacia");
		
		
	}

}
