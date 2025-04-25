package com.cydeo.utlities;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import java.time.Duration;
import java.util.Set;

public class BrowserUtils {
    public static void sleep(int second) {
        second *= 2000;
        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {

        }

    }

    public static void switchWindowAndVerify(String expectedInUrl, String expectedTitle) {

        Set<String> allWindowHandles = Driver.getDriver().getWindowHandles();
        for (String each : allWindowHandles) {

            Driver.getDriver().switchTo().window(each);
            System.out.println("Current URL: " + Driver.getDriver().getCurrentUrl());

            if (Driver.getDriver().getCurrentUrl().contains(expectedInUrl)) {
                break;
            }
        }
        //Assert: Title contains
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));


    }


    public static void verifyTitle(String expectedTitle) {

        Assert.assertEquals(Driver.getDriver().getTitle(), (expectedTitle));
    }

    public static void verifyTitleContains(String expectedTitle) {
        Assert.assertTrue(Driver.getDriver().getTitle().contains(expectedTitle));
    }

    public static void waitForInvisibilityOf(WebElement target) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(target));
    }

    public static void waitForTitleContains(String title) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains(title));
    }

    public static List<String> dropdownsOptions_as_String(WebElement dropdownElement) {

        Select month = new Select(dropdownElement);
        List<WebElement> actualMonth_asWEBELEMENT = month.getOptions();

        List<String> actualMonth_as_String = new ArrayList<>();

        for (WebElement each : actualMonth_asWEBELEMENT) {

            actualMonth_as_String.add(each.getText());
        }
        return actualMonth_as_String;
    }



    public static void verifyURL(String expectedUrl){
        //1 of method
        //String actualUrl = Driver.getDriver().getCurrentUrl();
        //Assert.assertTrue(actualUrl.contains(expectedUrl));
        //Another method which is shorter
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expectedUrl));
    }

    public static void clickRadioButton(List<WebElement>radioButtons, String attributeValue){
    for(WebElement each: radioButtons){
        if(each.getAttribute("value").equalsIgnoreCase(attributeValue)){
            each.click();
        }
    }
    }

    public static void switchWindow(String targetTitle){
        String original = Driver.getDriver().getWindowHandle();
        for(String handle : Driver.getDriver().getWindowHandles()){
            Driver.getDriver().switchTo().window(handle);
            if(Driver.getDriver().getTitle().equals(targetTitle)){
                return;
            }
        }
        Driver.getDriver().switchTo().window(original);
    }

    public static void hover(WebElement element){
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();
    }

    public static List<String> getElementsText(List<WebElement>list){
        List<String>elemTexts = new ArrayList<>();
        for(WebElement el : list){
            elemTexts.add(el.getText());
        }
        return elemTexts;
    }

    public static List<String> getElementsText(By locator){

        List<WebElement> elems = Driver.getDriver().findElements(locator);
        List<String> elemTexts = new ArrayList<>();

        for (WebElement el :elems){
                 elemTexts.add(el.getText());
        }
        return elemTexts;
    }

    public static void waitFor(int seconds){
        try{
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    public static WebElement waitForVisibility(WebElement element, int time){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForVisibility(By locator, int time){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForClickAbility(WebElement element, int time){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static WebElement waitForClickAbility(By locator, int time){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void waitForPageToLoad(long time){
        ExpectedCondition<Boolean>expectation = new ExpectedCondition<Boolean>(){

            public Boolean apply(WebDriver driver){
                return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(time));
            wait.until(expectation);
        } catch (Throwable error){
            error.printStackTrace();
        }
    }


}

