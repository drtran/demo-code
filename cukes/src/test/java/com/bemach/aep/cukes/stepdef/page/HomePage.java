package com.bemach.aep.cukes.stepdef.page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {

	private WebDriver driver;

	@FindBy (how = How.XPATH, using = "//div[@class='name']")
	private List<WebElement> petNameElmts;
	
	@FindBy (how = How.XPATH, using = "//input[@value='View Details']")
	private List<WebElement> viewDetailsElmts;

	@FindBy (how = How.XPATH, using = "//p[@id='notice']")
	private WebElement noticeElmt;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void select_a_pet(String petName) {
		int index = 0;
		for (WebElement petNameElmt: petNameElmts) {
			if (petNameElmt.getText().equals(petName)) {
				viewDetailsElmts.get(index).click();
				break;
			}
			index++;
		}
	}

	public void visit(String homePageUrl) {
		driver.get(homePageUrl);
	}

	public Object getNotice() {
		return noticeElmt.getText();
	}
}
