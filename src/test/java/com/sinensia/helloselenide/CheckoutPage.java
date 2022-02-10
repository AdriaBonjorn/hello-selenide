package com.sinensia.helloselenide;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

// http://localhost:3000/#!/review
public class CheckoutPage {

    public static SelenideElement ageInput = $("#ageInput" );

    public static SelenideElement btnOrder = $(".btn-success");

    public SelenideElement btnCancel = $(".btn-default");

    public static void getAgeInput() {
        ageInput.click();
    }

    public static void sendKeysAge(String age) {
        ageInput.sendKeys(age);
    }

    public CartPage getBtnCancel() {
        btnCancel.click();
        return page(CartPage.class);
    }

    public static OrderPage order() {
        btnOrder.click();
        return page(OrderPage.class);
    }
}