package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import constants.ConstantTimeOut;

public class BasePage {

    private WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriverWait getWebDriverWait(long timeoutInSeconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
    }

    public WebElement waitForElementVisible(By locator, long timeoutInSeconds) {
        WebDriverWait wait = getWebDriverWait(timeoutInSeconds);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForElementVisible(By locator) {
        return waitForElementVisible(locator, ConstantTimeOut.TIMEOUT_IN_SECONDS);
    }

    public WebElement waitForElementClickable(By locator, long timeoutInSeconds) {
        WebDriverWait wait = getWebDriverWait(timeoutInSeconds);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement waitForElementClickable(By locator) {
        return waitForElementClickable(locator, ConstantTimeOut.TIMEOUT_IN_SECONDS);
    }

    public boolean waitInvisibilityOfElementLocated(By locator, long timeoutInSeconds) {
        WebDriverWait wait = getWebDriverWait(timeoutInSeconds);
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public boolean waitInvisibilityOfElementLocated(By locator) {
        return waitInvisibilityOfElementLocated(locator, ConstantTimeOut.TIMEOUT_IN_SECONDS);
    }

    public void sendKeys(By locator, String value, long timeoutInSeconds) {
        // Method to send keys to an element
        WebElement element = waitForElementVisible(locator, timeoutInSeconds);
        element.sendKeys(value);
    }

    public void sendKeys(By locator, String value) {
        // Method to send keys to an element
        sendKeys(locator, value, ConstantTimeOut.TIMEOUT_IN_SECONDS);
    }

    public void click(By locator, long timeoutInSeconds) {
        // Method to click an element
        WebElement element = waitForElementVisible(locator, timeoutInSeconds);
        element.click();
    }

    public void click(By locator) {
        // Method to click an element
        click(locator, ConstantTimeOut.TIMEOUT_IN_SECONDS);
    }

    public String getText(By locator, long timeoutInSeconds) {
        // Method to get text from an element
        WebElement element = waitForElementVisible(locator, timeoutInSeconds);
        return element.getText();
    }

    public String getText(By locator) {
        // Method to get text from an element
        return getText(locator, ConstantTimeOut.TIMEOUT_IN_SECONDS);
    }
}
