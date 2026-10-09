package base;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import drivers.DriverManagerFactory;
import reports.ExtentReportManager;

import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

import drivers.DriverManager;

public class BaseTest {

    protected WebDriver driver;
    protected Logger logger = LogManager.getLogger(getClass());


    @BeforeSuite 
    public void beforeSuite() {
        logger.info("Before Suite: Setting up test suite");
        // Any setup that needs to be done before the entire test suite runs
        ExtentReportManager.initializeExtentReports();
    }

    @BeforeTest 
    public void beforeTest() {
        logger.info("Before Test: Setting up test");
        // Any setup that needs to be done before each test
    }

    @BeforeMethod
    public void beforeMethod(Method method) {
        logger.info("Setting up WebDriver before the test method");
        ExtentReportManager.createTest(method.getName());
        DriverManager driverManager = DriverManagerFactory.getDriverManager("edge");
        driverManager.createDriver();
        this.driver = driverManager.getDriver();
        this.driver.manage().window().maximize();
    }

    @AfterMethod 
    public void afterMethod(ITestResult result) {
        logger.info("Cleaning up after the test method");
        if(result.getStatus() == ITestResult.FAILURE) {
            ExtentReportManager.fail("Test Failed: " + result.getThrowable());
            ExtentReportManager.captureScreenshot(driver, result.getName());
        } else if(result.getStatus() == ITestResult.SUCCESS) {
            ExtentReportManager.pass("Test Passed");
        } else if(result.getStatus() == ITestResult.SKIP) {
            ExtentReportManager.info("Test Skipped: " + result.getThrowable());
        }
        
        if (this.driver != null) {
            this.driver.quit();
        }
    }

    @AfterTest 
    public void afterTest() {
        logger.info("After Test: Cleaning up test");
        // Any cleanup that needs to be done after each test
    }

    @AfterSuite 
    public void afterSuite() {
        logger.info("After Suite: Cleaning up test suite");
        ExtentReportManager.flushReports();
        // Any cleanup that needs to be done after the entire test suite runs
    }
}
