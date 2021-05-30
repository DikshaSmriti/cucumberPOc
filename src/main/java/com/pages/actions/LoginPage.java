package com.pages.actions;

import com.genericUtils.SeleniumHelper;
import com.pages.locators.LoginPageLocators;
import com.qa.factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends DriverFactory {

    public LoginPageLocators loginPageLocators;

     public LoginPage() {

        this.loginPageLocators = new LoginPageLocators();
        PageFactory.initElements(getDriver(), this.loginPageLocators);
    }

    public String getPageTitle() {

        return getDriver().getTitle();
    }

    public boolean isForgotPwdLinkExist() {

        return loginPageLocators.forgotPwdLink.isDisplayed();
    }

    public void enterUserName(String username) {

        loginPageLocators.emailAddressTextBox.sendKeys(username);
    }

    public void enterPassword(String pwd) {
        loginPageLocators.password.sendKeys(pwd);

    }

    public void clickOnLogin() {

        loginPageLocators.signInButton.click();

    }

    public void doLogin(String userName, String pwd) {
        System.out.println("username is: "+userName);
        System.out.println("password is: "+pwd);
        System.out.println("loginPageLocators is: "+loginPageLocators);
        SeleniumHelper seleniumHelper=new SeleniumHelper();
        seleniumHelper.waitForElementExistence(getDriver(),  loginPageLocators.emailAddressTextBox);
        loginPageLocators.emailAddressTextBox.sendKeys(userName);
        loginPageLocators.password.sendKeys(pwd);
        loginPageLocators.signInButton.click();
//        return new MyAccountPage(driver);
    }


}
