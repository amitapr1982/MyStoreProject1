package com.mystore.actiondriver;

import com.mystore.base.BaseClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Action extends BaseClass {

    public static void scrollByVisibilityOfElement(WebDriver driver, WebElement ele){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",ele);
    }

    public static void click(WebDriver ldriver,WebElement locatorname){
        Actions act = new Actions(ldriver);
        act.moveToElement(locatorname).click().build().perform();
    }
    public static boolean findElement(WebDriver ldriver,WebElement ele){
        boolean flag = false;
        try{
            ele.isDisplayed();
            flag =true;
        }catch (Exception e){
            flag =false;
        }finally {
            if (flag){
                System.out.println("Successfully found the element at");
            }else
            {
                System.out.println("Unable to find the element at");
            }
        }
        return flag;
    }
    public static boolean isDisplayed(WebDriver ldriver,WebElement ele){
        boolean flag = false;
            flag = findElement(ldriver,ele);
            if (flag){
                flag= ele.isDisplayed();
                if(flag){
                    System.out.println("The Element is displayed");
                }else
                {
                    System.out.println("The Element is not displayed");
                }
            }else
            {
                System.out.println("not displayed");
            }
        return flag;
    }

    public static boolean isSelected(WebDriver ldriver, WebElement ele){
        boolean flag = false;
        flag = findElement(ldriver,ele);
        if(flag){
            flag = ele.isSelected();
            if (flag)
            {
                System.out.println("The Eletment is selected");
            }else
            {
                System.out.println("The Eletment is not selected");
            }
        }else
        {
            System.out.println("not Selected");
        }
        return flag;
    }
    public static boolean isEnabled(WebDriver ldriver, WebElement ele){
        boolean flag = false;
        flag = findElement(ldriver,ele);
        if(flag){
            flag = ele.isEnabled();
            if (flag)
            {
                System.out.println("The Eletment is Enabled");
            }else
            {
                System.out.println("The Eletment is not Enabled");
            }
        }else
        {
            System.out.println("not Enabled");
        }
        return flag;
    }
    public static boolean type(WebElement ele, String text){
        boolean flag = false;
        try{
            flag = ele.isDisplayed();
            ele.clear();
            ele.sendKeys(text);
            flag=true;

        }catch (Exception ex)
        {
            System.out.println("Location not found");
            flag = false;
        }finally {
            if(flag){
                System.out.println("Successfully Enter the value");
            }else
            {
                System.out.println("Unable to enter the value");
            }
        }
        return flag;
    }

    public static boolean selectBySendKeys(WebElement ele, String value){
        boolean flag = false;
        try{
            ele.sendKeys(value);
            flag = true;
            return true;
        }catch (Exception e){
            return false;
        }finally {
            if(flag){
                System.out.println("Selected value from the DropDown");
            }else
            {
                System.out.println("not Selected value from the dropDown ");
            }
        }
    }

    public static boolean selectByIndex(WebElement ele, int index){
        boolean flag = false;
        try{
            Select s = new Select(ele);
            s.selectByIndex(index);
            flag = true;
            return true;
        }catch (Exception e){
            return false;
        }finally {
            if(flag){
                System.out.println("Option Selected by Index");
            }else
            {
                System.out.println("Option is not selected by Index");
            }
        }
    }

    public static boolean selectByValue(WebElement ele, String value){
        boolean flag = false;
        try{
            Select s = new Select(ele);
            s.selectByValue(value);
            flag = true;
            return true;
        }catch (Exception e){
            return false;
        }finally {
            if(flag){
                System.out.println("Option Selected by Value");
            }else
            {
                System.out.println("Option is not selected by Value");
            }
        }
    }

    public static boolean selectByVisibleText(WebElement ele, String visiableText){
        boolean flag = false;
        try{
            Select s = new Select(ele);
            s.selectByVisibleText(visiableText);
            flag = true;
            return true;
        }catch (Exception e){
            return false;
        }finally {
            if(flag){
                System.out.println("Option Selected by visiableText");
            }else
            {
                System.out.println("Option is not selected by visiableText");
            }
        }
    }
    public static boolean mouseHoverByJavaScript(WebElement locator){
        boolean flag = false;
        try{
            WebElement mo = locator;
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public static boolean JSClick(WebDriver ldriver,WebElement ele){
        boolean flag = false;
        try{
            JavascriptExecutor js = (JavascriptExecutor) getdriver();
            js.executeScript("arguments[0].click();",ele);
            flag = true;

        }catch (Exception e){
            throw e;
        }finally {
            if(flag){
                System.out.println("CLick action is performed");
            }else
            {
                System.out.println("CLick action is not performed");
            }
        }
        return flag;
    }

    public static void mouseOverElement(WebElement ele){
        boolean flag = true;
        try{
            new Actions(getdriver()).moveToElement(ele).build().perform();
            flag=true;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(flag){
                System.out.println("MouseOver action is performed");
            }else
            {
                System.out.println("MouseOver action is not performed");
            }
        }
    }

    public static String screenShot(WebDriver driver,String filename){
        String dateName = new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir")+"\\ScreenShots\\" + filename + "_" + dateName + ".png";
                try{
                    FileUtils.copyFile(source,new File(destination));
                } catch (IOException e) {
                    e.getMessage();
                }
        return destination;
    }
}
