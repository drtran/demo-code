package com.bemach.aep.serenity.stepdef;

import static org.junit.Assert.assertEquals;

import java.util.List;

import com.bemach.aep.serenity.stepdef.serenity.AdopterSteps;
import com.bemach.aep.serenity.util.PaymentInfo;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class AdoptingPets {
	@Steps
	private AdopterSteps adopter;

	@Given("^I am at Puppy Adoption Agency website \"([^\"]*)\"$")
	public void i_am_at_Puppy_Adoption_Agency_website(String url) throws Throwable {
		adopter.i_open_puppies_home_page(url);
	}

	@When("^I adopt these pets:$")
	public void i_adopt_these_pets(List<String> petNames) throws Throwable {
		for (int idx = 0; idx < petNames.size(); idx++) {
			adopter.i_adopt_the_puppy(petNames.get(idx));
			if (idx + 1 == petNames.size()) {
				adopter.i_complete_the_adoption();
			} else {
				adopter.i_adopt_another_pet();
			}
		}
	}

	@When("^I pay for the adoption with:$")
	public void i_pay_for_the_adoption_with(List<PaymentInfo> payments) throws Throwable {
		adopter.i_pay_for_the_adoption(payments.get(0));
	}

	@Then("^I should see a message \"([^\"]*)\"$")
	public void i_should_see_a_message(String expectedNotice) throws Throwable {
		assertEquals(expectedNotice, adopter.i_get_a_notice());
	}

	@Then("^I should see an error message \"([^\"]*)\" on the payment page$")
	public void i_should_see_an_error_message_on_the_payment_page(String expectedErrorMsg) throws Throwable {
		assertEquals(expectedErrorMsg, adopter.i_get_error_message());
	}
}
