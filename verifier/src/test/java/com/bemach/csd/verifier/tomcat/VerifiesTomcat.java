package com.bemach.csd.verifier.tomcat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class VerifiesTomcat {

	private WebDriver driver;
	private String jtracUrl;
	private String tomcatUrl;
	private String jenkinsUrl;

	public VerifiesTomcat() {
		jtracUrl = System.getProperty("jtrac-url");
		tomcatUrl = System.getProperty("tomcat-url");
		jenkinsUrl = System.getProperty("jenkins-url");
		driver = new FirefoxDriver();
	}
	
	public String getPageTitle() {
		driver.get(tomcatUrl);
		String title = driver.getTitle();
		driver.close();
		return title;
	}

	public String getJenkinsPageTitle() {
		driver.get(jenkinsUrl);
		String title = driver.getTitle();
		driver.close();
		return title;
	}

	public String getJtracPageTitle() {
		driver.get(jtracUrl);
		String title = driver.getTitle();
		driver.close();
		return title;
	}

}
