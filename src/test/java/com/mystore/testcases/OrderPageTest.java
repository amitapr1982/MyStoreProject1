package com.mystore.testcases;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.OrderedPage;
import com.mystore.pageobjects.SearchResultPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OrderPageTest extends BaseClass {

    IndexPage ip;
    SearchResultPage srp;
    AddToCartPage atcp;
    OrderedPage op;

    @Parameters("browser")
    @BeforeMethod(groups = {"smoke","sanity","Regression"})
    public void setup(String browser) throws InterruptedException {
        launchApp(browser);
    }

    @AfterMethod(groups = {"smoke","sanity","Regression"})
    public void tearDown(){
        getdriver().quit();
    }

    @Test(groups = "Regression")
    public void verifyProductTotalPrice() throws InterruptedException {
        ip = new IndexPage();
        srp = ip.searchProduct("t-shirt");
        atcp = srp.clickOnProduct();
        atcp.enterquantity("2");
        atcp.selectSize("M");
        atcp.clicktoAddToCart();
        op = atcp.clicktoCheckOut();
        double unitprice = op.getUnitPrice();
        double totalPrice = op.getTotalPrice();
        double totalexpectedprice = (unitprice*2) + 2;
        Assert.assertEquals(totalPrice,totalexpectedprice);
    }
}
