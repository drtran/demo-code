package com.drkiettran.serenity2.cuketests.serenitysteps.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("http://puppies.herokuapp.com")
public class HomePage extends PageObject {

	public static final String NEXT_PAGE_DISABLED_XPATH = "//span[@class='next_page disabled']";

	public static final String VIEW_DETAILS_XPATH_TEMPLATE = "//*[@class='name']/h3[text()='%s']/../..//input[@value='View Details']";

	public static final String PETNAME_XPATH_TEMPLATE = "//*[@class='name']/h3[text()='%s']";

	@FindBy(id = "notice")
	private WebElement noticePara;

	@FindBy(className = "next_page")
	private WebElement nextLink;

	private String homePageUrl;

	public void visitHomePage(String homePageUrl) {
		this.homePageUrl = homePageUrl;
		openAt(homePageUrl);
	}

	public void visitHomePage() {
		openAt(homePageUrl);
	}

	public void viewDetailsOf(String petName) {
		String xpath = String.format(VIEW_DETAILS_XPATH_TEMPLATE, petName);
		getDriver().findElement(By.xpath(xpath)).click();
	}

	public boolean pageDisplaysThePet(String petName) {
		return getDriver().findElements(By.xpath(String.format(PETNAME_XPATH_TEMPLATE, petName))).size() == 1;
	}

	public boolean atLastPage() {
		return getDriver().findElements(By.xpath(NEXT_PAGE_DISABLED_XPATH)).size() == 1;
	}

	public boolean displayThankYouMessage(String thankYouMessage) {
		return thankYouMessage.equals(noticePara.getText());
	}

	public void nextPage() {
		nextLink.click();
	}
}
