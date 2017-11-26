package com.drkiettran.serenity2.cuketests.serenitysteps.pages;

import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;

/**
 * You must extend PageObject in order to reap many benefits
 */
public class AdoptionPage extends PageObject {

	@FindBy(xpath = "//input[@value='Adopt Another Puppy']")
	private WebElement adoptAnotherPuppyButton;

	@FindBy(xpath = "//input[@value='Complete the Adoption']")
	private WebElement completeTheAdoptionButton;

	@FindBy(xpath = "//input[@value='Adopt Me!']")
	private WebElement adoptMeButton;

	public void adoptAnotherPuppy() {
		adoptAnotherPuppyButton.click();
	}

	public void completeTheAdoption() {
		completeTheAdoptionButton.click();
	}

	public void adoptMe() {
		adoptMeButton.click();
	}
}
