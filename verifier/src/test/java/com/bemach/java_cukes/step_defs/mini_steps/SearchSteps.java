package com.bemach.java_cukes.step_defs.mini_steps;

import org.openqa.selenium.support.PageFactory;

import com.bemach.java_cukes.Browser;
import com.bemach.java_cukes.step_defs.mini_steps.pages.SearchPage;

public class SearchSteps {
	private SearchPage searchPage;

	public SearchSteps() {
		searchPage = PageFactory.initElements(new Browser().getDriver(), SearchPage.class);
	}

	public void chooseFilteredBy(String filteredBy) {
		searchPage.chooseFilteredBy(filteredBy);
	}

	public void enterLoginID(String loginID) {
		searchPage.enterLoginID(loginID);
	}

	public void clickSearchButton() {
		searchPage.clickSearchButton();
	}
}
