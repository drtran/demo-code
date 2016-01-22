package com.bemach.java_cukes.step_defs.mini_steps;

import org.openqa.selenium.support.PageFactory;

import com.bemach.java_cukes.Browser;
import com.bemach.java_cukes.step_defs.mini_steps.pages.OptionsPage;

public class OptionsSteps {

	private OptionsPage optionsPage;
	
	public OptionsSteps() {
		optionsPage = PageFactory.initElements(new Browser().getDriver(), OptionsPage.class);
	}
			
	public void selectManageUser() {
		optionsPage.selectManageUsers();
	}

}
