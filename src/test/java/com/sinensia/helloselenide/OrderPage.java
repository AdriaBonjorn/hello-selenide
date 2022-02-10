package com.sinensia.helloselenide;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

// http://localhost:3000/#!/review
public class OrderPage {

    public static SelenideElement alertMessage = $("p");

    public static SelenideElement confirmationMessage = $("p");

    public static SelenideElement getAlertMessage() {
        return alertMessage;
    }

    public static SelenideElement getConfirmationMessage() {
        return confirmationMessage;
    }
}