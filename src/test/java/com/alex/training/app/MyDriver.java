package com.alex.training.app;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.ImeHandler;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.Logs;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class MyDriver {
	
	private WebDriver mDriver;
	
	public MyDriver (String browser) {
		
		switch(browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver","./res/chromedriver.exe");
	        ChromeOptions chromeOptions = new ChromeOptions();
	        /*options.addArguments("--headless","--ignore-certificate-errors");
	        options.setAcceptInsecureCerts(true);
	        options.setHeadless(true);*/
	        chromeOptions.setExperimentalOption("w3c", false);
	        mDriver = new ChromeDriver(chromeOptions);
	        break;
		case "firefox":
			System.setProperty("webdriver.firefox.driver","./res/geckodriver.exe");
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.setAcceptInsecureCerts(true);
	        mDriver = new FirefoxDriver(firefoxOptions);
	        break;
	    default:
	    	break;
		}
		
	}
	
	public WebDriver getDriver() {
		return this.mDriver;
	}
	
}
