package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class AccountActivityStepDefs {

    @Then("the {string} page should be displayed")
    public void the_page_should_be_displayed(String pageTitle) {
        AccountActivityPage accountActivityPage=new AccountActivityPage();

        Assert.assertTrue(BrowserUtils.getPageTitle().contains(pageTitle));
        System.out.println("accountActivityPage.getPageTitle() = " + BrowserUtils.getPageTitle());
    }

    @Then("Account drop down should have {string} selected")
    public void account_drop_down_should_have_selected(String expectedOption) {
        AccountActivityPage accountActivityPage=new AccountActivityPage();
        String actualOption=BrowserUtils.getSelectedDropdown(accountActivityPage.dropdown);
        Assert.assertEquals(expectedOption,actualOption);

    }

    @Then("results table should show at least one result under {string}")
    public void results_table_should_show_at_least_one_result_under(String type) {
        BrowserUtils.waitFor(4);
        AccountActivityPage accountActivityPage=new AccountActivityPage();
        BrowserUtils.waitFor(4);
        Assert.assertTrue(accountActivityPage.moreThanOne(type));

    }

    @When("user selects type {string}")
    public void user_selects_type(String type) {

        AccountActivityPage accountActivityPage=new AccountActivityPage();
        BrowserUtils.chooseSelectedDropdown(accountActivityPage.typeDropdown,type);
    }

    @Then("results table should show no result under {string}")
    public void results_table_should_show_no_result_under(String type) {
        AccountActivityPage accountActivityPage=new AccountActivityPage();
        Assert.assertTrue(accountActivityPage.noResult(type));
    }

    @When("the user should be able to click Account Activity tab")
    public void the_user_should_be_able_to_click_Account_Activity_tab() {
        new AccountSummaryPage().accountActivitiy.click();
    }


    @Then("the dropdown should include following options")
    public void the_dropdown_should_include_following_options(List<String> dropdownOptions) {
        Assert.assertTrue(BrowserUtils.dropdownVerify(new AccountActivityPage().dropdown,dropdownOptions));    }

    @Then("the table should have to following account types")
    public void the_table_should_have_to_following_account_types(List<String> userTable) {

        // This method inside Browser Utils and it verify it step by step
        // Assert.assertTrue(BrowserUtils.verifyAccounts(userTable,new AccountSummaryPage().tableName));
        // BrowserUtils.getElementsText(new AccountSummaryPage().tableName) is taking all text from tableName
        BrowserUtils.waitFor(3);
        Assert.assertEquals(userTable,BrowserUtils.getElementsText(new AccountActivityPage().tableName));


    }



}





