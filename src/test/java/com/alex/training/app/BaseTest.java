package com.alex.training.app;

import org.testng.annotations.*;
import com.alex.training.app.pages.wikipedia.HomePage;
import com.alex.training.app.pages.southwest.BookingIndex;
import com.alex.training.app.pages.southwest.BookingSelect;

public class BaseTest {

	private MyDriver myDriver;
	private HomePage homePage;
	private BookingIndex bookingIndex;
	
	
	
	@BeforeSuite(alwaysRun = true)
	@Parameters({"browser"})
	public void beforeSuite(String browser){
        myDriver = new MyDriver(browser);
        //homePage = new HomePage(myDriver.getDriver());
        bookingIndex = new BookingIndex(myDriver.getDriver());
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite(){
        myDriver.getDriver().quit();
    }
    
    public HomePage getHomePage() {
    	return this.homePage;
    }
    
    public BookingIndex getBookingIndex() {
    	return this.bookingIndex;
    }
    
}
