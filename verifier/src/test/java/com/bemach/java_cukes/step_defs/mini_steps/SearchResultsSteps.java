package com.bemach.java_cukes.step_defs.mini_steps;

import java.util.List;

import org.openqa.selenium.support.PageFactory;

import com.bemach.java_cukes.Browser;
import com.bemach.java_cukes.shared.UserProfile;
import com.bemach.java_cukes.step_defs.mini_steps.pages.SearchResultsPage;

public class SearchResultsSteps {

	private SearchResultsPage searchResultsPage;

	public SearchResultsSteps() {
		searchResultsPage = PageFactory.initElements(new Browser().getDriver(), SearchResultsPage.class);
	}
	
	public List<UserProfile> getResults() {
		return searchResultsPage.getResults();
	}
	
}
