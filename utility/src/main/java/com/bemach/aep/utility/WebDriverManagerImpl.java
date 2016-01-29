package com.bemach.aep.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverManagerImpl implements WebDriverManager {

	private static WebDriver chromeDriver;
	private static WebDriver firefoxDriver;

	static {
		chromeDriver = new ChromeDriver();
		firefoxDriver = new FirefoxDriver();
		firefoxDriver.get("http://www.foxnews.com");
		Runtime.getRuntime().addShutdownHook(new Thread() {
		    public void run() {
		    	try {
		    		chromeDriver.quit();
		    		firefoxDriver.quit();
		    	} catch (Exception e) { 
		    		// ignore.
		    	}
		    }
		});
	}
	
	// -Dwebdriver.chrome.driver=C:\csd-work\win\bin\misc\chromedriver.exe
	public WebDriver getChromeDriver() {
		return new ChromeDriver();
	}

	public WebDriver getFirefoxDriver() {
		
		return new FirefoxDriver();
	}

	public WebDriver getSingletonChromeWebDriver() {
		return chromeDriver;
	}

	public WebDriver getSingletonFirefoxWebDriver() {
		return firefoxDriver;
	}

}
