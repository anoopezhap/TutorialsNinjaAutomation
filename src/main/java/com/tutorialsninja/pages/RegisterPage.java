package com.tutorialsninja.pages;

import com.tutorialsninja.base.PageBase;
import com.tutorialsninja.utils.Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;

public class RegisterPage extends PageBase {
    public WebDriver driver;

    public RegisterPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="input-firstname")
    private WebElement firstName;
    @FindBy(id="input-lastname")
    private WebElement lastName;

    @FindBy(id="input-email")
    private WebElement email;

    @FindBy(id="input-telephone")
    private WebElement telephone;

    @FindBy(id="input-password")
    private WebElement password;

    @FindBy(id="input-confirm")
    private WebElement passwordConfirm;

    @FindBy(xpath = "//input[@name=\"agree\"]")
    private  WebElement confirm;

    @FindBy(xpath ="//input[@value=\"Continue\"]" )
    private WebElement register;

    @FindBy(css = "div#content h1")
    private WebElement actualSuccessMessage;

    @FindBy(linkText ="Continue" )
    private WebElement proceed;


    public void enterAllFields(HashMap<String,String> data)
    {
        firstName.sendKeys(data.get("First Name"));
        lastName.sendKeys(data.get("Last Name"));
        email.sendKeys(Utilities.generateEmailWithTimeStamp());
        telephone.sendKeys(data.get("Telephone"));
        password.sendKeys(data.get("Password"));
        passwordConfirm.sendKeys(data.get("Password"));
    }
    public void confirmPrivacyPolicy()
    {
        confirm.click();
    }
    public void clickContinue()
    {
        register.click();
    }
    public String getActualSuccessMessage()
    {
        String actualSuccessMessage =  this.actualSuccessMessage.getText();
        proceed.click();
        return actualSuccessMessage;
    }


}
