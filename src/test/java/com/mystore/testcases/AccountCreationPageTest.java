package com.mystore.testcases;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AccountCreationPageTest extends BaseClass {

    IndexPage ip;
    LoginPage lp;
    HomePage hm;
    AccountCreationPage acp;

    @Parameters("browser")
    @BeforeMethod(groups = {"smoke","sanity","Regression"})
    public void setup(String browser) throws InterruptedException {
        launchApp(browser);
    }

    @AfterMethod(groups = {"smoke","sanity","Regression"})
    public void tearDown(){
        getdriver().quit();
    }

    @Test(groups = "sanity")
    public void verifyAccountCreatePage(){
        ip = new IndexPage();
        lp = ip.clickOnSignIn();
        acp = lp.createNewAccount("amitpar198@gmail.com");
        boolean result2 = acp.validateAccountCreatePage();
        Assert.assertTrue(result2);

    }
}
