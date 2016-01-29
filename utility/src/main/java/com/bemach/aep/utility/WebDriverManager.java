package com.bemach.aep.utility;

import org.openqa.selenium.WebDriver;

public interface WebDriverManager {

	WebDriver getChromeDriver();

	WebDriver getFirefoxDriver();

	WebDriver getSingletonChromeWebDriver();

	WebDriver getSingletonFirefoxWebDriver();

}
