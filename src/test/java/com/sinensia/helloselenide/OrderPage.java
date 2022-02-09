package com.sinensia.helloselenide;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

// http://localhost:3000/#!/success
public class OrderPage {

    public SelenideElement elementP = $("p");

    public SelenideElement alertDiv = $(".alert-danger");

    public String getAlertText(){
        return alertDiv.getText();
    }

    public SelenideElement alertDiv(){
        return alertDiv;
    }

    public String getOrderFinishedText(){
        return OrderFinishedtext.getText();
    }
}