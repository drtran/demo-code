package com.bemach.java_cukes.step_defs.mini_steps;

import org.openqa.selenium.support.PageFactory;

import com.bemach.java_cukes.Browser;
import com.bemach.java_cukes.step_defs.mini_steps.pages.MainPage;

public class MainSteps {

	private MainPage mainPage;
	
	public MainSteps() {
		mainPage = PageFactory.initElements(new Browser().getDriver(), MainPage.class);
	}
	
	public void verifyDashboard() {
		mainPage.verifyDashboard();
	}

	public void selectOptions() {
		mainPage.selectOptions();
	}

}
