package com.bemach.aep.selenium.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.bemach.aep.selenium.pages.Browser.DRIVER_TYPE;

public class PuppyMainPage {

	private Browser browser = new Browser(DRIVER_TYPE.valueOf(System.getProperty("webDriver")));

	public void visit(String url) {
		browser.goTo(url);
	}

	public void viewDetails(String petName) {
		List<WebElement> names = Browser.getDriver().findElements(By.xpath("//div[@class='name']"));
		List<WebElement> values = Browser.getDriver().findElements(By.xpath("//input[@value='View Details']"));

		int index = 0;
		for (WebElement name : names) {
			if (name.getText().equals("Brook")) {
				values.get(index).click();
				break;
			}
			index++;
		}
	}

	public String getNotice() {
		WebElement notice = browser.getDriver().findElement(By.id("notice"));
		return notice.getText();
	}

}
