package com.pages.actions;

import com.genericUtils.SeleniumHelper;
import com.pages.locators.MyAccountPageLocators;
import com.qa.factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class MyAccountPage extends DriverFactory {
    public MyAccountPageLocators myAccountPageLocators;
    public SeleniumHelper seleniumHelper = new SeleniumHelper();

    public MyAccountPage() {
        myAccountPageLocators = new MyAccountPageLocators();
        PageFactory.initElements(getDriver(), this.myAccountPageLocators);
    }

    public ArrayList<String> myAccountDetails() {
        ArrayList<String> optionNames = new ArrayList<>();

        for (WebElement e : myAccountPageLocators.options) {
            System.out.println(e.getText());
            optionNames.add(e.getText());
        }
        return optionNames;
    }

    public int getOptionsCount() {

        return myAccountPageLocators.options.size();
    }

    public void waitForVisibilityOfMyAccountTab(){
        seleniumHelper.waitForElementExistence(getDriver(), myAccountPageLocators.myAccountTab);
    }
}
