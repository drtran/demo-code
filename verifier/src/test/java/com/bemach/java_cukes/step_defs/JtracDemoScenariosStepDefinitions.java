package com.bemach.java_cukes.step_defs;

import static org.junit.Assert.assertTrue;

import java.util.List;

import com.bemach.java_cukes.Browser;
import com.bemach.java_cukes.shared.UserProfile;
import com.bemach.java_cukes.step_defs.mini_steps.InsecureSteps;
import com.bemach.java_cukes.step_defs.mini_steps.MainSteps;
import com.bemach.java_cukes.step_defs.mini_steps.OptionsSteps;
import com.bemach.java_cukes.step_defs.mini_steps.SearchResultsSteps;
import com.bemach.java_cukes.step_defs.mini_steps.SearchSteps;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class JtracDemoScenariosStepDefinitions {
	private InsecureSteps insecureSteps = new InsecureSteps();
	private MainSteps mainSteps = new MainSteps();
	private OptionsSteps optionsSteps = new OptionsSteps();
	private SearchSteps searchSteps = new SearchSteps();
	private SearchResultsSteps searchResultsSteps = new SearchResultsSteps();

	@After
	public void tearDown() {
		new Browser().getDriver().close();
	}
	
	@Given("^I am at the website \"([^\"]*)\"$")
	public void i_am_at_the_website(String websiteUrl) throws Throwable {
		insecureSteps.visit(websiteUrl);
	}

	@When("^I enter user id \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void i_enter_user_id_and_password(String loginID, String psw) throws Throwable {
		insecureSteps.enterLoginID(loginID);
		insecureSteps.enterPsw(psw);
	}

	@When("^I click on the Submit button$")
	public void i_click_on_the_Submit_button() throws Throwable {
		insecureSteps.submit();
	}

	@Then("^I should see a main page display \"([^\"]*)\" as a part of the menu\\.$")
	public void i_should_see_a_main_page_display_as_a_part_of_the_menu(String arg1) throws Throwable {
		mainSteps.verifyDashboard();
	}

	@Given("^I verify user \"([^\"]*)\" does not exist$")
	public void i_verify_user_does_not_exist(String arg1) throws Throwable {
	    // In reality, I would go and remove the entry using local call or database directly
	}

	@When("^I select Options$")
	public void i_select_Options() throws Throwable {
		mainSteps.selectOptions();
	}

	@When("^I select Manage Users$")
	public void i_select_Manage_Users() throws Throwable {
		optionsSteps.selectManageUser();
	}

	@When("^I select Login Name from the dropdown box$")
	public void i_select_Login_Name_from_the_dropdown_box() throws Throwable {
		searchSteps.chooseFilteredBy("Login Name");
	}

	@When("^I enter user \"([^\"]*)\"$")
	public void i_enter_user(String loginID) throws Throwable {
		searchSteps.enterLoginID(loginID);
	}

	@When("^I click the Search button$")
	public void i_click_the_Search_button() throws Throwable {
		searchSteps.clickSearchButton();
	}

	@Then("^I should not see any entry in the search result table\\.$")
	public void i_should_not_see_any_entry_in_the_search_result_table() throws Throwable {
		List<UserProfile> userProfiles = searchResultsSteps.getResults();
		assertTrue("I saw at least one entry!", userProfiles.size() == 0);
	}



}
