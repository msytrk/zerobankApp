package com.zerobank.step_definitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.PayBillsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class PayBillsStepDefs {


    @Given("the user clicks on Pay Bills tab")
    public void the_user_clicks_on_Pay_Bills_tab() {
        new AccountSummaryPage().payBills.click();
    }


    @When("user completes a successful Pay operation, {string} should be displayed")
    public void user_completes_a_successful_Pay_operation_should_be_displayed(String successMessage) {
        PayBillsPage payBillsPage = new PayBillsPage();
        payBillsPage.payAmount.sendKeys("100");
        payBillsPage.payDate.sendKeys("2020-10-23");
        payBillsPage.pay.click();
        Assert.assertEquals(successMessage,payBillsPage.infoMessage.getText());
    }

    @When("user tries to make a payment without entering the amount or date, {string} should be displayed")
    public void user_tries_to_make_a_payment_without_entering_the_amount_or_date_should_be_displayed(String expectedMessage) {
        PayBillsPage payBillsPage = new PayBillsPage();
        String actualMessage = payBillsPage.payAmount.getAttribute("validationMessage");
        Assert.assertEquals(expectedMessage,actualMessage);
    }

    @Then("Date field should not accept alphabetical characters")
    public void date_field_should_not_accept_alphabetical_characters() {
        // This part can be control with isAlphabetical etc methods
        PayBillsPage payBillsPage = new PayBillsPage();
        payBillsPage.payAmount.clear();
        payBillsPage.payAmount.sendKeys("This field can not accept alphabetical and >£#$½");
        Assert.assertEquals("",payBillsPage.payAmount.getText());
        payBillsPage.payDate.clear();
        payBillsPage.payDate.sendKeys("This field can not accept alphabetical");
        Assert.assertEquals("",payBillsPage.payDate.getText());
    }



}
