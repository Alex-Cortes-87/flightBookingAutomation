package com.alex.training.app;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.*;

import com.alex.training.app.pages.southwest.BookingConfirmation;
//import com.alex.training.app.pages.wikipedia.HomePage;
//import com.alex.training.app.pages.wikipedia.ResultPage;
import com.alex.training.app.pages.southwest.BookingIndex;
import com.alex.training.app.pages.southwest.BookingPrice;
import com.alex.training.app.pages.southwest.BookingPurchase;
import com.alex.training.app.pages.southwest.BookingSelect;
import com.alex.training.miscelaneous.Passengers;

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
		
		ArrayList<Passengers> passengers_info = new ArrayList<Passengers>();
		
		passengers_info.add(new Passengers("Alex", " ", "Cortes", "Male", "01-08-1987"));
		passengers_info.add(new Passengers("Paola", " ", "Umbacia", "Female", "11-23-1987"));
		
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
		purchase.passengersInfo(passengers_info);
		purchase.contactMethod("Email me", "alexcort@gmail.com");
		purchase.paymentMethod("Master Card", "5768904567987689", "2021-January", "000", "Alex Test");
		purchase.billingInformation("United States of America", "Fake Street 123", "", "Dallas", "Texas", "12345", "3098776655");
		purchase.receiptSendToMail("alexcort@gmail.com");
		
		BookingConfirmation confirmation = purchase.submitPurchase();
		Assert.assertNotNull(confirmation.confirmationNumber());
		
		
	}

}
