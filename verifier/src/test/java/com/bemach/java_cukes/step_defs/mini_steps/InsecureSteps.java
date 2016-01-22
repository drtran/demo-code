package com.bemach.java_cukes.step_defs.mini_steps;

import org.openqa.selenium.support.PageFactory;

import com.bemach.java_cukes.Browser;
import com.bemach.java_cukes.step_defs.mini_steps.pages.InsecurePage;

public class InsecureSteps {

	private InsecurePage insecurePage;
	
	public InsecureSteps() {
		insecurePage = PageFactory.initElements(new Browser().getDriver(), InsecurePage.class);
	}
	
	public void visit(String websiteUrl) {
		insecurePage.at(websiteUrl);
	}

	public void enterLoginID(String loginID) {
		insecurePage.enterLoginID(loginID);
	}

	public void enterPsw(String psw) {
		insecurePage.enterPsw(psw);
	}

	public void submit() {
		insecurePage.submit();
	}

}
