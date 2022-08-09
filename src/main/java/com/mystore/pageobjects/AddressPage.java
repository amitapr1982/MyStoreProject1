package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.mystore.base.BaseClass.driver;

public class AddressPage extends BaseClass {

    @FindBy(xpath = "//span[text()='Proceed to checkout']")
    WebElement proceedToCheckOut;

    public AddressPage(){

        PageFactory.initElements(getdriver(),this);
    }

    public ShippingPage clickToProceed(){
        Action.click(getdriver(),proceedToCheckOut);
        return new ShippingPage();
    }
}
