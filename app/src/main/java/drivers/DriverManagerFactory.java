package drivers;

public class DriverManagerFactory {
    public static DriverManager getDriverManager(String browserType) {
        switch (browserType.toLowerCase()) {
            case "chrome":
                return new ChromeDriverManager();
            case "firefox":
                return new FirefoxDriverManager();
            case "edge":
                return new EdgeDriverManager();
            case "safari":
                return new SafariDriverManager();
            default:
                throw new IllegalArgumentException("Unsupported browser type: " + browserType);
        }
    }
}
