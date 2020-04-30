package element.com;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GetTextDemo {

    private WebDriver driver;
    private String baseUrl;

    @BeforeEach
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://letskodeit.teachable.com/pages/practice";

        // Maximize the browser's window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testGetText() throws Exception {
        driver.get(baseUrl);

        WebElement buttonElement = driver.findElement(By.id("opentab"));
        String elementText = buttonElement.getText();

        System.out.println("Text on the element is: " + elementText);
    }

    @AfterEach
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }
}
