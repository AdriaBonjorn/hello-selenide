package com.sinensia.helloselenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CartSuiteTest {
    CartPage cartPage =  new CartPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        open("http://localhost:3000/");
    }

    @Test
    public void colaTest() {
        cartPage.btnCheckout().shouldBe(disabled);
        cartPage.addCola();
        cartPage.btnCheckout().shouldBe(enabled);
        cartPage.total().shouldBe(text("€1.25"));
    }

    @Test
    public void ageTest() {
        cartPage.addBeer();
        CheckoutPage checkoutPage = cartPage.checkout();
        checkoutPage.ageInput().shouldBe(enabled);
    }
}
