package com.bemach.aep.serenity.stepdef.serenity;

import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class TomcatServletExamplesPage extends PageObject {
	public static final String EXAMPLES_XPATH = "//td[contains(text(),'%s')]/../td[3]/a[2]";

	@FindBy(xpath = "//body")
	private WebElement body;

	public void clickOnSourceFor(String exampleName) {
		String exampleLinkString = String.format(EXAMPLES_XPATH, exampleName);
		WebElement exampleLink = getDriver().findElement(By.xpath(exampleLinkString));
		exampleLink.click();
	}

	public String getSourceCode(String expectedSourceCode) {
		if (body.getText().indexOf(expectedSourceCode) >= 0)
			return expectedSourceCode;
		return "*** NOT FOUND ***";
	}
}
