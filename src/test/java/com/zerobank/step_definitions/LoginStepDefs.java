package com.zerobank.step_definitions;


import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class LoginStepDefs {

    @Given("the user is logged in")
    public void the_user_is_logged_in() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        new LoginPage().login(ConfigurationReader.get("username"),ConfigurationReader.get("password"));
        BrowserUtils.waitFor(5);
        System.out.println("Login ");

    }

    @Then("the error message should display {string}")
    public void the_error_message_should_display(String expectedError) {
        String actualError=new LoginPage().errorLogin.getText();
        Assert.assertEquals(expectedError,actualError);
    }





}







