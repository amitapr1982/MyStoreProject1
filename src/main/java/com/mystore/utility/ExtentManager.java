package com.mystore.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentManager {

    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest test;

    public static void setExtent(){
        String path = System.getProperty("user.dir");
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/ExtentReport/"+"MyReport.html");
        htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        extent.setSystemInfo("Hostname","myHost");
        extent.setSystemInfo("ProjectName","MyStoredProject");
        extent.setSystemInfo("Tester","Hitendra");
        extent.setSystemInfo("OS","Win10");
        extent.setSystemInfo("browser","Chrome");

    }
    public static void endreport(){
        extent.flush();
    }
}
