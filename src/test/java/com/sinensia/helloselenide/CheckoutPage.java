package com.sinensia.helloselenide;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

// about:blank
public class CheckoutPage {
    private SelenideElement btnOrder = $(".btn-success");

    private SelenideElement ageInput = $("#ageInput" );

    public OrderPage order() {
        btnOrder.click();
        return page(OrderPage.class);
    }

    public void setAge(String age) {
        ageInput.sendKeys(age);
    }

    public String getAge() {
        return ageInput.getText();
    }

    public SelenideElement ageInput() {
        return ageInput;
    }

}