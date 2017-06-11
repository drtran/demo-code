package com.bemach.aep.fitnesse;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import fit.ColumnFixture;

/**
 * -Dwebdriver.driver=chrome -Dwebdriver.chrome.driver=C:\dev\bin\misc\chromedriver.exe
 * 
 * - Make sure JTRAC runs on port 8080. 
 * - I set up for Tomcat 8.5.15
 *  
 * @author ktran
 *
 */
public class JtracLoginTest extends ColumnFixture {
	public String websiteUrl;
	public String userName;
	public String password;

	public String pageTitle() {
		WebDriver webDriver = new ChromeDriver();
		webDriver.get(websiteUrl);
		String title = webDriver.getTitle();
		webDriver.close();
		return title;
	}
}
