package com.mystore.testcases;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HomePageTest extends BaseClass {

    IndexPage ip;
    LoginPage lp;
    HomePage hm;

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
    public void verifyWishList(){
        ip = new IndexPage();
        lp = ip.clickOnSignIn();
        hm = lp.login(prop.getProperty("username"),prop.getProperty("password"));
        boolean result = hm.validateMyWishList();
        Assert.assertTrue(result);
    }

    @Test(groups = "smoke")
    public void verifyOrderHistoryList(){
        ip = new IndexPage();
        lp = ip.clickOnSignIn();
        hm = lp.login(prop.getProperty("username"),prop.getProperty("password"));
        boolean result1 = hm.validateOrderHistory();
        Assert.assertTrue(result1);
    }
}
