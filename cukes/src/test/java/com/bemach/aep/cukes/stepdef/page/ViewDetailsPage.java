package com.bemach.aep.cukes.stepdef.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ViewDetailsPage {
	@FindBy (how = How.XPATH, using = "//*[@id='content']/div[2]/img")
	private WebElement imageElmt;
	
	@FindBy (how = How.XPATH, using = "//input[@value='Adopt Me!']")
	private WebElement adoptMeButtonElmt;
	
	public String getPetImageName() {
		return imageElmt.getAttribute("src");
	}

	public void adopt_the_pet() {
		adoptMeButtonElmt.click();
	}
	
	
}
