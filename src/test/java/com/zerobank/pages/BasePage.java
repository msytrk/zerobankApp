package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BasePage {

    @FindBy(linkText = "Account Summary")
    public WebElement accountSummary;

    @FindBy(linkText = "Account Activity")
    public WebElement accountActivitiy;

    @FindBy(linkText = "Transfer Funds")
    public WebElement transferFunds;

    @FindBy(linkText = "Pay Bills")
    public WebElement payBills;

    @FindBy(linkText = "My Money Map")
    public WebElement myMoneyMap;




    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }







}
