package com.mystore.utility;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.testng.ITestListener;
import org.testng.ITestMethodFinder;
import org.testng.ITestResult;

import java.io.IOException;

public class ListnerClass extends ExtentManager implements ITestListener {

    public void onTestStart(ITestResult result){
        test = extent.createTest(result.getName());
        test.createNode(result.getName());
    }

    public void onTestSuccess(ITestResult result){
        if(result.getStatus() == ITestResult.SUCCESS){
            test.log(Status.PASS,"Pass Test Case is: " + result.getName());
        }
    }
    public void onTestFail(ITestResult result){
        if(result.getStatus() == ITestResult.FAILURE){
            try{
                test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "- Test Case Failed", ExtentColor.RED));
                test.log(Status.FAIL,MarkupHelper.createLabel(result.getThrowable() + "- Test Case Failed",ExtentColor.RED));
                String imgPath= Action.screenShot(BaseClass.getdriver(),result.getName());

                test.fail("ScreenShot is attached ", MediaEntityBuilder.createScreenCaptureFromPath(imgPath).build());
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    public void onTestSkipped(ITestResult result){
        if(result.getStatus() == ITestResult.SKIP){
            test.log(Status.SKIP,"Skipped as Test is : " + result.getName());
        }
    }
}
