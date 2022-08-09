package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage extends BaseClass {

    @FindBy(xpath = "//a[contains(text(),'Pay by bank wire')]")
    WebElement payByBankWire;

    @FindBy(xpath = "//a[contains(text(),'Pay by check')]")
    WebElement payByCheck;

    public PaymentPage(){

        PageFactory.initElements(getdriver(),this);
    }

    public OrderSummaryPage clickOnBankWire(){
        Action.click(getdriver(),payByBankWire);
        return new OrderSummaryPage();
    }

    public OrderSummaryPage clickOnPayByCheck(){
        Action.click(getdriver(),payByCheck);
        return new OrderSummaryPage();
    }
}
