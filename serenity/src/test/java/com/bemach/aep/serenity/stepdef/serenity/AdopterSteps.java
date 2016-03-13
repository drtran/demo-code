package com.bemach.aep.serenity.stepdef.serenity;

import com.bemach.aep.serenity.stepdef.serenity.page.AdoptionPage;
import com.bemach.aep.serenity.stepdef.serenity.page.HomePage;
import com.bemach.aep.serenity.util.PaymentInfo;

import net.thucydides.core.annotations.Step;

public class AdopterSteps {

	private HomePage homePage;
	private AdoptionPage adoptionPage;

	@Step
	public void i_open_puppies_home_page(String url) {
		homePage.openAt(url);
	}
 
	@Step
	public void i_adopt_the_puppy(String puppyName) {
		String websiteUrl = homePage.getWebsiteUrl();
		adoptionPage.openAt(websiteUrl);
		adoptionPage.adoptThePuppy(puppyName);
	}

	@Step
	public void i_complete_the_adoption() {
		adoptionPage.completeTheAdoption();
	}

	@Step
	public void i_adopt_another_pet() {
		adoptionPage.adoptAnotherPuppy();
	}

	@Step
	public void i_pay_for_the_adoption(PaymentInfo paymentInfo) {
		adoptionPage.payForAdoption(paymentInfo);
	}

	@Step
	public String i_get_a_notice() {
		return homePage.getNotice();
	}
}
