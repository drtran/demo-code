package com.bemach.aep.fitnesse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import fit.ColumnFixture;

public class JtracLoginPageTextTest extends ColumnFixture {
	public String websiteUrl;

	public String loginName() {
		WebDriver webDriver = new FirefoxDriver();
		webDriver.get(websiteUrl);
		WebElement loginNameLabel = webDriver.findElement(By.xpath("//*[@id='form7']/table/tbody/tr[1]/td[1]"));
		String loginName = loginNameLabel.getText();
		webDriver.close();
		return loginName;
	}

	public String pageTitle() {
		WebDriver webDriver = new FirefoxDriver();
		webDriver.get(websiteUrl);
		String title = webDriver.getTitle();
		webDriver.close();
		return title;
	}
}
