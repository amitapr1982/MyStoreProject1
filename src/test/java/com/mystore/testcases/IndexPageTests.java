package com.mystore.testcases;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class IndexPageTests extends BaseClass {
    IndexPage IP;

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
    public void verifyLogo(){
        IP = new IndexPage();
        boolean result = IP.validateLogo();
        Assert.assertTrue(result);
    }
    @Test(groups = "smoke")
    public void verifyTitle(){
        String actTiltle = IP.getmyStoreTitle();
        Assert.assertEquals(actTiltle,"My Store");
    }
}
