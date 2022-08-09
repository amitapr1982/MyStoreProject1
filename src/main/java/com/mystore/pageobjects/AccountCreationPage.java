package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreationPage extends BaseClass {

    @FindBy(xpath = "//h3[text()='Create an account']")
    WebElement formTitle;

    public AccountCreationPage(){
        PageFactory.initElements(getdriver(),this);
    }

    public boolean validateAccountCreatePage(){
        boolean result = Action.isDisplayed(getdriver(),formTitle);
        return result;
    }
}
