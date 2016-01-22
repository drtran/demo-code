package com.bemach.java_cukes.shared;

import org.openqa.selenium.WebElement;

public class UserProfile {
	private String loginID;
	private String fullName;
	
	public UserProfile(String loginID, String fullName) {
		this.loginID = loginID;
		this.fullName = fullName;
	}

	public String getLoginID() {
		return loginID;
	}
	
	public String getFullName() {
		return fullName;
	}
	
}
