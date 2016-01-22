package com.bemach.java_cukes.step_defs.mini_steps.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.bemach.java_cukes.Browser;

public class InsecurePage {
	@FindBy(how = How.ID, using = "loginName3")
	private WebElement loginNameText;

	@FindBy(how = How.ID, using = "password12")
	private WebElement pswText;

	@FindBy(how = How.XPATH, using = "//*[@value='Submit']")
	private WebElement submitButton;

	private WebDriver driver;
	private Browser browser;
	
	
	public InsecurePage(WebDriver driver) {
		this.driver = driver;
		this.browser = new Browser();
	}
	public void at(String websiteUrl) {
		browser.goTo(websiteUrl);
	}
	public void enterPsw(String psw) {
		pswText.sendKeys(psw);
	}
	
	public void enterLoginID(String loginID) {
		loginNameText.sendKeys(loginID);
	}
	public void submit() {
		submitButton.click();
	}
	
}
