package base;

import org.testng.annotations.BeforeMethod;

import drivers.DriverManagerFactory;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

import drivers.DriverManager;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Setting up preconditions for the test method");
        DriverManager driverManager = DriverManagerFactory.getDriverManager("edge");
        driverManager.createDriver();
        this.driver = driverManager.getDriver();
        this.driver.manage().window().maximize();
    }

    @AfterMethod 
    public void afterMethod() {
        System.out.println("Cleaning up after the test method");
        if (this.driver != null) {
            this.driver.quit();
        }
    }
}
