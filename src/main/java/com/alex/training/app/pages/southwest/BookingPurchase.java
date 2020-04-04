package com.alex.training.app.pages.southwest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.alex.training.app.pages.BasePage;

public class BookingPurchase extends BasePage {
	
	private final String PASSENGERS_SECTION = ".form > section";
	private final String PASSENGER_FIRST_NAME = "passengerFirstName-";
	private final String PASSENGER_MIDDLE_NAME = "passengerMiddleName-";
	private final String PASSENGER_LAST_NAME = "passengerLastName-";
	private final String PASSENGER_ONE_BIRTH_MONTH = "passengerDateOfBirthMonth-";
	private final String PASSENGER_ONE_LIST_OF_MONTHS = "#passengerDateOfBirthMonth-0--menu > li";
	private final String PASSENGER_ONE_BIRTH_DAY = "passengerDateOfBirthDay-";
	private final String PASSENGER_ONE_BIRTH_YEAR = "passengerDateOfBirthYear-";
	private final String PASSENGER_GENDER = "passengerGender-";
	private final String PASSENGER_GENDER_LIST = "#passengerGender-0--menu > li";
	
	@FindBy(css = PASSENGERS_SECTION )
	List <WebElement> passengers_section;
	
	protected BookingPurchase(WebDriver pDriver) {
		super(pDriver);
		
	}
	
	public void pruebando(String name1, String middlename1, String lastname1, String name2, String middlename2, String lastname2) {
		
		//int i =0;
		int y = 0;
		String passengers_info[][] = {{name1, middlename1, lastname1}, {name2, middlename2, lastname2}};
		for(int i=0; i<passengers_section.size();i ++) {
							
				getDriver().findElement(By.id(PASSENGER_FIRST_NAME.concat(Integer.toString(i)))).sendKeys(passengers_info[i][y]);
				getDriver().findElement(By.id(PASSENGER_MIDDLE_NAME.concat(Integer.toString(i)))).sendKeys(passengers_info[i][y+1]);
				getDriver().findElement(By.id(PASSENGER_LAST_NAME.concat(Integer.toString(i)))).sendKeys(passengers_info[i][y+2]);
			
		}
		/*do{	
			getDriver().findElement(By.id(PASSENGER_FIRST_NAME.concat(Integer.toString(i)))).sendKeys(passengers_info[y]);
			getDriver().findElement(By.id(PASSENGER_MIDDLE_NAME.concat(Integer.toString(i)))).sendKeys(passengers_info[y+1]);
			getDriver().findElement(By.id(PASSENGER_LAST_NAME.concat(Integer.toString(i)))).sendKeys(passengers_info[y+2]);
			i=i+1;
			y= y+3;
			
		}while (i< passengers_section.size());*/
	}

}
