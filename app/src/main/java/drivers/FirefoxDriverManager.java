package drivers;

import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverManager extends DriverManager {
    @Override
    public void createDriver() {
        // Implementation for creating Firefox WebDriver
        this.driver = new FirefoxDriver(); // Uncomment and implement as needed
    }
    
}
