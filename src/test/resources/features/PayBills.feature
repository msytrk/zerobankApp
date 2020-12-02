@Reg
Feature: Pay Bills functions

  Background:
    Given the user is logged in
    Given the user clicks on Pay Bills tab

  Scenario: Positive Payment check
    Then the title should be "Zero - Pay Bills"
    When user completes a successful Pay operation, "The payment was successfully submitted." should be displayed

  Scenario: Negative Payment Check
    Then the title should be "Zero - Pay Bills"
    When user tries to make a payment without entering the amount or date, "Please fill out this field." should be displayed

  Scenario: Input field check
    Then Date field should not accept alphabetical characters
