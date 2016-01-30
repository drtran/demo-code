package com.bemach.aep.fitnesse;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import fit.ColumnFixture;

public class JtracLoginTest extends ColumnFixture {
	public String websiteUrl;
	public String userName;
	public String password;
	public String pageTitle () {
		WebDriver webDriver = new FirefoxDriver();
		webDriver.get(websiteUrl);
		String title = webDriver.getTitle();
		webDriver.close();
		return title;
	}
}
