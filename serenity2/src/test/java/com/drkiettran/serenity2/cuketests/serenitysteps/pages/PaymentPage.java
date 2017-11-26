package com.drkiettran.serenity2.cuketests.serenitysteps.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PaymentPage extends PageObject{
    @FindBy(id="order_name")
    private WebElement orderNameInput;

    @FindBy(id="order_address")
    private WebElement orderAddressTextArea;

    @FindBy(id="order_email")
    private WebElement orderEmailInput;

    @FindBy(name="commit")
    private WebElement placeOrderButton;

    public void enterName(String fullName) {
        orderNameInput.clear();
        orderNameInput.sendKeys(fullName);
    }

    public void enterStreetAddress(String streetAddress) {
        orderAddressTextArea.sendKeys(streetAddress);
    }

    public void enterEmailAddress(String emailAddress) {
        orderEmailInput.sendKeys(emailAddress);
    }

    public void selectPaymentType(String paymentType) {
        String optionXpath = String.format("//option[@value='%s']",paymentType);
        getDriver().findElement(By.xpath(optionXpath)).click();
    }

    public void placeAnOrder() {
        placeOrderButton.click();
    }
}
