package com.bemach.aep.serenity.stepdef;

import net.thucydides.core.annotations.Step;

public class TomcatSteps {

	private TomcatHomePage tomcatHomePage;

	@Step
	public void i_visit_Tomcat_main_page(String url) {
		tomcatHomePage.openAt(url);
	}

	public void i_click_on_Server_Status_button(String userId, String password) {
		tomcatHomePage.i_select_server_status(userId, password);
	}

}
