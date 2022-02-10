Feature: Robobar cart

  Scenario: user add one cola
    Given user opens robobar website
    When user adds a cola
    Then total should be €1.25

  Scenario: user add two colas
    Given user opens robobar website
    When user adds a cola
    And user adds a cola
    Then total should be €2.50

  Scenario: user add one beer
    Given user opens robobar website
    When user adds a beer
    Then total should be €2.00

  Scenario: user add two beer
    Given user opens robobar website
    When user adds a beer
    When user adds a beer
    Then total should be €4.00

  Scenario: user add one wine
    Given user opens robobar website
    When user adds a wine
    Then total should be €3.00

  Scenario: user add two wine
    Given user opens robobar website
    When user adds a wine
    And user adds a wine
    Then total should be €6.00

  Scenario: user add two wine and a beer
    Given user opens robobar website
    When user adds a wine
    And user adds a wine
    And user adds a beer
    Then total should be €8.00

    Scenario: user add one beer and age is 17
      Given user opens robobar website
      When user adds a beer
      Then total should be €2.00
      When user press submit button
      And user enter his age is 17
      And user press order button
      Then alert is active

  Scenario: user add one beer and age is 25
    Given user opens robobar website
    When user adds a beer
    Then total should be €2.00
    When user press submit button
    And user enter his age is 25
    And user press order button
    Then alert is not active
    And order is confirmed