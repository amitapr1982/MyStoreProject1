package com.mystore.pageobjects;

import com.aventstack.extentreports.reporter.configuration.Theme;
import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.mystore.base.BaseClass.driver;

public class AddToCartPage extends BaseClass {

    @FindBy(id = "quantity_wanted")
    WebElement quantity;

    @FindBy(name = "group_1")
    WebElement size;

    @FindBy(xpath = "//span[text()='Add to cart']")
    WebElement addToCartBtn;

    @FindBy(xpath = "//*[@id=\"layer_cart\"]//h2/i")
    WebElement successfulladdtocart;

    @FindBy(xpath = "//*[@id=\"layer_cart\"]//a/span")
    WebElement proceedToCheckOut;

    public AddToCartPage(){

        PageFactory.initElements(getdriver(),this);
    }

    public void enterquantity(String qty) throws InterruptedException {
        Action.type(quantity,qty);
    }
    public void selectSize(String selectsize){
        Action.selectByVisibleText(size,selectsize);
    }
    public void clicktoAddToCart() throws InterruptedException {
        Thread.sleep(2000);
        Action.JSClick(getdriver(),addToCartBtn);
    }
    public boolean validateToAddCart() throws InterruptedException {
        Thread.sleep(1000);
        boolean result = Action.isDisplayed(getdriver(),successfulladdtocart);
        return result;
    }
    public OrderedPage clicktoCheckOut() throws InterruptedException {
        Thread.sleep(3000);
        Action.JSClick(getdriver(),proceedToCheckOut);
        return new OrderedPage();
    }
}
