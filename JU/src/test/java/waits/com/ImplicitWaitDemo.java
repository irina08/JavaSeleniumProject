package waits.com;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ImplicitWaitDemo {
    private WebDriver driver;
    private String baseUrl;

    @BeforeEach
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://letskodeit.teachable.com/pages/practice";

        // Maximize the browser's window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test()
    public void test() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.linkText("Login")).click();

        driver.findElement(By.id("user_email")).sendKeys("test");
    }

    @AfterEach
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.quit();
    }
}

