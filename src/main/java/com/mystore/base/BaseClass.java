package com.mystore.base;

import com.mystore.actiondriver.Action;
import com.mystore.utility.ExtentManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.webdriver.WebDriverBrowser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.w3c.dom.DOMConfiguration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Driver;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    public static Properties prop;

    /*Comment the below line because now we are using thread local driver*/
    //public static WebDriver driver;
    //Declare ThreadLocal Driver for Parallel excution
    public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

    @BeforeSuite(groups = {"smoke","sanity","Regression"})
    public static void loadConfig(){
        ExtentManager.setExtent();
        try{
            prop = new Properties();
            System.out.println("super contruction invoked");
            FileInputStream ip = new FileInputStream(
                    System.getProperty("user.dir") + ("\\Configuration\\Config.properties")
            );
            prop.load(ip);
            System.out.println("driver: " + driver);
        }catch (FileNotFoundException ex)
        {
            ex.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
     //DOMConfiguration.configure("log4j2.xml");
    }
    public static WebDriver getdriver(){
        //Get Driver from threadlocalmap
        return driver.get();
    }
/*    @BeforeTest(groups = {"smoke","sanity","Regression"})
    public void loadConfig() {
        try{
            prop = new Properties();
            System.out.println("super contruction invoked");
            FileInputStream ip = new FileInputStream(
                    System.getProperty("user.dir") + ("\\Configuration\\Config.properties")
            );
            prop.load(ip);
            System.out.println("driver: " + driver);
        }catch (FileNotFoundException ex)
        {
            ex.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }*/

    public static void launchApp(String browsername) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        //String browsername = prop.getProperty("browser");

        if (browsername.contains("Chrome")){
            WebDriverManager.chromedriver().setup();
            //driver = new ChromeDriver();
            /*Set browser to RemoteLocalMap*/
            driver.set(new ChromeDriver());
        }else if (browsername.contains("FireFox")){
            WebDriverManager.firefoxdriver().setup();
                    //driver = new FirefoxDriver();
            driver.set(new FirefoxDriver());
        }else if (browsername.contains("IE")){
            WebDriverManager.iedriver().setup();
            //driver = new InternetExplorerDriver();
            driver.set(new InternetExplorerDriver());
        }

        getdriver().manage().window().maximize();

        //driver.wait(10);
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        getdriver().get(prop.getProperty("url"));
    }

    @AfterSuite
    public void aftersuite(){
        ExtentManager.endreport();
    }
}
