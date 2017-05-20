package com.bemach.aep.serenity.stepdef;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class TomcatSystemStatus {
	@Steps
	private TomcatSteps tomcatSteps;
	
	@Given("^I am at the default tomcat website \"([^\"]*)\"$")
	public void i_am_at_the_default_tomcat_website(String url) throws Throwable {
		tomcatSteps.i_visit_Tomcat_main_page(url);
	}

	@When("^I access Server Status with user \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void i_access_Server_Status_with_user_and_password(String userId, String password) throws Throwable {
		tomcatSteps.i_click_on_Server_Status_button(userId, password);
	}

	@Then("^I should see (\\d+) or more application names displayed$")
	public void i_should_see_or_more_application_names_displayed(int numOfRows) throws Throwable {
		tomcatSteps.i_click_on_list_applications_link();
		tomcatSteps.i_verify_that_applications_table_has_at_least(numOfRows);
	}

}
