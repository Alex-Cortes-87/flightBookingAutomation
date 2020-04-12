package com.alex.training.app.pages.southwest;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.alex.training.app.pages.BasePage;
import com.alex.training.miscelaneous.Passengers;

public class BookingPurchase extends BasePage {
	
	private final String PASSENGERS_SECTION = ".form > section";
	private final String PASSENGER_FIRST_NAME = "passengerFirstName-";
	private final String PASSENGER_MIDDLE_NAME = "passengerMiddleName-";
	private final String PASSENGER_LAST_NAME = "passengerLastName-";
	private final String PASSENGER_ONE_BIRTH_MONTH = "passengerDateOfBirthMonth-";
	private final String PASSENGER_ONE_LIST_OF_MONTHS = "#passengerDateOfBirthMonth-";
	private final String PASSENGER_ONE_BIRTH_DAY = "passengerDateOfBirthDay-";
	private final String PASSENGER_ONE_BIRTH_YEAR = "passengerDateOfBirthYear-";
	private final String PASSENGER_GENDER = "passengerGender-";
	private final String PASSENGER_GENDER_LIST = "#passengerGender-";
	private final String GENERIC_MENU = "--menu > li";
	private final String CONTACT_METHOD_BUTTON = "contactMethod";
	private final String CONTACT_METHOD_MENU = "#contactMethod--menu >li";
	private final String CONTACT_PHONE_NUMBER = "contactPhoneNumber";
	private final String CONTACT_EMAIL_ADDRESS = "contactEmailAddress";
	private final String CREDIT_CARD_TYPE = "creditCardType";
	private final String CREDIT_CARD_TYPE_MENU = "#creditCardType--menu > li";
	private final String CREDIT_CARD_NUMBER = "creditCardNumber";
	private final String CREDIT_CARD_EXPIRATION_MONTH = "creditCardExpirationDateMonth";
	private final String CREDIT_CARD_EXPIRATION_MONTH_LIST = "#creditCardExpirationDateMonth--menu > li";
	private final String CREDIT_CARD_EXPIRATION_YEAR = "creditCardExpirationDateYear";
	private final String CREDIT_CARD_CVV = "creditCardNewVerificationValue";
	private final String FIRST_NAME_ON_CARD = "creditCardFirstNameOnCard";
	private final String LAST_NAME_ON_CARD = "creditCardLastNameOnCard";
	private final String CREDIT_CARD_COUNTRY = "creditCardCountry";
	private final String CREDIT_CARD_COUNTRY_MENU = "#creditCardCountry--menu > li";
	private final String CREDIT_CARD_ADDRESS = "creditCardStreetAddress";
	private final String CREDIT_CARD_SECOND_ADDRESS = "creditCardStreetAddressSecond";
	private final String CREDIT_CARD_CITY = "creditCardCityTown";
	private final String CREDIT_CARD_STATE = "creditCardState";
	private final String CREDIT_CARD_STATE_MENU = "#creditCardState--menu > li";
	private final String STATE_MOVE_DOWN_BUTTON = "//*[@id=\"creditCardState--menu\"]/parent::node()//button[@aria-label=\"Move down\"]";
	private final String CREDIT_CARD_ZIP_CODE = "creditCardZipCode";
	private final String CREDIT_CARD_PHONE_NUMBER = "creditCardPhoneNumber";
	private final String SEND_YOUR_RECEIPT = "sendYourReceiptEmail";
	private final String PURCHASE_BUTTON = ".multi-form--submit-block > button";
	private String name;
	private String middleName;
	private String lastName;
	
	
	@FindBy(css = PASSENGERS_SECTION )
	List <WebElement> passengers_section;
	
	@FindBy(id = CONTACT_METHOD_BUTTON)
	WebElement contact_method_button;
	
	@FindBy(css = CONTACT_METHOD_MENU)
	List <WebElement> contact_method_menu;
	
