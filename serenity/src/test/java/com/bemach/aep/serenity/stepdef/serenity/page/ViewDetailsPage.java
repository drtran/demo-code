package com.bemach.aep.serenity.stepdef.serenity.page;

import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class ViewDetailsPage extends PageObject {

	@FindBy(xpath = "//input[@value='Adopt Me!']")
	WebElement adoptMe;

	public void adoptPuppy() {
		adoptMe.click();
	}

}
