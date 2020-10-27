package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.Map;

public class AddNewPayeeStepDefs {

    @Given("Add New Payee tab")
    public void add_New_Payee_tab() {
        new AccountActivityPage().payBills.click();
        new PayBillsPage().addNewPayee.click();
        BrowserUtils.waitFor(3);
    }

    @Given("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String,String> information) {

        new PayBillsPage().addInformation(information);
        new PayBillsPage().add.click();
        BrowserUtils.waitFor(3);


    }

    @Then("message {string} should be displayed")
    public void message_should_be_displayed(String expectedMessage) {

        Assert.assertEquals(expectedMessage,new PayBillsPage().alertMessage.getText());
        BrowserUtils.waitFor(3);

    }



}
