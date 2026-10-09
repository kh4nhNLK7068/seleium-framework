package drivers;

import org.openqa.selenium.edge.EdgeDriver;

public class EdgeDriverManager extends DriverManager {
    @Override
    public void createDriver() {
        // Implementation for creating Edge WebDriver
        this.driver = new EdgeDriver(); // Uncomment and implement as needed
    }
    
}
