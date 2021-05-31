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
    public void waitForElementToBeClickable(WebDriver driver, WebElement webElement) {
        try {
            WebDriverWait webDriverWait = new WebDriverWait(driver, 120);
            webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("The element is not there");
        }
    }

    public void enterKeys(WebDriver driver, WebElement webElement, String value)
    {
        try {
            waitForElementExistence(driver, webElement);
            webElement.sendKeys(value);
        }
        catch (Exception e)
        {
            System.out.println("Failed to enter "+value+" to the element.");
        }

    }

    public void click(WebDriver driver, WebElement webElement)
    {
        try {
            waitForElementToBeClickable(driver, webElement);
            webElement.click();
        }
        catch (Exception e)
        {
            System.out.println("Failed to click the element.");
        }

    }

    public String getPageTitle(WebDriver driver)
    {
        try {
            System.out.println("Title of the page is: "+driver.getTitle());

        }
        catch (Exception e)
        {
            System.out.println("Failed get title of the page.");
        }
        return driver.getTitle();
    }

    public boolean isEelementDisplayed(WebDriver driver, WebElement webElement)
    {
        try {
            waitForElementExistence(driver,webElement);

        }
        catch (NoSuchElementException noSuchElementException)
        {
            System.out.println("The element is not there");
        }

        return webElement.isDisplayed();
    }
}
