package com.pages.actions;

import com.genericUtils.SeleniumHelper;
import com.pages.locators.LoginPageLocators;
import com.qa.factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends DriverFactory {

    public LoginPageLocators loginPageLocators;
    private SeleniumHelper seleniumHelper = new SeleniumHelper();

    public LoginPage() {
        this.loginPageLocators = new LoginPageLocators();
        PageFactory.initElements(getDriver(), this.loginPageLocators);
    }

    public String getPageTitle() {

        return seleniumHelper.getPageTitle(getDriver());
    }

    public boolean isForgotPwdLinkExist() {
        return seleniumHelper.isEelementDisplayed(getDriver(), loginPageLocators.forgotPwdLink);
    }

    public void enterUserName(String username) {

        seleniumHelper.enterKeys(getDriver(),loginPageLocators.emailAddressTextBox,username);
    }

    public void enterPassword(String pwd) {

        seleniumHelper.enterKeys(getDriver(),loginPageLocators.password,pwd);

    }

    public void clickOnLogin() {
        seleniumHelper.click(getDriver(),loginPageLocators.signInButton);


    }

    public void doLogin(String userName, String pwd) {
        System.out.println("username is: " + userName);
        System.out.println("password is: " + pwd);
        System.out.println("loginPageLocators is: " + loginPageLocators);
        seleniumHelper.enterKeys(getDriver(),loginPageLocators.emailAddressTextBox,userName);
        seleniumHelper.enterKeys(getDriver(),loginPageLocators.password,pwd);
        seleniumHelper.click(getDriver(),loginPageLocators.signInButton);
//        return new MyAccountPage(driver);
    }


}
