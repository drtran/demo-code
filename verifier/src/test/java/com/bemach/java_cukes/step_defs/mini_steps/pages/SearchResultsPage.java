package com.bemach.java_cukes.step_defs.mini_steps.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.bemach.java_cukes.shared.UserProfile;


public class SearchResultsPage {
	
	@FindBy(how = How.XPATH, using = "/html/body/table[1]/tbody/tr")
	private List<WebElement> searchResultsRows;
	
	public SearchResultsPage(WebDriver driver) {

	}

	public List<UserProfile> getResults() {
		List<UserProfile> userProfiles = new ArrayList<UserProfile>();
		
		if (searchResultsRows.size() > 1) {
			
			for (int rowIndex = 1; rowIndex < searchResultsRows.size(); rowIndex++) {
				WebElement searchResultsRow = searchResultsRows.get(rowIndex);
				List<WebElement> tds = searchResultsRow.findElements(By.xpath("td"));
				userProfiles.add(new UserProfile(tds.get(0).getText(), tds.get(1).getText()));
			}
		}
		
		return userProfiles;
	}
}
