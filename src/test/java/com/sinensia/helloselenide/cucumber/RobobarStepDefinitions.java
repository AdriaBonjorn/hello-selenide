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

    //Instructions that the different scenarios use.

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

    //Enter age as parameter
    @And("user enter his age is {int}")
    public void userEnterHisAgeIs(int age) {
        CheckoutPage.getAgeInput();
        CheckoutPage.sendKeysAge(String.valueOf(age));
    }

    //To press order button
    @And("user press order button")
    public void userPressOrderButton() {
        CheckoutPage.order();
    }

    //To see if the underage alert pops-up
    @Then("alert is active")
    public void validationIsWrong() {
        OrderPage.getAlertMessage().shouldBe(text("Only adults can buy alcohol!"));
    }

    //To see if the underage alert does not pop-up
    @Then("alert is not active")
    public void alertIsNotActive() {
        OrderPage.getAlertMessage().shouldBe(hidden);
    }

    //To see if the webb confirms de order
    @And("order is confirmed")
    public void orderIsConfirmed() {
        OrderPage.getConfirmationMessage().shouldBe(text("Coming right up! ~bzzzt~"));
    }

    //To add N colas
    @When("user adds {int} colas")
    public void userAddsNBeer(int n) {
        for(int i=0; i<n; ++i) {
            cartPage.addRoboCola();
        }
    }

    //To add N beers
    @When("user adds {int} beers")
    public void userAddsNBeers(int n) {
        for(int i=0; i<n; ++i) {
            cartPage.addRoboBeer();
        }
    }

    //To add N wines
    @When("user adds {int} wines")
    public void userAddsNWines(int n) {
        for(int i=0; i<n; ++i) {
            cartPage.addRobowine();
        }
    }

    @Given("user is ready to check out with alcohol")
    public void userIsReadyToCheckOutWithAlcohol() {
        open("http://localhost:3000");
        userAddsABeer();
    }
}


