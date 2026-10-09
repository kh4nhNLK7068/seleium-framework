package drivers;

import org.openqa.selenium.safari.SafariDriver;

public class SafariDriverManager extends DriverManager {
    @Override 
    public void createDriver() {
        // Implementation for creating Safari WebDriver
        this.driver = new SafariDriver(); // Assuming SafariDriver is imported and available
    }
}
