package com.bemach.aep.serenity.stepdef.serenity.page;

import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class TomcatExamplesPage extends PageObject {

	@FindBy(xpath = "//a[@href='servlets' and contains(text(),'Servlets examples')]")
	private WebElement servletsExamplesLink;

	public void clickOnExamples(String examplesType) {

		switch (examplesType) {
		case "Servlets examples":
			servletsExamplesLink.click();
			break;
		default:
			break;
		}
	}

}
