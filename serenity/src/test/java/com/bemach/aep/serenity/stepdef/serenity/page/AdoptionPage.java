package com.bemach.aep.serenity.stepdef.serenity.page;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.bemach.aep.serenity.util.PaymentInfo;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class AdoptionPage extends PageObject {

	private ViewDetailsPage viewDetailsPage;
	private CompletingAdoptionPage completingAdoptionPage;
	private PaymentPage paymentPage;

	@FindBy(className = "name")
	List<WebElement> pets;

	@FindBy(className = "next_page")
	WebElement nextButton;

	@FindBy(xpath = "//input[@value='View Details']")
	List<WebElement> viewDetails;

	@FindBy(xpath = "//span[@class='next_page disabled']")
	List<WebElement> nextButtonDisabledList;

	public void adoptThePuppy(String puppyName) {
		do {
			for (int idx = 0; idx < pets.size(); idx++) {
				if (puppyName.equals(pets.get(idx).getText())) {
					System.out.println("Chosen: " + pets.get(idx).getText());
					viewDetails.get(idx).click();
					viewDetailsPage.adoptPuppy();
					return;
				}
			}
		} while (nextButton());
	}

	private boolean nextButton() {
		if (nextButtonDisabledList.size() > 0) {
			return false;
		}

		nextButton.click();
		return true;
	}

	public void adoptAnotherPuppy() {
		completingAdoptionPage.adoptAnotherPuppy();
	}

	public void completeTheAdoption() {
		completingAdoptionPage.completeTheAdoption();
	}

	public void payForAdoption(PaymentInfo payment) {
		paymentPage.payForAdoption(payment);
	}

}
