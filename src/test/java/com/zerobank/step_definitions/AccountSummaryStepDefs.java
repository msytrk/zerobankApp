package com.zerobank.step_definitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class AccountSummaryStepDefs {

    @When("the user clicks on Savings link on the Account Summary page")
    public void the_user_clicks_on_Savings_link_on_the_Account_Summary_page() {

        new AccountSummaryPage().savings.get(0).click();
    }


    @When("the user clicks on Brokerage link on the Account Summary page")
    public void the_user_clicks_on_Brokerage_link_on_the_Account_Summary_page() {

        new AccountSummaryPage().brokerage.click();
    }

    @When("the user clicks on Checking link on the Account Summary page")
    public void the_user_clicks_on_Checking_link_on_the_Account_Summary_page() {

        new AccountSummaryPage().checking.click();


    }

    @When("the user clicks on Credit card link on the Account Summary page")
    public void the_user_clicks_on_Credit_card_link_on_the_Account_Summary_page() {

        new AccountSummaryPage().creditCard.click();
    }

    @When("the user clicks on Loan link on the Account Summary page")
    public void the_user_clicks_on_Loan_link_on_the_Account_Summary_page() {

        new AccountSummaryPage().loan.click();
    }

    @Given("the user is should be login page")
    public void the_user_is_should_be_login_page() {
        Driver.get().get("http://zero.webappsecurity.com/login.html");
    }


    @When("the should be able to enter {string} {string}")
    public void the_should_be_able_to_enter(String username, String password) {

        new LoginPage().login(username,password);
    }

    @Then("the title should be {string}")
    public void the_title_should_be(String expectedTitle) {

        String actualTitle= BrowserUtils.getPageTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @Then("the Account Summary page should have to following account types")
    public void the_Account_Summary_page_should_have_to_following_account_types(List<String> accountTypes) {

        Assert.assertTrue(BrowserUtils.verifyAccounts(accountTypes,new AccountSummaryPage().accounts));




    }
    @Then("the Credit Accounts table should have to following account types")
    public void the_Credit_Accounts_table_should_have_to_following_account_types(List<String> userTable) {
        // This method inside Browser Utils and it verify it step by step
        // Assert.assertTrue(BrowserUtils.verifyAccounts(userTable,new AccountSummaryPage().credits));
        // BrowserUtils.getElementsText(new AccountSummaryPage().credits) is taking all text from credits
        Assert.assertEquals(userTable,BrowserUtils.getElementsText(new AccountSummaryPage().credits));

    }



}