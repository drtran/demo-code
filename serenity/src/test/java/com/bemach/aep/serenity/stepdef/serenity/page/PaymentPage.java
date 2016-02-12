package com.bemach.aep.serenity.stepdef.serenity.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.bemach.aep.serenity.util.PaymentInfo;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class PaymentPage extends PageObject {
	@FindBy(tagName = "legend")
	WebElement legend;

	@FindBy(id = "order_name")
	WebElement orderName;

	@FindBy(id = "order_address")
	WebElement orderAddress;

	@FindBy(id = "order_email")
	WebElement orderEmail;

	@FindBy(id = "order_pay_type")
	WebElement orderPayType;

	@FindBy(xpath = "//input[@value='Place Order']")
	WebElement placeOrder;

	public void payForAdoption(PaymentInfo payment) {
		orderName.sendKeys(payment.getName());
		orderAddress.sendKeys(payment.getAddress());
		orderEmail.sendKeys(payment.getEmail());
		Select select = new Select(orderPayType);
		for (WebElement option : select.getOptions()) {
			if (payment.getPayType().equals(option.getText())) {
				option.click();
				break;
			}
		}
		placeOrder.click();
	}

}
