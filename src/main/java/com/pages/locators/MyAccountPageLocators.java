package com.pages.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class MyAccountPageLocators {

    @FindBy(xpath = "//div[@class='col-xs-12 col-sm-6 col-lg-4']//span")
    public List<WebElement> options;

    @FindBy(xpath =  "//span[text()='My account']")
    public WebElement myAccountTab;
}
