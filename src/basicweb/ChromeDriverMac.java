package basicweb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverMac {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",
                "/Users/irinagolovko/Desktop/selenium-java-3.141/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        String baseURL = "http://www.letskodeit.com";
        driver.get(baseURL);

    }
}
