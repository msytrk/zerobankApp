package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_old.Ac;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;


public class FindTransactionStepDefs {


    @Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        new LoginPage().login(ConfigurationReader.get("username"),ConfigurationReader.get("password"));
        new AccountSummaryPage().savings.get(0).click();
        new AccountActivityPage().findTransactions.click();
    }
    // Date
    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String fromDate, String toDate) {
        AccountActivityPage accountActivityPage=new AccountActivityPage();
        BrowserUtils.waitFor(4);
        accountActivityPage.fromDate.clear();
        accountActivityPage.fromDate.sendKeys(fromDate,Keys.ENTER);
        accountActivityPage.toDate.clear();
        accountActivityPage.toDate.sendKeys(toDate,Keys.ENTER);
        BrowserUtils.waitFor(4);

    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String fromDate, String toDate) {
        AccountActivityPage accountActivityPage=new AccountActivityPage();
        boolean result=accountActivityPage.dateComparator(accountActivityPage.dateConverter(fromDate),accountActivityPage.dateConverter(toDate));
        Assert.assertTrue(result);
    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {
        AccountActivityPage accountActivityPage=new AccountActivityPage();
        Assert.assertTrue(accountActivityPage.dateComparator());
    }

    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String dateNotExist) {
        AccountActivityPage accountActivityPage=new AccountActivityPage();
        Assert.assertTrue(accountActivityPage.dateComparator(accountActivityPage.dateConverter(dateNotExist)));
    }
    //Date

    @When("the user enters description {string}")
    public void the_user_enters_description(String description) {
        AccountActivityPage accountActivityPage=new AccountActivityPage();
        BrowserUtils.waitFor(5);
        accountActivityPage.description.clear();
        accountActivityPage.description.sendKeys(description);
    }

    @When("clicks search")
    public void clicks_search() {
        System.out.println("Click Step");
        BrowserUtils.waitFor(3);
        new AccountActivityPage().findButton.click();
        BrowserUtils.waitFor(3);


    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String desc) {
        BrowserUtils.waitFor(3);
        boolean flag=new AccountActivityPage().getResultMatch(desc);
        Assert.assertTrue(flag);
    }

    @Then("results table should not show descriptions containing {string}")
    public void results_table_should_not_show_descriptions_containing(String desc) {
        BrowserUtils.waitFor(3);
        boolean flag=new AccountActivityPage().getResultMatch(desc);
        Assert.assertFalse(flag);
    }





}
