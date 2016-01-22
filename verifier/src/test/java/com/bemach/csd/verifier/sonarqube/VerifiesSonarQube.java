package com.bemach.csd.verifier.sonarqube;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class VerifiesSonarQube {
	private WebDriver driver;
	private String sonarQubeUrl;

	public VerifiesSonarQube() {
		sonarQubeUrl = System.getProperty("sonarqube-url");
		driver = new FirefoxDriver();
	}

	public String getPageTitle() {
		driver.get(sonarQubeUrl);
		String title = driver.getTitle();
		driver.close();
		return title;
	}
}
