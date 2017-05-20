package com.bemach.aep.serenity.stepdef.serenity;

import org.openqa.selenium.WebElement;

import com.bemach.aep.serenity.util.TestUtils;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class TomcatServletExamplesPage extends PageObject {
	private static final String HELLO_WORLD = "Hello World";
	private static final String REQUEST_INFO = "Request Info";

	@FindBy(xpath = "//td[contains(text(),'" + HELLO_WORLD + "')]/../td[3]/a[2]")
	private WebElement helloExampleLink;

	@FindBy(xpath = "//td[contains(text(),'" + REQUEST_INFO + "')]/../td[3]/a[2]")
	private WebElement requestInfoExampleLink;

	@FindBy(xpath = "//body")
	private WebElement body;

	public void clickOnSourceFor(String exampleName) {
		switch (exampleName) {
		case HELLO_WORLD:
			helloExampleLink.click();
			break;
		case REQUEST_INFO:
			requestInfoExampleLink.click();
			break;
		}
	}

	public String getSourceCode(String expectedSourceCode) {
		if (body.getText().indexOf(expectedSourceCode) >= 0)
			return expectedSourceCode;
		return "*** NOT FOUND ***";
	}
}
