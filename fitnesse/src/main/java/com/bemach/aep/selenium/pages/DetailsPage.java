package com.bemach.aep.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.bemach.aep.selenium.pages.Browser.DRIVER_TYPE;

public class DetailsPage {
	private Browser browser = new Browser(DRIVER_TYPE.valueOf(System.getenv("webDriver")));

	public void adoptMe() {
		WebElement adoptMe = browser.getDriver().findElement(By.xpath("//input[@value='Adopt Me!']"));
		adoptMe.click();
	}

}
