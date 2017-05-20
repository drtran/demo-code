package com.bemach.aep.serenity.stepdef.serenity.page;

import java.util.List;

import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class TomcatApplicationManagerPage extends PageObject {
	@FindBy(xpath = "//td[@class='title' and contains(text(),'Applications')]/../../tr")
	private List<WebElement> applicationsListIncludingTitles;

	/**
	 * Tomcat display two title rows: Applications & Path. List of applications
	 * starts at row 3. Each application takes up 2 rows.
	 * 
	 * @return number of applications
	 */
	public Integer getNumberOfApps() {
		return (applicationsListIncludingTitles.size() - 2) / 2;
	}

}
