package com.bemach.java_cukes.step_defs.mini_steps.pages;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.bemach.java_cukes.Browser;

public class MainPage {

	@FindBy(how = How.XPATH, using = "/html/body/div[1]/table[1]/tbody/tr/td[1]/a")
	private WebElement dashboardLabel;

	@FindBy(how = How.XPATH, using = "/html/body/div[1]/table[2]/tbody/tr/td[1]/a")
	private WebElement optionsLink;

	public MainPage(WebDriver driver) {

	}

	public void verifyDashboard() {
		assertEquals("DASHBOARD", dashboardLabel.getText());
	}

	public void selectOptions() {
		optionsLink.click();
	}
}
