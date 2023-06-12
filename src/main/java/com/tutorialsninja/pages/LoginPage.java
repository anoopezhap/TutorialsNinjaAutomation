package com.tutorialsninja.pages;

import com.tutorialsninja.base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends PageBase {
    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id ="input-email")
    private WebElement emailAddress;

    @FindBy(id ="input-password" )
    private WebElement password;

    @FindBy(xpath ="//input[@type=\"submit\"]")
    private WebElement login;
    @FindBy(css = "div.alert")
    private WebElement  actualWarningMessage;
    private String successMessageLinkTest = "Edit your account information";

    public void login(String email, String password)
    {
        emailAddress.sendKeys(email);
        this.password.sendKeys(password);
        login.click();
    }
    public void clickLogin()
    {
        login.click();
    }
    public boolean loginValidation()
    {
        return driver.findElement(By.linkText(successMessageLinkTest)).isDisplayed();
    }
    public String getWarningMessage()
    {
        return actualWarningMessage.getText();
    }

}
