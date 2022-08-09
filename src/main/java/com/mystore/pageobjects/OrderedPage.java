package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderedPage extends BaseClass {

    @FindBy(xpath = "//td[@class='cart_unit']/span/span")
    WebElement unitprice;

    @FindBy(id="total_price")
    WebElement totalPrice;

    @FindBy(xpath = "//span[text()='Proceed to checkout']")
    WebElement proceedToCheckoutBtn;

    public OrderedPage(){

        PageFactory.initElements(getdriver(),this);
    }

    public Double getUnitPrice() throws InterruptedException {
        String unitprice1 = unitprice.getText();
        String unit = unitprice1.replaceAll("[^a-zA-Z0-9]","");
        Double finalunitPrice = Double.parseDouble(unit);
        return finalunitPrice/100;
    }
    public Double getTotalPrice(){
        String totalPrice1 = totalPrice.getText();
        String total = totalPrice1.replaceAll("[^a-zA-Z0-9]","");
        Double finalTotalPrice = Double.parseDouble(total);
        return finalTotalPrice/100;
    }
    public LoginPage clickOnCheckOut() throws InterruptedException {
        Thread.sleep(3000);
        Action.click(getdriver(),proceedToCheckoutBtn);
        return new LoginPage();
    }
}
