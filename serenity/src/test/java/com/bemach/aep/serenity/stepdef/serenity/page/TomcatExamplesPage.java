package com.bemach.aep.serenity.stepdef.serenity.page;

import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;

public class TomcatExamplesPage extends PageObject {

	private static final String EXAMPLES_TYPE_XPATH = "//a[@href='servlets' and contains(text(),'%s')]";

	public void clickOnExamples(String examplesType) {
		String examplesTypeLinkString = String.format(EXAMPLES_TYPE_XPATH, examplesType);
		WebElement examplesTypeLink = getDriver().findElement(By.xpath(examplesTypeLinkString));
		examplesTypeLink.click();
	}

}
