package com.tutorialsninja.pages;

import com.tutorialsninja.base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageBeforeLogin extends PageBase {
    public WebDriver driver;
    public HomePageBeforeLogin(WebDriver driver)
    {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath="//a[@title=\"My Account\"]")
    private WebElement myAccountDropDownMenu;

    @FindBy(xpath = "//a[text()=\"Login\"]")
    private WebElement loginOption;

    @FindBy(linkText = "Register")
    private WebElement registerOption;



    public void naviateToMyAccount()
    {
        myAccountDropDownMenu.click();
    }
    public void clickLoginOption()
    {
        naviateToMyAccount();
        loginOption.click();
    }
    public void clickRegisterOption()
    {
        naviateToMyAccount();
        registerOption.click();
    }

}
