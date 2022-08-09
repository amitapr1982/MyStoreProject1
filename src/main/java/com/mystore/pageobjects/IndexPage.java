package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;

public class IndexPage extends BaseClass {

    @FindBy(xpath = "//a[@class='login']")
    WebElement signinbtn;

    @FindBy(xpath = "//img[@class='logo img-responsive']")
    WebElement mystorelogo;

    @FindBy(id ="search_query_top")
    WebElement searchProductBox;

    @FindBy(name ="submit_search")
    WebElement searchButton;

    public IndexPage(){
        PageFactory.initElements(getdriver(),this);
    }

    public LoginPage clickOnSignIn(){
        Action.click(getdriver(),signinbtn);
        return new LoginPage();
    }

    public boolean validateLogo(){
        return Action.isDisplayed(getdriver(),mystorelogo);
    }

    public String getmyStoreTitle(){
        String mystoredtilte =  getdriver().getTitle();
        return mystoredtilte;
    }

    public SearchResultPage searchProduct(String productName){
        Action.type(searchProductBox,productName);
        Action.click(getdriver(),searchButton);
        return new SearchResultPage();
    }
}
