package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class PurchaseForeignStepDefs {

    @Given("the user accesses the Purchase foreign currency cash tab")
    public void the_user_accesses_the_Purchase_foreign_currency_cash_tab() {

        new AccountActivityPage().payBills.click();
        new PayBillsPage().purchaseForeign.click();
        BrowserUtils.waitFor(3);

    }

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> dropdownOptions) {
        System.out.println(dropdownOptions.toString());
        Assert.assertTrue(BrowserUtils.dropdownVerify(new PayBillsPage().currencyDropdown,dropdownOptions));    }

    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {
        PayBillsPage payBillsPage=new PayBillsPage();
        payBillsPage.currencyAmount.sendKeys("1000");
        payBillsPage.calculateCost.click();
    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        String expectedMessage="Please, ensure that you have filled all the required fields with valid values.";
        Assert.assertEquals(expectedMessage,new PayBillsPage().verifyErrorDisplayed());

    }

    @When("user tries to calculate cost without entering a value")
    public void user_tries_to_calculate_cost_without_entering_a_value() {
        PayBillsPage payBillsPage=new PayBillsPage();
        payBillsPage.chooseCurrency();
        payBillsPage.calculateCost.click();
    }

}