	@FindBy(id = CONTACT_PHONE_NUMBER)
	WebElement contact_phone_number;
	
	@FindBy(id = CONTACT_EMAIL_ADDRESS)
	WebElement contact_email_address;
	
	@FindBy(id = CREDIT_CARD_TYPE)
	WebElement credit_card_type;
	
	@FindBy(css = CREDIT_CARD_TYPE_MENU)
	List <WebElement> credit_card_type_menu;
	
	@FindBy(id = CREDIT_CARD_NUMBER)
	WebElement credit_card_number;
	
	@FindBy(id = CREDIT_CARD_EXPIRATION_MONTH)
	WebElement credit_card_expiration_month;
	
	@FindBy(css = CREDIT_CARD_EXPIRATION_MONTH_LIST)
	List <WebElement> credit_card_expiration_month_list;
	
	@FindBy(id = CREDIT_CARD_EXPIRATION_YEAR)
	WebElement credit_card_expiration_year;
	
	@FindBy(id = CREDIT_CARD_CVV)
	WebElement credit_card_cvv;
	
	@FindBy(id = FIRST_NAME_ON_CARD)
	WebElement first_name_on_card;
	
	@FindBy(id = LAST_NAME_ON_CARD)
	WebElement last_name_on_card;
	
	@FindBy(id = CREDIT_CARD_COUNTRY)
	WebElement credit_card_country;
	
	@FindBy(css = CREDIT_CARD_COUNTRY_MENU)
	List <WebElement> credit_card_country_menu;
	
	@FindBy(id = CREDIT_CARD_ADDRESS)
	WebElement credit_card_address;
	
	@FindBy(id = CREDIT_CARD_SECOND_ADDRESS)
	WebElement credit_card_second_address;
	
	@FindBy(id = CREDIT_CARD_CITY)
	WebElement credit_card_city;
	
	@FindBy(id = CREDIT_CARD_STATE)
	WebElement credit_card_state;
	
	@FindBy(css = CREDIT_CARD_STATE_MENU)
	List <WebElement> credit_card_state_menu;
	
	@FindBy(xpath = STATE_MOVE_DOWN_BUTTON)
	WebElement state_move_down_button;
	
	@FindBy(id = CREDIT_CARD_ZIP_CODE)
	WebElement credit_card_zip_code;
	
	@FindBy(id = CREDIT_CARD_PHONE_NUMBER)
	WebElement credit_card_phone_number;
	
	@FindBy(id = SEND_YOUR_RECEIPT)
	WebElement send_your_receipt;
	
	@FindBy(css = PURCHASE_BUTTON)
	WebElement purchase_button;
	
	
	protected BookingPurchase(WebDriver pDriver) {
		super(pDriver);
		
	}
	
public void passengersInfo(ArrayList <Passengers> passengerAmount) {
		
		for(int i=0; i<passengers_section.size();i ++) {
			
			String sexo = passengerAmount.get(i).passengerGender();
			getDriver().findElement(By.id(PASSENGER_FIRST_NAME.concat(Integer.toString(i)))).sendKeys(passengerAmount.get(i).firstName());
			getDriver().findElement(By.id(PASSENGER_MIDDLE_NAME.concat(Integer.toString(i)))).sendKeys(passengerAmount.get(i).middleName());
			getDriver().findElement(By.id(PASSENGER_LAST_NAME.concat(Integer.toString(i)))).sendKeys(passengerAmount.get(i).lastName());
			getDriver().findElement(By.id(PASSENGER_ONE_BIRTH_MONTH.concat(Integer.toString(i)))).click();
			List <WebElement> monthlister = getDriver().findElements(By.cssSelector(PASSENGER_ONE_LIST_OF_MONTHS.concat(Integer.toString(i).concat(GENERIC_MENU))));
			getWait().until(ExpectedConditions.visibilityOfAllElements(monthlister));
			monthlister.get(Integer.parseInt(passengerAmount.get(i).birthMonth())).click();
			getDriver().findElement(By.id(PASSENGER_ONE_BIRTH_DAY.concat(Integer.toString(i)))).sendKeys(passengerAmount.get(i).birthDay());
			getDriver().findElement(By.id(PASSENGER_ONE_BIRTH_YEAR.concat(Integer.toString(i)))).sendKeys(passengerAmount.get(i).birthYear());
			getDriver().findElement(By.id(PASSENGER_GENDER.concat(Integer.toString(i)))).click();
			List <WebElement> genderlister = getDriver().findElements(By.cssSelector(PASSENGER_GENDER_LIST.concat(Integer.toString(i).concat(GENERIC_MENU))));
			getWait().until(ExpectedConditions.visibilityOfAllElements(genderlister));
			genderlister.stream().filter(g -> g.getText().equals(sexo)).findFirst().get().click();
			
	}
		
	}
	
