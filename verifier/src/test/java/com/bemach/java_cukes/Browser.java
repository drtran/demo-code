package com.bemach.java_cukes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {

	public static WebDriver driver = null;

	public Browser () {
		if (driver == null) {
			driver = new FirefoxDriver();
		}
	}
	
	public WebDriver getDriver() {
		return driver;
	}

	public void goTo(String websiteUrl) {
		driver.get(websiteUrl);
	}

}
