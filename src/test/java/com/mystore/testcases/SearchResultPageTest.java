package com.mystore.testcases;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchResultPageTest extends BaseClass {

    IndexPage ip;
    SearchResultPage srp;

    @Parameters("browser")
    @BeforeMethod(groups = {"smoke","sanity","Regression"})
    public void setup(String browser) throws InterruptedException {
        launchApp(browser);
    }

    @AfterMethod(groups = {"smoke","sanity","Regression"})
    public void tearDown(){
        getdriver().quit();
    }

    @Test(groups = "smoke")
    public void verifyProductAvaliability(){
        ip = new IndexPage();
        srp = ip.searchProduct("t-shirt");
        boolean result = srp.isProductAvaliable();
        Assert.assertTrue(result);
    }

}
