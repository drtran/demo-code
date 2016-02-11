package com.bemach.aep.cukes.stepdef.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AdoptingPetsPage {

	@FindBy(how = How.CLASS_NAME, using = "item_price")
	private List<WebElement> itemPriceElmts;

	@FindBy(how = How.XPATH, using = "//input[@value='Complete the Adoption']")
	private WebElement completeTheAdoptionButtonElmt;

	@FindBy(how = How.XPATH, using = "//input[@value='Adopt Another Puppy']")
	private WebElement adoptAnotherPetButtonElmt;

	public Iterable<? super String> getPrices() {
		List<String> itemPrices = new ArrayList<String>();
		for (WebElement itemPriceElmt : itemPriceElmts) {
			itemPrices.add(itemPriceElmt.getText());
		}

		return itemPrices;
	}

	public void complete_the_adoption() {
		completeTheAdoptionButtonElmt.click();
	}

	public void adoptAnotherPet() {
		adoptAnotherPetButtonElmt.click();
	}

}
