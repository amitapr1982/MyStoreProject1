package com.mystore.testcases;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseClass {

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

    @Test(groups = {"smoke","sanity"})
    public void loginTest(){
        Log.startTestCase("Login Test Case");
        ip = new IndexPage();
        Log.info("User going to signing the application");
        lp =  ip.clickOnSignIn();
        Log.info("Enter username and Password");
        hm = lp.login(prop.getProperty("username"),prop.getProperty("password"));
        String actualURL = hm.getCurrentURL();
        String expectedURL = "http://automationpractice.com/index.php?controller=my-account";
        Log.info("Verifying the user login ");
        Assert.assertEquals(actualURL,expectedURL);
        Log.info("User Able to login successfully");
        Log.endTestCase("loginTest");
    }
}
