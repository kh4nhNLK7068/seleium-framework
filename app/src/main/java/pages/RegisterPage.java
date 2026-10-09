package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class RegisterPage extends CommonPage {

    private By byAccountTextbox;
    private By byPasswordTextbox;
    private By byConfirmPasswordTextbox;
    private By byFullNameTextbox;
    private By byEmailTextbox;
    private By byRegisterButton;
    private By byRegisterSuccessMessage;
    private WebDriver driver;
    
    public RegisterPage(WebDriver driver) {
        super(driver);
        this.byAccountTextbox = By.id("taiKhoan");
        this.byPasswordTextbox = By.id("matKhau");
        this.byConfirmPasswordTextbox = By.id("confirmPassWord");
        this.byFullNameTextbox = By.id("hoTen");
        this.byEmailTextbox = By.id("email");
        this.byRegisterButton = By.xpath("//button[span[text()='Đăng ký']]");
        this.byRegisterSuccessMessage = By.id("swal2-title");
    }

    public void enterAccount(String account) {
        sendKeys(byAccountTextbox, account);
    }

    public void enterPassword(String password) {
        sendKeys(byPasswordTextbox, password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        sendKeys(byConfirmPasswordTextbox, confirmPassword);
    }

    public void enterFullName(String fullName) {
        sendKeys(byFullNameTextbox, fullName);
    }

    public void enterEmail(String email) {
        sendKeys(byEmailTextbox, email);
    }

    public void clickRegisterButton() {
        click(byRegisterButton);
    }

    public String getRegisterSuccessMessage() {
        return getText(byRegisterSuccessMessage);
    }

    public void waitDialogToDisappear() {
        waitInvisibilityOfElementLocated(byRegisterSuccessMessage);
    }
}
