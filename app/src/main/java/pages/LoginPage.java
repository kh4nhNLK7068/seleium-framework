package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends CommonPage {
    // Thuoc tinh (private) - encapsulation
    private By byTxtUserLogin;
    private By byTxtPasswordLogin;
    private By byBtnLogin;
    private By byLblLoginSuccess;

    public LoginPage(WebDriver driver) {
        super(driver);
        // Initialize locators
        byTxtUserLogin = By.id("taiKhoan");
        byTxtPasswordLogin = By.id("matKhau");
        byBtnLogin = By.xpath("//button[@type='submit' and .//span[normalize-space()='Đăng nhập']]");
        byLblLoginSuccess = By.id("swal2-title");
    }

    // Phuong thuc (public) - encapsulation
    public void enterAccount(String account) {
        // Enter user login
        sendKeys(byTxtUserLogin, account);
    }

    public void enterPassword(String password) {
        // Enter password login
        sendKeys(byTxtPasswordLogin, password);
    }

    public void clickLoginButton() {
        // Click 'Dang Nhap' button
        click(byBtnLogin);
    }

    public String getLoginSuccessMessage() {
        // Verify login successfully
        return getText(byLblLoginSuccess);
    }

    // High-level method that combines the steps for logging in
    public void login(String account, String password) {
        enterAccount(account);
        enterPassword(password);
        clickLoginButton();
    }
}
