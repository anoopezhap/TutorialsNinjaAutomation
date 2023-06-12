package com.tutorialsninja.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.tutorialsninja.utils.ExtentReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import com.tutorialsninja.base.*;


public class MyListeners extends TestBase  implements ITestListener {


    ExtentReports extentReport;
    ExtentTest extentTest;
    @Override
    public void onStart(ITestContext context) {

        extentReport =  ExtentReporter.generateExtentReport();
    }

    @Override
    public void onTestStart(ITestResult result)
    {
        String testName = result.getMethod().getMethodName();
        extentTest = extentReport.createTest(testName);
        extentTest.log(Status.INFO,testName + " Started Executing");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        extentTest.log(Status.PASS,testName + " got successfully executed");

    }

    @Override
    public void onTestFailure(ITestResult result) {

        String testName = result.getMethod().getMethodName();
        try {
              driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
                //driver = (WebDriver) result.getTestContext().getAttribute("driver");
        } catch (Exception e) {
            System.out.println("driver not found");
            e.printStackTrace();
        }

        String screenshotPath = getScreenshot(testName,driver);
        extentTest.addScreenCaptureFromPath(screenshotPath,testName);
        extentTest.log(Status.INFO,result.getThrowable());
        extentTest.log(Status.FAIL,testName + " got failed");

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        String testName = result.getMethod().getMethodName();

       extentTest.log(Status.INFO,result.getThrowable());
       extentTest.log(Status.SKIP,testName + "got skipped" );

    }
    @Override
    public void onFinish(ITestContext context) {

        extentReport.flush();
        String pathOfReport = System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html";
        File report = new File(pathOfReport);
        try {
            Desktop.getDesktop().browse(report.toURI());
        } catch (Exception e) {
            System.out.println("Brower not opened");
            e.printStackTrace();
        }

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }


}
