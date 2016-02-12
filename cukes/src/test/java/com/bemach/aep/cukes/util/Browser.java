package com.bemach.aep.cukes.util;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * We want a 'single' driver at any giving time for testing.
 * 
 * @author ktran
 *
 */
public class Browser {
	public enum DRIVER_TYPE {
		CHROME, FIREFOX
	};

	private static WebDriver driver = null;
	private static DRIVER_TYPE driverType;

	public Browser() {
		if (driver == null) {
			driver = new FirefoxDriver();
			driverType = DRIVER_TYPE.FIREFOX;
		}
	}

	public Browser(DRIVER_TYPE driverType) {
		if (driver == null) {
			if (driverType == DRIVER_TYPE.FIREFOX) {
				driver = new FirefoxDriver();
			} else if (driverType == DRIVER_TYPE.CHROME) {
				driver = new ChromeDriver();
			}
			this.driverType = driverType;
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		}
	}

	public void close() {
		if (driver != null) {
			driver.close();
			driver.quit();
			driver = null;
		}
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public void goTo(String url) {
		driver.get(url);
	}

	public WebElement input(String attr, String using) {
		wait_for_ajax();
		return find("input", attr.toLowerCase(), using);
	}

	private void wait_for_ajax() {
	}

	public WebElement button(String attr, String using) {
		wait_for_ajax();
		return find("button", attr.toLowerCase(), using);
	}

	private WebElement find(String tagName, String attribute, String using) {
		List<WebElement> weList = driver.findElements(By.tagName(tagName));
		for (WebElement we : weList) {
			if (we.getAttribute(attribute).equals(using))
				return we;
		}
		return null;
	}

	public WebElement span(String attr, String using) {
		wait_for_ajax();
		return find("span", attr.toString().toLowerCase(), using);
	}
}
