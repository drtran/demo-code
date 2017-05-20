package com.bemach.aep.serenity.stepdef;

import com.bemach.aep.serenity.stepdef.serenity.TomcatSteps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class TomcatExampleCode {
	@Steps
	private TomcatSteps tomcatSteps;

	@Given("^I access Manager App with user \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void i_access_Manager_App_with_user_and_password(String userId, String password) throws Throwable {
		tomcatSteps.i_click_on_ManagerApp_button(userId, password);
	}

	@When("^I search source code for \"([^\"]*)\" as a \"([^\"]*)\"$")
	public void i_search_source_code_for_as_a(String exampleName, String examplesType) throws Throwable {
		tomcatSteps.i_click_on_exmaples_link();
		tomcatSteps.i_click_on_examples_type(examplesType);
		tomcatSteps.i_click_on_the_source_link_of(exampleName);
	}

	@Then("^I should see the following line of code \"([^\"]*)\"$")
	public void i_should_see_the_following_line_of_code(String sourceCode) throws Throwable {
		tomcatSteps.i_verify_that_example_code_has_this_text(sourceCode);
	}
}
