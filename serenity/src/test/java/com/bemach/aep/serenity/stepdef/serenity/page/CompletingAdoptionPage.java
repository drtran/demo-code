package com.bemach.aep.serenity.stepdef.serenity.page;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;

import org.openqa.selenium.WebElement;

public class CompletingAdoptionPage extends PageObject {
	@FindBy(xpath = "//input[@value='Complete the Adoption']")
	WebElement completeTheAdoptionButton;

	@FindBy(xpath = "//input[@value='Adopt Another Puppy']")
	WebElement adoptAnotherPuppyButton;

	@FindBy(xpath = "//input[@value='Change your mind']")
	WebElement changeYourMindButton;

	public void adoptAnotherPuppy() {
		adoptAnotherPuppyButton.click();
	}

	public void completeTheAdoption() {
		completeTheAdoptionButton.click();
	}

}
