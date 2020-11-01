package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class AccountActivityPage extends BasePage {
    public AccountActivityPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id="aa_accountId")
    public WebElement dropdown;

    @FindBy(linkText = "Find Transactions")
    public WebElement findTransactions;

    @FindBy(id="aa_fromDate")
    public WebElement fromDate;

    @FindBy(id="aa_toDate")
    public WebElement toDate;

    @FindBy(id="aa_description")
    public WebElement description;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement findButton;

    @FindBy(xpath = "//div[@id='all_transactions_for_account']//th")
    public List<WebElement> tableName;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tr/td[2]")
    public List<WebElement> searchResult;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tr/td[1]")
    public List<WebElement> dateColumn;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tr/td[3]")
    public List<WebElement> deposit;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tr/td[4]")
    public List<WebElement> withdraw;

    @FindBy(id="aa_type")
    public WebElement typeDropdown;



    // To find contains or not
    public boolean getResultMatch(String description){
        boolean flag=true;

        for (WebElement result :searchResult ) {
            System.out.println("result.getText() = " + result.getText());
            if(!result.getText().contains(description)){
                flag=false;
                break;
        }}

        return flag;

}



    // To find at least one record
    public boolean moreThanOne(String type) {
        boolean flag = false;
        System.out.println(type);

        if (type.equals("Deposit")) {
            for (WebElement dep : deposit) {
                if (dep.getText().length() > 0) {
                    System.out.println(dep.getText());
                    flag = true;
                    break;
                }
            }
        } else {
            for (WebElement wd : withdraw) {
                if (wd.getText().length() > 0) {
                    System.out.println(wd.getText());
                    flag = true;
                    break;
                }
            }
        }

        return flag;

    }
    // To find no result in this type
    public boolean noResult(String type){

        if(type.equals("Deposit")) {
            if (deposit.get(0).getText().length() > 0)
                return false;
            else
                return true;
        }
        else if(withdraw.get(0).getText().length() >0)
            return false;
        else
            return true;
    }
    // Converter  List<WebElement> to Localdate
    public List<LocalDate> dateConverter() {
        List<LocalDate> dateList=new ArrayList<>();
        for (WebElement date : dateColumn) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
             LocalDate date1= LocalDate.parse(date.getText(), formatter);
             dateList.add(date1);
        }
        return dateList;


    }
    // Converter String to LocalDate with one parameter
    public LocalDate dateConverter(String date) {

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
            LocalDate date1= LocalDate.parse(date, formatter);

        return date1;


    }
    // Compare result between two LocalDate
    public boolean dateComparator(LocalDate fromDate,LocalDate toDate) {
        boolean flag=true;
        for (LocalDate date : dateConverter()) {

            if (date.isEqual(toDate) || date.isEqual(fromDate) || (date.isBefore(toDate) && date.isAfter(fromDate)) )
            {

                continue;
            }
            else
            {
                flag=false;
                break;
            }
        }

        return flag;


    }
    // Compare result between descending order
    public boolean dateComparator() {
        boolean flag=true;
        List<LocalDate> dateList=dateConverter();
        for (int i = 0; i < dateList.size(); i++) {
            for (int j = i; j < dateList.size(); j++) {

                if(dateList.get(i).isBefore(dateList.get(j))){
                    flag=false;
                    break;
                }
            }
        }
        return flag;
    }

    //notExistDate Control
    public boolean dateComparator(LocalDate notExist) {
        boolean flag=true;
        List<LocalDate> dateList=dateConverter();

        for (LocalDate date : dateList) {
            if(date.isEqual(notExist)){
                flag=false;
                break;
            }

        }

        return flag;
    }
}

