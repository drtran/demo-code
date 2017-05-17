package com.bemach.aep.cukes.stepdef;

import org.openqa.selenium.support.PageFactory;

import com.bemach.aep.cukes.stepdef.page.AdoptingPetsPage;
import com.bemach.aep.cukes.util.Browser;

import cucumber.api.java.en.When;

public class AdoptingTwoPets {
	private AdoptingPetsPage adoptingPetsPage;

	@When("^I click on Adopt Another Puppy button$")
	public void i_click_on_Adopt_Another_Puppy_button() throws Throwable {
		adoptingPetsPage = PageFactory.initElements(Browser.getDriver(), AdoptingPetsPage.class);
		adoptingPetsPage.adoptAnotherPet();
	}
}
