package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.util.List;
import java.util.Map;

public class PayBillsPage {

    public PayBillsPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(linkText="Add New Payee")
    public WebElement addNewPayee;

    @FindBy(id="np_new_payee_name")
    public WebElement payeeName;

    @FindBy(id="np_new_payee_address")
    public WebElement payeeAddress;

    @FindBy(id="np_new_payee_account")
    public WebElement payeeAccount;

    @FindBy(id="np_new_payee_details")
    public WebElement payeeDetails;

    @FindBy(xpath="//input[@value='Add']")
    public WebElement add;

    @FindBy(xpath="//div[@id='alert_content']/span")
    public WebElement infoMessage;

    @FindBy(xpath="//input[@value='Pay']")
    public WebElement pay;

    @FindBy(id="alert_content")
    public WebElement alertMessage;

    @FindBy(linkText="Purchase Foreign Currency")
    public WebElement purchaseForeign;

    @FindBy(id="pc_currency")
    public WebElement currencyDropdown;

    @FindBy(id="pc_amount")
    public WebElement currencyAmount;

    @FindBy(id="pc_calculate_costs")
    public WebElement calculateCost;

    @FindBy(id="sp_date")
    public WebElement payDate;

    @FindBy(id="sp_amount")
    public WebElement payAmount;

    @FindBy(id="sp_description")
    public WebElement payDescription;






    public void addInformation(Map<String,String> information) {
        payeeName.sendKeys(information.get("Payee Name"));
        payeeAddress.sendKeys(information.get("Payee Address"));
        payeeAccount.sendKeys(information.get("Account"));
        payeeDetails.sendKeys(information.get("Payee details"));
        BrowserUtils.waitFor(3);

    }

    public String verifyErrorDisplayed() {

        Alert alert=Driver.get().switchTo().alert(); // one time it is enough
        return alert.getText();

    }

    public void chooseCurrency() {

        Select stateDropdown=new Select(currencyDropdown);
        stateDropdown.selectByIndex(5);

    }
}
