package com.bemach.aep.fitnesse;

import com.bemach.aep.selenium.pages.AdoptingPetsPage;
import com.bemach.aep.selenium.pages.Browser;
import com.bemach.aep.selenium.pages.DetailsPage;
import com.bemach.aep.selenium.pages.PaymentPage;
import com.bemach.aep.selenium.pages.PuppyMainPage;
import com.bemach.aep.selenium.pages.Browser.DRIVER_TYPE;

import fit.ColumnFixture;

public class AdoptingPets extends ColumnFixture {
	public String url;
	public String name;
	public String pet;
	public String address;
	public String email;
	public String payment;

	private PuppyMainPage mainPage = new PuppyMainPage();
	private DetailsPage detailsPage = new DetailsPage();
	private AdoptingPetsPage adoptingPetsPage = new AdoptingPetsPage();
	private PaymentPage paymentPage = new PaymentPage();
	private String notice;
	
	public String adoptOnePet() {
		Browser browser = new Browser(DRIVER_TYPE.valueOf(System.getenv("webDriver")));
		adoptingOnePetTest();
		browser.close();
		return notice;
	}

	public void adoptingOnePetTest() {
		given_I_am_at_Puppy_Adoption_Agency_website(url);
		when_I_adopt_and_pay_for_a_pet(pet);
		then_I_should_see_a_thank_you_message();
	}

	private void given_I_am_at_Puppy_Adoption_Agency_website(String url) {
		mainPage.visit(url);
	}

	private void when_I_adopt_and_pay_for_a_pet(String petName) {
		I_click_on_view_details_for_a_pet(petName);
		I_click_on_adopt_me_button();
		I_click_on_complete_the_adoption_button();
		I_fill_out_the_payment_detail(name, address, email, payment);
		I_click_on_place_order_button();
	}

	private void then_I_should_see_a_thank_you_message() {
		notice = mainPage.getNotice();
	}

	private void I_click_on_view_details_for_a_pet(String petName) {
		mainPage.viewDetails(petName);
	}

	private void I_click_on_adopt_me_button() {
		detailsPage.adoptMe();
	}

	private void I_click_on_complete_the_adoption_button() {
		adoptingPetsPage.completeAdoption();
	}

	private void I_fill_out_the_payment_detail(String name, String address, String email, String payType) {
		paymentPage.fillOutInfo(name, address, email, payType);
	}

	private void I_click_on_place_order_button() {
		paymentPage.placeOrder();
	}
}
