package com.bemach.aep.serenity.stepdef.serenity;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.junit.Assert.assertThat;

import com.bemach.aep.serenity.stepdef.serenity.page.TomcatApplicationManagerPage;
import com.bemach.aep.serenity.stepdef.serenity.page.TomcatExamplesPage;
import com.bemach.aep.serenity.stepdef.serenity.page.TomcatHomePage;
import com.bemach.aep.serenity.stepdef.serenity.page.TomcatServerStatusPage;

import net.thucydides.core.annotations.Step;

public class TomcatSteps {

	private TomcatHomePage tomcatHomePage;
	private TomcatServerStatusPage serverStatusPage;
	private TomcatApplicationManagerPage appManagerPage;
	private TomcatExamplesPage examplesPage;
	private TomcatServletExamplesPage servletExamplesPage;

	@Step
	public void i_visit_Tomcat_main_page(String url) {
		tomcatHomePage.openAt(url);
	}

	public void i_click_on_Server_Status_button(String userId, String password) {
		tomcatHomePage.clickOnServerStatusButton(userId, password);
	}

	public void i_click_on_list_applications_link() {
		serverStatusPage.clickOnApplicationsLink();
	}

	public void i_verify_that_applications_table_has_at_least(Integer expectedNumberOfApps) {
		assertThat("Number of application is less than expected!", expectedNumberOfApps,
				lessThanOrEqualTo(appManagerPage.getNumberOfApps()));
	}

	public void i_click_on_ManagerApp_button(String userId, String password) {
		tomcatHomePage.clickOnManagerAppButton(userId, password);
	}

	public void i_click_on_exmaples_link() {
		appManagerPage.clickOnExamplesLink();
	}

	public void i_click_on_examples_type(String examplesType) {
		examplesPage.clickOnExamples(examplesType);
	}

	public void i_click_on_the_source_link_of(String exampleName) {
		servletExamplesPage.clickOnSourceFor(exampleName);
	}

	public void i_verify_that_example_code_has_this_text(String expectedSourceCode) {
		assertThat("Incorrect example source code", servletExamplesPage.getSourceCode(expectedSourceCode),
				equalTo(expectedSourceCode));
	}

}
