package com.tutorialsninja.testcases;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tutorialsninja.base.TestBase;
import com.tutorialsninja.pages.HomePageBeforeLogin;
import com.tutorialsninja.pages.LoginPage;
import com.tutorialsninja.utils.DataProviders;
import com.tutorialsninja.utils.Utilities;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class LoginTests extends TestBase {


    @Test(priority = 1, dataProvider = "Valid LogIn Data", dataProviderClass = DataProviders.class)
    public void verifyloginWithValidCredentials(String[] login) {
        HomePageBeforeLogin homePage = new HomePageBeforeLogin(driver);
        homePage.clickLoginOption();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(login[0], login[1]);
        Assert.assertTrue(loginPage.loginValidation());
    }


    @Test(priority = 2)

    public void verifyloginWithInvalidCredentials() {
        HomePageBeforeLogin homePage = new HomePageBeforeLogin(driver);
        homePage.clickLoginOption();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(Utilities.generateEmailWithTimeStamp(), "vispedafsgardi@gufum.com");
        String actualWarningMessage = "Warning: No match for E-Mail Address and/or Password.";
        Assert.assertEquals(actualWarningMessage, loginPage.getWarningMessage());
    }

    @Test(priority = 3)
    public void verifyloginWithInvalidEmailAndValidPassword() {
        HomePageBeforeLogin homePage = new HomePageBeforeLogin(driver);
        homePage.clickLoginOption();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(Utilities.generateEmailWithTimeStamp(), "vispegardi@gufum.com");
        String actualWarningMessage = "Warning: No match for E-Mail Address and/or Password.";
        Assert.assertEquals(actualWarningMessage, loginPage.getWarningMessage());
    }

    @Test(priority = 4)
    public void verifyloginWithValidEmailAndInvalidPassword() {
        HomePageBeforeLogin homePage = new HomePageBeforeLogin(driver);
        homePage.clickLoginOption();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("vispegardi@gufum.com", "123vispegardi@gufum.com");
        String actualWarningMessage = "Warning: No match for E-Mail Address and/or Password.";
        Assert.assertEquals(actualWarningMessage, loginPage.getWarningMessage());
    }

    @Test(priority = 5)
    public void verifyLoginWithoutProvidingCredentials() {
        HomePageBeforeLogin homePage = new HomePageBeforeLogin(driver);
        homePage.clickLoginOption();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLogin();
        String actualWarningMessage = "Warning: No match for E-Mail Address and/or Password.";
        Assert.assertEquals(actualWarningMessage, loginPage.getWarningMessage());
    }
}
