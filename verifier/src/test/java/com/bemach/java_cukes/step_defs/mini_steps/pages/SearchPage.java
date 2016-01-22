package com.bemach.java_cukes.step_defs.mini_steps.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class SearchPage {

	@FindBy(how = How.XPATH, using = "//select[@name='searchOn']")
	private WebElement dropDown;

	@FindBy(how = How.XPATH, using = "//*[@id='searchText4']")
	private WebElement loginIDText;

	@FindBy(how = How.XPATH, using = "//*[@value='Search']")
	private WebElement searchButton;

	public SearchPage(WebDriver driver) {
	}
	
	public void chooseFilteredBy(String filteredBy) {
		Select select = new Select(dropDown);
		List<WebElement> options = select.getOptions();
		for (WebElement option: options) {
			if (option.getText().equals(filteredBy)) {
				option.click();
				break;
			}
		}
	}

	public void enterLoginID(String loginID) {
		loginIDText.sendKeys(loginID);
	}

	public void clickSearchButton() {
		searchButton.click();
	}

}
