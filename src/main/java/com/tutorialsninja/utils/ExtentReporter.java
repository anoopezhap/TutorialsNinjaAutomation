package com.tutorialsninja.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ExtentReporter {

    public static ExtentReports generateExtentReport()  {
        ExtentReports extentReports = new ExtentReports();
        File extentReportFile = new File(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html");
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);

        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setReportName("TutorialsNinja Test Automation Results");
        sparkReporter.config().setDocumentTitle("TN Automation Report");
        sparkReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");

        extentReports.attachReporter(sparkReporter);

        Properties configProp = new Properties();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("C:\\Users\\anoop\\IdeaProjects\\QAGURU\\TutorialsNinjaProject\\src\\main\\java\\com\\tutorialsninja\\config\\config.properties");
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            throw new RuntimeException(e);
        }
        try {
            configProp.load(fis);
        } catch (IOException e) {
            System.out.println("File not found");
            throw new RuntimeException(e);
        }

        extentReports.setSystemInfo("Application URL" ,configProp.getProperty("url") );
        extentReports.setSystemInfo("Browser Name" , configProp.getProperty("browser"));
        extentReports.setSystemInfo("Operation System" , System.getProperty("os.name"));
        extentReports.setSystemInfo("User Namer" , System.getProperty("user.name"));
        extentReports.setSystemInfo("JAVA Version" , System.getProperty("java.version"));

        return extentReports;

    }
}
