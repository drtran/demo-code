package com.bemach.java_cukes.step_defs.mini_steps.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class OptionsPage {

	@FindBy(how = How.XPATH, using = "/html/body/table[1]/tbody/tr/td/div[2]/a")
	private WebElement manageUsersLink;

	public OptionsPage(WebDriver driver) {
	}
	
	public void selectManageUsers() {
		manageUsersLink.click();
	}

}
