package com.bemach.aep.selenium;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bemach.aep.selenium.pages.AdoptingPetsPage;
import com.bemach.aep.selenium.pages.Browser;
import com.bemach.aep.selenium.pages.DetailsPage;
import com.bemach.aep.selenium.pages.PaymentPage;
import com.bemach.aep.selenium.pages.PuppyMainPage;

// Scenario: Adopting one pet 
//   Given I am at Puppy Adoption Agency website “http://puppies.herokuapp.com/” 
//   When I adopt and pay for a pet 
//   And I click on ‘View Details’ for a pet name ‘Brook’ 
//   And I click on ‘Adopt Me!’ button 
//   And I click on ‘Complete the Adoption’ button 
//   And I fill out the payment detail name, address, email, & payment method 
//   And I click on ‘Place Order’ button 
//   Then I should see a message “Thank you for adopting a puppy!” 

// To run this under JUnit test, make sure to include:
// -DwebDriver=CHROME or FIREFOX
// 
// You can also run this test specifically at the command prompt as follows:
//
// mvn -Dtest=com.bemach.aep.selenium.AdoptingOnePetTest -DwebDriver=CHROME clean test
// mvn -Dtest=com.bemach.aep.selenium.AdoptingOnePetTest -DwebDriver=FIREFOX clean test

/**
 * 
 * @author ktran
 *
 */

public class AdoptingOnePetTest {

	private PuppyMainPage mainPage = new PuppyMainPage();
	private DetailsPage detailsPage = new DetailsPage();
	private AdoptingPetsPage adoptingPetsPage = new AdoptingPetsPage();
	private PaymentPage paymentPage = new PaymentPage();

	@Test
	public void adoptingOnePetTest() {
		given_I_am_at_Puppy_Adoption_Agency_website("http://puppies.herokuapp.com");
		when_I_adopt_and_pay_for_a_pet("Brook");
		then_I_should_see_a_thank_you_message("Thank you for adopting a puppy!");
	}

	private void given_I_am_at_Puppy_Adoption_Agency_website(String url) {
		mainPage.visit(url);
	}

	private void when_I_adopt_and_pay_for_a_pet(String petName) {
		I_click_on_view_details_for_a_pet(petName);
		I_click_on_adopt_me_button();
		I_click_on_complete_the_adoption_button();
		I_fill_out_the_payment_detail("John Doe", "123 Main Street, New York, NY 10001", "jdoe@mail.com", "Check");
		I_click_on_place_order_button();
	}

	private void then_I_should_see_a_thank_you_message(String expectedNotice) {
		String actualNotice = mainPage.getNotice();
		assertEquals(expectedNotice, actualNotice);
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

	@BeforeClass
	public static void setUpClass() {
	}
	
	@Before
	public void setUp() {
	}
	
	@After
	public void tearDown() {
		Browser.getDriver().close();
	}
	
	@AfterClass
	public static void tearDownClass() {
	}
}
