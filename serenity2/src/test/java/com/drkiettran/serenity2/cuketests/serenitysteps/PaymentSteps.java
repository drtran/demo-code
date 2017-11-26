package com.drkiettran.serenity2.cuketests.serenitysteps;


import com.drkiettran.serenity2.cuketests.serenitysteps.pages.PaymentPage;

import net.thucydides.core.annotations.Step;

public class PaymentSteps {
    private PaymentPage paymentPage;

    @Step
    public void i_enter_name(String fullName) {
        paymentPage.enterName(fullName);
    }

    @Step
    public void i_enter_street_address(String streetAddress) {
        paymentPage.enterStreetAddress(streetAddress);
    }

    @Step
    public void i_enter_email_address(String emailAddress) {
        paymentPage.enterEmailAddress(emailAddress);
    }

    @Step
    public void i_select_payment_type(String paymentType) {
        paymentPage.selectPaymentType(paymentType);
    }

    @Step
    public void i_place_an_order() {
        paymentPage.placeAnOrder();
    }
}
