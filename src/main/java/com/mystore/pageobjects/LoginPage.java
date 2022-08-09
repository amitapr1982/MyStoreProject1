package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {

    @FindBy(id="email") WebElement userName;
    @FindBy(id="passwd") WebElement password;
    @FindBy(id="SubmitLogin") WebElement submitBtn;
    @FindBy(id="email_create") WebElement emailForNewAccount;
    @FindBy(id="SubmitCreate") WebElement submitCreateBtn;

    public LoginPage(){

        PageFactory.initElements(getdriver(),this);
    }

    public HomePage login(String uname,String pass){
        Action.type(userName,uname);
        Action.type(password,pass);
        Action.click(getdriver(),submitBtn);
        return new HomePage();
    }
    public AddressPage login1(String uname,String pass){
        Action.type(userName,uname);
        Action.type(password,pass);
        Action.click(getdriver(),submitBtn);
        return new AddressPage();
    }
    public AccountCreationPage createNewAccount(String newemail){
        Action.type(emailForNewAccount,newemail);
        Action.click(getdriver(),submitCreateBtn);
        return new AccountCreationPage();
    }
}
