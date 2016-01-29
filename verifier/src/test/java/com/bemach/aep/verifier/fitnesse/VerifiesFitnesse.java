package com.bemach.aep.verifier.fitnesse;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class VerifiesFitnesse {

	private WebDriver driver;
	private String fitnesseUrl;

	public VerifiesFitnesse() {
		fitnesseUrl = System.getProperty("fitnesse-url");
		driver = new FirefoxDriver();
	}
	
	public String getPageTitle() {
		driver.get(fitnesseUrl);
		String title = driver.getTitle();
		driver.close();
		return title;
	}

}
