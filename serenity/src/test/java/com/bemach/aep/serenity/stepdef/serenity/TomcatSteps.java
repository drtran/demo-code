package com.bemach.aep.serenity.stepdef.serenity;

import net.thucydides.core.annotations.Step;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.junit.Assert.assertThat;

import com.bemach.aep.serenity.stepdef.serenity.page.TomcatApplicationManagerPage;
import com.bemach.aep.serenity.stepdef.serenity.page.TomcatHomePage;
import com.bemach.aep.serenity.stepdef.serenity.page.TomcatServerStatusPage;

public class TomcatSteps {

	private TomcatHomePage tomcatHomePage;
	private TomcatServerStatusPage serverStatusPage;
	private TomcatApplicationManagerPage appManagerPage;

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

}
