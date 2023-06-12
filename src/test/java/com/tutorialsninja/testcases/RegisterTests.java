package com.tutorialsninja.testcases;

import com.tutorialsninja.base.TestBase;
import com.tutorialsninja.pages.HomePageBeforeLogin;
import com.tutorialsninja.pages.RegisterPage;
import com.tutorialsninja.utils.DataProviders;
import com.tutorialsninja.utils.Utilities;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class RegisterTests extends TestBase {
    @Test(priority = 1, dataProvider = "Register Data" , dataProviderClass = DataProviders.class)
    public void registeringAnAccountWithMandatoryFields(HashMap<String,String> data)
    {
        HomePageBeforeLogin homePage = new HomePageBeforeLogin(driver);
        homePage.clickRegisterOption();
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.enterAllFields(data);
        registerPage.confirmPrivacyPolicy();
        registerPage.clickContinue();
        String expectedSuccessMessage = "Your Account Has Been Created!";
        Assert.assertEquals(registerPage.getActualSuccessMessage(),expectedSuccessMessage);
    }
}
