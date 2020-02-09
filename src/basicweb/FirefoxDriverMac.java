package basicweb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverMac {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "path-to-geckodriver");
        WebDriver driver = new FirefoxDriver();
    }
}
