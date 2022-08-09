package com.mystore.testcases;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AddToCartPageTest extends BaseClass {

    IndexPage ip;
    SearchResultPage srp;
    AddToCartPage atcp;

    @Parameters("browser")
    @BeforeMethod(groups = {"smoke","sanity","Regression"})
    public void setup(String browser) throws InterruptedException {
        launchApp(browser);
    }

    @AfterMethod(groups = {"smoke","sanity","Regression"})
    public void tearDown(){
        getdriver().quit();
    }

    @Test(groups = {"Regression","sanity"})
    public void verifyaddtoCartTest() throws InterruptedException {
        ip = new IndexPage();
        srp = ip.searchProduct("t-shirt");
        atcp = srp.clickOnProduct();
        Thread.sleep(1000);
        atcp.enterquantity("2");
        atcp.selectSize("M");
        atcp.clicktoAddToCart();
        Thread.sleep(2000);
        boolean result = atcp.validateToAddCart();
        Assert.assertTrue(result);
    }

}
