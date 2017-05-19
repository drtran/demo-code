package com.bemach.aep.serenity.stepdef;

import org.openqa.selenium.WebElement;

import com.bemach.aep.serenity.util.TestUtils;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class TomcatHomePage extends PageObject {

	@FindBy(xpath = "//a[@href='/manager/status']")
	private WebElement serverStatusButton;

	public void i_select_server_status(String userId, String password) {
		TestUtils testUtils = new TestUtils();
		testUtils.popup_authentication_thread(userId, password);
		serverStatusButton.click();
		testUtils.wait_for_popup_login_to_complete();
	}

}
