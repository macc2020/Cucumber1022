package com.hiyar1.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class BrowserUtils {
    private static WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);

    public static void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void clickOnElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public static void clickWithJS(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        ((JavascriptExecutor) (Driver.getDriver())).executeScript("arguments[0].click()", element);
    }

    public static void enterText(WebElement element, String text){
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
        wait.until(ExpectedConditions.attributeToBe(element, "value", text));
        System.out.println("Entering text: " + text);
    }

    /**
     * For instance, selenium webdriver is trying to enter the text:
     * Expected text input  actual text input
     *
     * [java is great] --> [java is g]
     *
     * for some reason, selenium jumps to the next step without finishing text input here
     *
     * to prevent this issue, we need to make it wait until text is completely entered.
     *
     * How to do that?
     *
     * As we know, text is stored in the value attribute. So we need to wait until value attribute
     * of the element will obtain expected text.
     */
    public static List<String> getElementsText(List<WebElement> list){

        List<String> webelementsAsString = new ArrayList<>();

        for (WebElement each : list) {
            webelementsAsString.add(each.getText());
        }
        return webelementsAsString;

    }


    /*
    Create a utility method named: wait
    static method
    @param sec
    @return void
    The integer number that I pass as parameter should be accepted as SECONDS
    Handle checked exception with try/catch
     */
public static WebElement waitForClickAbility(WebElement element,int timeout){
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),timeout);
    return wait.until(ExpectedConditions.elementToBeClickable(element));
}

    public static WebElement waitForVisibility(WebElement element,int timeToWaitInSecond){

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),timeToWaitInSecond);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static WebElement waitForVisibility(By locator,int timeOut){

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),timeOut);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


}
