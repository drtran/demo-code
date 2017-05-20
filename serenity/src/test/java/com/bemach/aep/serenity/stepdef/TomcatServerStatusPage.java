package com.bemach.aep.serenity.stepdef;

import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class TomcatServerStatusPage extends PageObject {
	@FindBy(xpath = "//a[@href='/manager/html/list']")
	private WebElement listApplicationsLink;

	public void clickOnApplicationsLink() {
		listApplicationsLink.click();
	}

}
