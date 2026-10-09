package testcases;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

import base.BaseTest;

import org.testng.Assert;

import pages.LoginPage;
import pages.HomePage;

public class TC02_Login extends BaseTest {

    @Test
    public void TC02_Verify_Login_Successfully() {
        //khai bao explictit wait
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(Exception.class);

        driver.manage().window().maximize(); // maximize browser
        driver.get("https://demo1.cybersoft.edu.vn"); // homepage

        String account = "50a4dea9-1f49-4d51-8df7-8058ab3eea39";
        String password = "123456";

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        //Pre-condition: Navigate to Login page (Navigate to Login page)
        homePage.getTopNavigationBar().navigateToLoginPage();

        // Step 1. Enter user login
        // By byTxtUserLogin = By.id("taikhoan");
        // WebElement txtUserLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(byTxtUserLogin));
        // txtUserLogin.sendKeys(account);
        loginPage.enterAccount(account);

        // Step 2. Enter password login
        // By byTxtPasswordLogin = By.id("matKhay");
        // WebElement txtPasswordLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(byTxtPasswordLogin));
        // txtPasswordLogin.sendKeys("123456");
        loginPage.enterPassword(password);

        // Step 3. Click 'Dang NhaR'
        // By byBtnLogin = By.xpath("//button [span[text() = 'Đặng nhập']]");
        // WebElement btnLogin = wait.until(ExpectedConditions.elementToBeClickable(byBtnLogin));
        // btnLogin.click();
        loginPage.clickLoginButton();

        // Step 4: Verify login successfully
        // VP: Verify 'Dang nhap thanh cong' message displays
        // By byLblLoginSuccess = By.id("swal2-title");
        // WebElement lblLoginSuccess = wait.until(ExpectedConditions.visibilityOfElementLocated(byLblLoginSuccess));
        // String actualLoginMsg = lblLoginSuccess.getText();
        // Assert.assertEquals(actualLoginMsg, "Đăng nhập thành công", "Login Successful Message");
        String actualLoginMsg = loginPage.getLoginSuccessMessage();
        Assert.assertEquals(actualLoginMsg, "Đăng nhập thành công", "Login Successful Message");

        // VP: User displays on the top right corner
        By byLblUser = By.xpath("//div[@class='user-info']/span");
        WebElement lblUser = wait.until(ExpectedConditions.visibilityOfElementLocated(byLblUser));
        String actualUser = lblUser.getText();
        Assert.assertEquals(actualUser, account, "User displays on the top right corner");
    }
}
