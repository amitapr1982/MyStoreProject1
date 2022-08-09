package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.mystore.base.BaseClass.driver;

public class ShippingPage extends BaseClass {

    @FindBy(id="cgv")
    WebElement termCheckBox;

    @FindBy(xpath = "//button/span[contains(text(),'Proceed to checkout')]")
    WebElement proceedToCheckOut;

    public ShippingPage(){

        PageFactory.initElements(getdriver(),this);
    }

    public void checkTheTerms(){
        Action.click(getdriver(),termCheckBox);
    }
    public PaymentPage clickOnProceedToCheckOut(){
        Action.click(getdriver(),proceedToCheckOut);
        return new PaymentPage();
    }

}
