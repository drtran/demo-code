package com.bemach.aep.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.bemach.aep.selenium.pages.Browser;
import com.bemach.aep.selenium.pages.Browser.DRIVER_TYPE;

public class AdoptingPetsPage {
	private Browser browser = new Browser(DRIVER_TYPE.valueOf(System.getProperty("webDriver")));

	public void completeAdoption() {
		WebElement completeTheAdoption = browser.getDriver()
				.findElement(By.xpath("//input[@value='Complete the Adoption']"));
		completeTheAdoption.click();
	}

}
