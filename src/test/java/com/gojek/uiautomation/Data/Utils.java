package com.gojek.uiautomation.Data;

import net.thucydides.core.pages.PageObject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Utils extends PageObject {

    public static void waitAWhile(int waitTime) {
        try {
            Thread.sleep(waitTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void waitABit(int waitTimeInMS) {
        WebDriver driver = super.getDriver();
        driver.manage().timeouts().implicitlyWait(waitTimeInMS, TimeUnit.MILLISECONDS);
    }

    public Action performAction(WebElement element, String keys) {
        Actions builder = new Actions(super.getDriver());
        Action mouseOverAction = builder
                .sendKeys(element,keys)
                .build();
        return mouseOverAction;
    }

    public void switchFrames(WebDriver driver,int count){
        driver.switchTo().frame(count);
    }
}
