package com.drkiettran.serenity2.cuketests.serenitysteps;

import com.drkiettran.serenity2.cuketests.serenitysteps.pages.AdoptionPage;
import com.drkiettran.serenity2.cuketests.serenitysteps.pages.HomePage;

import net.thucydides.core.annotations.Step;

public class AdopterSteps {

	private HomePage homePage;
	private AdoptionPage adoptionPage;

	@Step
	public void i_open_puppies_home_page(String url) {
		homePage.visitHomePage(url);
	}

	@Step
	public boolean i_look_for_a_pet(String petName) {
		return homePage.pageDisplaysThePet(petName);
	}

	@Step
	public void i_adopt_another_pet() {
		adoptionPage.adoptAnotherPuppy();
	}

	@Step
	public void i_am_completing_the_adoption() {
		adoptionPage.completeTheAdoption();
	}

	@Step
	public void i_view_the_details_of_the_pet(String petName) {
		homePage.viewDetailsOf(petName);
	}

	@Step
	public void i_adopt_the_pet() {
		adoptionPage.adoptMe();
	}

	// hidden step
	public boolean checkIfLastPage() {
		return homePage.atLastPage();
	}

	@Step
	public boolean i_look_for_a_thank_you_message(String thankYouMessage) {
		return homePage.displayThankYouMessage(thankYouMessage);
	}

	@Step
	public void i_go_next_page() {
		homePage.nextPage();
	}

	@Step
	public void i_did_not_find_the_pet(String petName) {
		// dummy step
	}

	@Step
	public void i_found_the_pet(String petName) {
		// dummy step
	}

	@Step
	public void i_found_the_thank_you_message() {
		// dummy step
	}

	@Step
	public void i_am_not_on_the_last_page() {
		// dummy step
	}

	@Step
	public void i_am_on_the_last_page() {
		// dummy step
	}
}
