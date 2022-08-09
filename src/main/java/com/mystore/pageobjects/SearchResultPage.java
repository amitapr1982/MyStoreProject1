package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.mystore.base.BaseClass.driver;

public class SearchResultPage extends BaseClass {

    @FindBy(xpath = "//*[@id=\"center_column\"]//h5/a")
    //*[@id="center_column"]//img
    WebElement productResult;

    public SearchResultPage(){

        PageFactory.initElements(getdriver(),this);
    }

    public boolean isProductAvaliable(){
        return Action.isDisplayed(getdriver(),productResult);
    }

    public AddToCartPage clickOnProduct() throws InterruptedException {
        Action.click(getdriver(),productResult);
        Thread.sleep(1000);
        return new AddToCartPage();
    }
}
