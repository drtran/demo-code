package com.bemach.aep.cukes.stepdef;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.bemach.aep.cukes.stepdef.page.AdoptingPetsPage;
import com.bemach.aep.cukes.stepdef.page.HomePage;
import com.bemach.aep.cukes.stepdef.page.PaymentPage;
import com.bemach.aep.cukes.stepdef.page.ViewDetailsPage;
import com.bemach.aep.cukes.util.Browser;
import com.bemach.aep.cukes.util.PaymentInfo;
import com.bemach.aep.cukes.util.Browser.DRIVER_TYPE;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AdoptingOnePet {
	private static final String PUPPIES_ADOPTION_SITE = "http://puppies.herokuapp.com";

	private Browser browser = new Browser(DRIVER_TYPE.valueOf(System.getProperty("webDriver")));
	private HomePage homePage;
	private ViewDetailsPage viewDetailsPage;
	private AdoptingPetsPage adoptingPetsPage;
	private PaymentPage paymentPage;

	@Given("^I am at Puppy Adoption Agency website \"([^\"]*)\"$")
	public void i_am_at_Puppy_Adoption_Agency_website(String url) throws Throwable {
		homePage = PageFactory.initElements(Browser.getDriver(), HomePage.class);
		homePage.visit(PUPPIES_ADOPTION_SITE);
	}

	@When("^I click on View Details button for a pet name \"([^\"]*)\"$")
	public void i_click_on_View_Details_button_for_a_pet_name(String petName) throws Throwable {
		homePage.select_a_pet(petName);
		viewDetailsPage = PageFactory.initElements(Browser.getDriver(), ViewDetailsPage.class);
	}

	@When("^I click on Adopt Me! button$")
	public void i_click_on_Adopt_Me_button() throws Throwable {
		viewDetailsPage.adopt_the_pet();
		adoptingPetsPage = PageFactory.initElements(Browser.getDriver(), AdoptingPetsPage.class);
	}

	@When("^I click on Complete the Adoption button$")
	public void i_click_on_Complete_the_Adoption_button() throws Throwable {
		adoptingPetsPage.complete_the_adoption();
		paymentPage = PageFactory.initElements(Browser.getDriver(), PaymentPage.class);
	}

	@When("^I fill out the payment details \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
	public void i_fill_out_the_payment_details(String name, String address, String email, String payType)
			throws Throwable {
		PaymentInfo paymentInfo = new PaymentInfo(name, address, email, payType);
		paymentPage.fillOutPayment(paymentInfo);
	}

	@When("^I click on Place Order button$")
	public void i_click_on_Place_Order_button() throws Throwable {
		paymentPage.placeOrder();
	}

	@Then("^I should see a message \"([^\"]*)\"$")
	public void i_should_see_a_message(String expectedNotice) throws Throwable {
		assertEquals(expectedNotice, homePage.getNotice());
	}

	/** ---- Setup/Teardown **/

	@Before
	public void setUp() {
		Browser.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Browser.getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() {
		browser.close();
	}

}
