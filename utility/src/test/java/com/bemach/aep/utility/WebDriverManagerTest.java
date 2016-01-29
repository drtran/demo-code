package com.bemach.aep.utility;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.openqa.selenium.WebDriver;

public class WebDriverManagerTest {

	@InjectMocks
	private WebDriverManager target = new WebDriverManagerImpl();

	private WebDriver webDriver;

	private WebDriver singletonWebDriver;

	@Test
	public void shouldGetChromeWebDriver() {
		webDriver = target.getChromeDriver();
		assertNotNull(webDriver);
	}

	@Test
	public void shouldGetFirefoxWebDriver() {
		webDriver = target.getFirefoxDriver();
		assertNotNull(webDriver);
	}

	@Test 
	public void shouldGetSingletonChromeWebDriver() {
		singletonWebDriver = target.getSingletonChromeWebDriver();
		assertNotNull(singletonWebDriver);
	}

	@Test 
	public void shouldGetSingletonFirefoxWebDriver() {
		singletonWebDriver = target.getSingletonFirefoxWebDriver();
		assertNotNull(singletonWebDriver);
	}

	@After
	public void tearDown() {
		if (webDriver != null) {
			webDriver.quit();
			webDriver = null;
		}
	}
}
