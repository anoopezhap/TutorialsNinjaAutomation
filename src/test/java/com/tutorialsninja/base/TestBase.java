package com.tutorialsninja.base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public abstract class TestBase {
    public  WebDriver driver;

    public static Properties prop;
    @BeforeSuite
    public void loadPropertiesFile()
    {
        prop = new Properties();
        File file = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\config\\config.properties");
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        try {
            prop.load(fis);
        } catch (IOException e) {
            System.out.println("file not loaded");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public WebDriver initializeBrowser()
    {
        String browser = prop.getProperty("browser");
        if(browser.equalsIgnoreCase("chrome"))
        {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox"))
        {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge"))
        {
            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver;
    }

    @BeforeMethod(alwaysRun = true)
    public void openBrowserWithUrl()
    {
        driver = initializeBrowser();
        driver.get(prop.getProperty("url"));

    }

    @AfterMethod(alwaysRun = true)
    public void teardown()
    {
        driver.quit();
    }

    public String getScreenshot(String testName, WebDriver driver)
    {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenshot = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String screenshotPath = System.getProperty("user.dir")+"/screenshot/" + testName +".png";
        File file = new File(screenshotPath);

        try {
            FileUtils.copyFile(screenshot,file);
        } catch (Exception e) {
            System.out.println("Takes Screenshot is null");
            e.printStackTrace();
        }
        return file.getAbsolutePath();

    }

}
