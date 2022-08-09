package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.mystore.base.BaseClass.getdriver;

public class HomePage extends BaseClass {

    @FindBy(xpath = "//span[text()='My wishlists']")
    WebElement myWishList;

    @FindBy(xpath = "//span[text()='Order history and details']")
    WebElement orderHistoryAndDetails;

    public HomePage(){
        PageFactory.initElements(getdriver(),this);
    }

    public boolean validateMyWishList(){
        return Action.isDisplayed(getdriver(),myWishList);

    }
    public boolean validateOrderHistory(){
        return Action.isDisplayed(getdriver(),orderHistoryAndDetails);
    }
    public String getCurrentURL(){
        String currentURL = getdriver().getCurrentUrl();
        return currentURL;
    }
}
