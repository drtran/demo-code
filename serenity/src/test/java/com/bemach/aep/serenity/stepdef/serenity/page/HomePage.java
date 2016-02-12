package com.bemach.aep.serenity.stepdef.serenity.page;

import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://puppies.herokuapp.com")
public class HomePage extends PageObject {
	@FindBy(id = "notice")
	WebElement notice;

	public String getWebsiteUrl() {
		return this.getDriver().getCurrentUrl();
	}

	public String getNotice() {
		return notice.getText();
	}
}
