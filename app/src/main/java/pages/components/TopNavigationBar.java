package pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pages.BasePage;


/**
 * Represents the top navigation bar component of the application.
 * Purpose: This class encapsulates the behavior and elements of the top navigation bar, providing methods to navigate to the Register and Login pages.
 * If modified, it will affect all test cases that rely on the top navigation bar for navigation.
 * It uses Selenium WebDriver to interact with the web elements and WebDriverWait for explicit waits
 */
public class TopNavigationBar extends BasePage {
    private By byLnkRegister;
    private By byLnkLogin;
    private WebDriver driver;

    public TopNavigationBar(WebDriver driver) {
        super(driver);
        this.driver = driver;
        byLnkLogin = By.xpath("//a[h3[text()='Đăng Nhập']]");
        byLnkRegister = By.xpath("//a[h3[text()='Đăng Ký']]");
    }

    public void navigateToRegisterPage() {
        click(byLnkRegister);
    }

    public void navigateToLoginPage() {
        click(byLnkLogin);
    }
}
