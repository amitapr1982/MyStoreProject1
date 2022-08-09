package com.mystore.testcases;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class EndtoEndTest extends BaseClass {

    IndexPage ip;
    SearchResultPage srp;
    AddToCartPage atcp;
    OrderedPage op;
    LoginPage lp;
    AddressPage ap;
    ShippingPage sp;
    PaymentPage pp;
    OrderSummaryPage osp;
    OrderConfirmationPage ocp;

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
    public void endtoEndtest() throws InterruptedException {
        ip = new IndexPage();
        srp = ip.searchProduct("t-shirt");
        atcp = srp.clickOnProduct();
        atcp.enterquantity("2");
        atcp.selectSize("M");
        atcp.clicktoAddToCart();
        op = atcp.clicktoCheckOut();
        lp = op.clickOnCheckOut();
        ap = lp.login1(prop.getProperty("username"),prop.getProperty("password"));
        sp = ap.clickToProceed();
        sp.checkTheTerms();
        pp = sp.clickOnProceedToCheckOut();
        osp = pp.clickOnBankWire();
        ocp = osp.clickOnConfirm();
        String ActualMessage = ocp.validateConfirmationInf();
        String ExpectedMessage = "Your order on My Store is complete.";
        Assert.assertEquals(ActualMessage,ExpectedMessage);
    }
}
