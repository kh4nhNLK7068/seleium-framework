package testcases;

import java.time.Duration;
import java.util.UUID;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import base.BaseTest;

import org.testng.Assert;

import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;

public class TC01_Register extends BaseTest {
    // .\gradlew.bat test --tests "testcases.TC01_Register"
    @Test
    public void TC01_Verify_Register_Successfully() throws InterruptedException {
        // Khai báo FluentWait 10s
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(Exception.class);

        try {
            // Open website
            driver.get("https://demo1.cybersoft.edu.vn"); //homepage
            Thread.sleep(2000);

            HomePage homePage = new HomePage(driver);
            LoginPage loginPage = new LoginPage(driver);
            RegisterPage registerPage = new RegisterPage(driver);

            // Pre-condition: Navigate to Register page (Navigate to Register page)
            homePage.getTopNavigationBar().navigateToRegisterPage();

            // quit (temporary) - to avoid "ElementClickInterceptedException: element click intercepted" error
            // Thread.sleep(2000);
            // driver.quit();

            // Step 1: Enter account
            //By byAccountTextbox = By.id("taiKhoan");
            //WebElement accountTextbox = wait.until(ExpectedConditions.visibilityOfElementLocated(byAccountTextbox));

            String account = UUID.randomUUID().toString();
            String email = account + "@example.com";
            System.out.println("Account: " + account);
            System.out.println("Email: " + email);

            // accountTextbox.sendKeys(account);
            registerPage.enterAccount(account);

            // Step 2: Enter password
            // By byTxtPassword = By.name("matKhau");
            // WebElement txtPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(byTxtPassword));

            // txtPassword.sendKeys("123456");
            registerPage.enterPassword("123456");

            // Step 3: Re-enter password
            // By byTxtConfirmPassword = By.id("confirmPassWord");
            // WebElement txtConfirmPassword = wait
            //         .until(ExpectedConditions.visibilityOfElementLocated(byTxtConfirmPassword));

            // txtConfirmPassword.sendKeys("123456");
            registerPage.enterConfirmPassword("123456");

            // Step 4: Enter full name
            // By byTxtFullname = By.id("hoTen");
            // WebElement txtFullName = wait.until(ExpectedConditions.visibilityOfElementLocated(byTxtFullname));

            // txtFullName.sendKeys("John Johnson");
            registerPage.enterFullName("John Johnson");

            // Step 5: Enter email
            // By byTxtEmail = By.id("email");
            // WebElement txtEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(byTxtEmail));

            // txtEmail.sendKeys(email);
            registerPage.enterEmail(email);

            // Step 6: Click Register
            // By byBtnRegister = By.xpath("//button[span[text()='Đăng ký']]");
            // WebElement btnRegister = wait.until(ExpectedConditions.elementToBeClickable(byBtnRegister));
            // btnRegister.click();
            registerPage.clickRegisterButton();

            // Step 7: Verify success message
            // VP1 (Verify Point): Veryfi 'Dang ky thanh cong' message is displayed
            // By byLblLoginSuccess = By.id("swal2-title");
            // WebElement lblLoginSuccess = wait.until(ExpectedConditions.visibilityOfElementLocated(byLblLoginSuccess));
            // String actualLoginMsg = lblLoginSuccess.getText();
            // Assert.assertEquals(actualLoginMsg, "Đăng ký thành công", "Login Successful Message");
            String actualRegisterMsg = registerPage.getRegisterSuccessMessage();
            Assert.assertEquals(actualRegisterMsg, "Đăng ký thành công", "Register Successful Message");

            // VP2: Verify 'Đăng nhập' button is displayed
            // 1. Click 'Dang Nhap' Link
            // By byLnkLogin = By.xpath("//a[h3 [text()= 'Đăng Nhập' ]]");
            // WebElement LnkLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(byLnkLogin));
            // LnkLogin.click();
            registerPage.getTopNavigationBar().navigateToLoginPage();

            // 2. Enter user login
            // By byTxtUserLogin = By.id("taiKhoan");
            // WebElement txtUserLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(byTxtUserLogin));
            // txtUserLogin.sendKeys("john_doe");
            loginPage.enterAccount(account);

            // 3. Enter password login
            // By byTxtPasswordLogin = By.id("matKhau");
            // WebElement txtPasswordLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(byTxtPasswordLogin));
            // txtPasswordLogin.sendKeys("123456");
            loginPage.enterPassword("123456");

            // 4. Click 'Dang Nhạp'
            // By byBtnLogin = By.xpath("//button[span[text()='Đăng nhập']]");
            // WebElement btnLogin = wait.until(ExpectedConditions.elementToBeClickable(byBtnLogin));
            // btnLogin.click();
            loginPage.clickLoginButton();

            // VP: Verify 'Dang phap thanh cong' message displays
            // By byLblLoginSuccessMsg = By.id("swal2-title");
            // WebElement lblLoginSuccessMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(byLblLoginSuccessMsg));
            // String actualLoginSuccessMsg = lblLoginSuccessMsg.getText();
            // Assert.assertEquals(actualLoginSuccessMsg, "Đăng nhập thành công", "Login Successful Message");
            String actualLoginSuccessMsg = loginPage.getLoginSuccessMessage();
            Assert.assertEquals(actualLoginSuccessMsg, "Đăng nhập thành công", "Login Successful Message");
        } finally {
            
        }
    }
}
