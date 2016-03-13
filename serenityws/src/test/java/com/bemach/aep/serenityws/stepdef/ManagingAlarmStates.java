package com.bemach.aep.serenityws.stepdef;

import static org.junit.Assert.assertTrue;

import com.bemach.aep.serenityws.stepdef.serenity.PiSentryManagerSteps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class ManagingAlarmStates {
	@Steps
	PiSentryManagerSteps mgrSteps;

	@Given("^that PI Sentry Web Services is running$")
	public void that_PI_Sentry_Web_Services_is_running() throws Throwable {
		assertTrue(mgrSteps.i_verify_PI_Sentry_is_running());
	}

	@Given("^the system is not armed$")
	public void the_system_is_not_armed() throws Throwable {
		mgrSteps.i_disarm_the_system();
	}

	@When("^I arm the system while away$")
	public void i_arm_the_system_while_away() throws Throwable {
		mgrSteps.i_arm_away_the_system();
	}

	@Then("^the system should be armed away$")
	public void the_system_should_be_armed_away() throws Throwable {
		assertTrue(mgrSteps.i_verify_PI_Sentry_is_armed_away());
	}
}
