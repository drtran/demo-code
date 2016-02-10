package com.bemach.aep.selenium.pages;

import com.bemach.aep.selenium.pages.Browser.DRIVER_TYPE;

public class PuppyMainPage {

	private Browser browser = new Browser(DRIVER_TYPE.valueOf(System.getProperty("webDriver")));

	public void visit(String url) {
		browser.goTo(url);
	}

}
