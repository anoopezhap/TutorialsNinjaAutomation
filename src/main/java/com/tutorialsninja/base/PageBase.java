package com.tutorialsninja.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class PageBase {
    public WebDriver driver;
    public WebDriverWait wait;
    public PageBase(WebDriver driver)
    {
        this.driver=driver;
    }

    public void waitForElementToBeVisible(int seconds, By by)
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}
