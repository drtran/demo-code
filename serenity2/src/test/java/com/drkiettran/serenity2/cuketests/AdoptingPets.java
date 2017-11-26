package com.drkiettran.serenity2.cuketests;

import static org.junit.Assert.assertTrue;

import java.util.List;

import com.drkiettran.serenity2.cuketests.serenitysteps.AdopterSteps;
import com.drkiettran.serenity2.cuketests.serenitysteps.PaymentSteps;
import com.drkiettran.serenity2.vos.PaymentInfo;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class AdoptingPets {

	@Steps
	private AdopterSteps adopter;

	@Steps
	private PaymentSteps paymentSteps;

	@Given("^I am at Puppy Adoption Agency website \"([^\"]*)\"$")
	public void i_am_at_Puppy_Adoption_Agency_website(String url) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		adopter.i_open_puppies_home_page(url);
	}

	@When("^I adopt these pets:$")
	public void i_adopt_these_pets(List<String> petNames) throws Throwable {

		petNames.stream().limit(petNames.size() - 1).forEach((String petName) -> {

			i_adopt_a_pet(petName);
			adopter.i_adopt_another_pet();

		});

		i_adopt_a_pet(petNames.get(petNames.size() - 1));
		adopter.i_am_completing_the_adoption();
	}

	private void i_adopt_a_pet(String petName) {

		boolean iFound;

		for (;;) {
			iFound = adopter.i_look_for_a_pet(petName);

			if (iFound) {
				adopter.i_found_the_pet(petName);
				adopter.i_view_the_details_of_the_pet(petName);
				adopter.i_adopt_the_pet();
				break;
			}

			adopter.i_did_not_find_the_pet(petName);

			if (adopter.checkIfLastPage()) {
				adopter.i_am_on_the_last_page();
				break;
			} else
				adopter.i_am_not_on_the_last_page();

			adopter.i_go_next_page();
		}

		if (!iFound)
			adopter.i_did_not_find_the_pet(petName);

		return;
	}

	@When("^I pay for the adoption with:$")
	public void i_pay_for_the_adoption_with(List<PaymentInfo> paymentInfo) throws Throwable {
		paymentSteps.i_enter_name(paymentInfo.get(0).getFullName());
		paymentSteps.i_enter_street_address(paymentInfo.get(0).getStreetAddress());
		paymentSteps.i_enter_email_address(paymentInfo.get(0).getEmailAddress());
		paymentSteps.i_select_payment_type(paymentInfo.get(0).getPaymentType());
		paymentSteps.i_place_an_order();
	}

	@Then("^I should see a message \"([^\"]*)\"$")
	public void i_should_see_a_message(String thankYouMessage) throws Throwable {
		boolean iFound = adopter.i_look_for_a_thank_you_message(thankYouMessage);

		if (iFound)
			adopter.i_found_the_thank_you_message();

		assertTrue(iFound);
	}
}
