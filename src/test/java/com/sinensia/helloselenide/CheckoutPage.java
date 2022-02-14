package com.sinensia.helloselenide;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

// about:blank
public class CheckoutPage {
    private SelenideElement btnConfirm = $(".btn-success");
    SelenideElement fldAge = $("#ageInput");

    public void setAge(String age) {
        fldAge.sendKeys(age);
    }

    public OrderPage confirm() {
        btnConfirm.click();
        return page(OrderPage.class);
    }
}
