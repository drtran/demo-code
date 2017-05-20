package com.bemach.aep.serenity.stepdef.serenity;

import org.openqa.selenium.WebElement;

import com.bemach.aep.serenity.util.TestUtils;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class TomcatServletExamplesPage extends PageObject {
	@FindBy(xpath = "//td[contains(text(),'Hello World')]/../td[3]/a[2]")
	private WebElement helloExampleLink;

	@FindBy(xpath = "//body")
	private WebElement body;

	public void clickOnSourceFor(String exampleName) {
		switch (exampleName) {
		case "Hello World":
			helloExampleLink.click();
			break;
		}
	}

	public String getSourceCode(String expectedSourceCode) {
		if (body.getText().indexOf(expectedSourceCode) >= 0)
			return expectedSourceCode;
		return "*** NOT FOUND ***";
	}
}
