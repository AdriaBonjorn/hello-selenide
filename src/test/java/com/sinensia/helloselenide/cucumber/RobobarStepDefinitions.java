package com.sinensia.helloselenide.cucumber;

import com.sinensia.helloselenide.CartPage;
import com.sinensia.helloselenide.CheckoutPage;
import com.sinensia.helloselenide.OrderPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;

public class RobobarStepDefinitions {
    CartPage cartPage;

    @Given("user opens robobar website")
    public void userOpensRobobarWebsite() {
        open("http://localhost:3000");
        cartPage = new CartPage();
    }

    @When("user adds a cola")
    public void userAddsACola() {
        cartPage.addRoboCola();
    }

    @Then("total should be €{double}")
    public void totalShouldBe(Double total) {
        cartPage.total().shouldBe(exactText("€"+String.format("%.2f", total)));
    }

    @When("user adds a beer")
    public void userAddsABeer() { cartPage.addRoboBeer();
    }

    @When("user adds a wine")
    public void userAddsAWine() {
        cartPage.addRobowine();
    }

    @When("user press submit button")
    public void userPressSubmitButton() {
        cartPage.btnCheckout.click();
    }

    @And("user enter his age is {int}")
    public void userEnterHisAgeIs(int arg0) {
        CheckoutPage.getAgeInput();
        CheckoutPage.sendKeysAge("17");
    }

    @And("user press order button")
    public void userPressOrderButton() {
        CheckoutPage.order();
    }

    @Then("alert is active")
    public void validationIsWrong() {
        OrderPage.getAlertMessage().shouldBe(text("Only adults can buy alcohol!"));
    }

    @Then("alert is not active")
    public void alertIsNotActive() {
        OrderPage.getAlertMessage().shouldBe(hidden);
    }

    @And("order is confirmed")
    public void orderIsConfirmed() {
        OrderPage.getConfirmationMessage().shouldBe(text("Coming right up! ~bzzzt~"));
    }
}
