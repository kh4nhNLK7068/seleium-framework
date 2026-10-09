package drivers;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager extends DriverManager {
    @Override
    public void createDriver() {
        // Implementation for creating Chrome WebDriver
        ChromeOptions options = new ChromeOptions();

        // remove the "Chrome is being controlled by automated test software" notification
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);
        
        this.driver = new ChromeDriver(options); // Uncomment and implement as needed
    }
    
}
