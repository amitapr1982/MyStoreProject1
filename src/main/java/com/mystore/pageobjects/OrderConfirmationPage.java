package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage extends BaseClass {

    @FindBy(xpath = "//p/strong[contains(text(),'Your order on My Store is complete')]")
    WebElement orderconfimationText;

    public OrderConfirmationPage(){

        PageFactory.initElements(getdriver(),this);
    }

    public String validateConfirmationInf(){
        String confirmmessage = orderconfimationText.getText();
        return confirmmessage;
    }
}