	public void contactMethod(String contactSelection, String selectionDescription) {
		
		contact_method_button.click();
		getWait().until(ExpectedConditions.visibilityOfAllElements(contact_method_menu));
		contact_method_menu.stream().filter(con ->con.getText().equals(contactSelection)).findFirst().get().click();
		if(contactSelection.equals("Email me")) {
			contact_email_address.sendKeys(selectionDescription);
		}
		
		else
		contact_phone_number.sendKeys(selectionDescription);
	}
	
	public void paymentMethod(String card, String cardNumber, String expirationDate, String cvv_value, String holder_name) {
		String[] expireDate = expirationDate.split("-");
		String[] name = holder_name.split(" ");
		credit_card_type.click();
		getWait().until(ExpectedConditions.visibilityOfAllElements(credit_card_type_menu));
		credit_card_type_menu.stream().filter(cred -> cred.getText().equals(card)).findFirst().get().click();
		credit_card_number.sendKeys(cardNumber);
		credit_card_expiration_month.click();
		getWait().until(ExpectedConditions.visibilityOfAllElements(credit_card_expiration_month_list));
		credit_card_expiration_month_list.get(Integer.parseInt(expireDate[1])).click();
		credit_card_expiration_year.sendKeys(expireDate[0]);
		credit_card_cvv.sendKeys(cvv_value);
		first_name_on_card.sendKeys(name[0]);
		last_name_on_card.sendKeys(name[1]);
		}
	
	public void billingInformation(String country, String address1, String address2, String city, String state, String zip_code, String phone_number) {
		int release1=0;
		int counter = 0;
		credit_card_country.click();
		getWait().until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(CREDIT_CARD_COUNTRY_MENU)));
		credit_card_country_menu.stream().filter(cc_country -> cc_country.getText().equals(country)).findFirst().get().click();
		credit_card_address.sendKeys(address1);
		credit_card_second_address.sendKeys(address2);
		credit_card_city.sendKeys(city);
		credit_card_state.click();
		getWait().until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(CREDIT_CARD_STATE_MENU)));
				
		do {
		 if(credit_card_state_menu.get(counter).isDisplayed()) {
			 if(credit_card_state_menu.get(counter).getText().equals(state)) {
				credit_card_state_menu.get(counter).click();
				release1=1;
			 }
			 
			 else counter = counter +1;
		 }
		 
		 else state_move_down_button.click();
			
		}while (release1==0 && state_move_down_button.isEnabled());
				
		credit_card_zip_code.sendKeys(zip_code);
		credit_card_phone_number.sendKeys(phone_number);
	}
	
	public void receiptSendToMail(String email) {
		
		send_your_receipt.sendKeys(email);
	}
	
	public BookingConfirmation submitPurchase() {
		
		getWait().until(ExpectedConditions.visibilityOf(purchase_button));
		purchase_button.click();
		getWait().until(ExpectedConditions.urlContains("confirmation"));
		return new BookingConfirmation(getDriver());
	}

}
