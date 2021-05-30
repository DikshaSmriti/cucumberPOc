package com.genericUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumHelper
{

    public void waitForElementExistence(WebDriver driver, WebElement webElement)
    {
        try {
            WebDriverWait webDriverWait = new WebDriverWait(driver, 120);
            webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
        }
        catch (NoSuchElementException noSuchElementException)
        {
            System.out.println("The element is not there");
        }

    }



}
