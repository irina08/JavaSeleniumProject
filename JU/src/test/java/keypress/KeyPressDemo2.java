package keypress;

import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class KeyPressDemo2 {
    private WebDriver driver;
    private String baseUrl;

    @BeforeEach
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://letskodeit.teachable.com/p/practice";

        // Maximize the browser's window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testKeyPress() throws Exception {
        driver.get(baseUrl);
        //driver.findElement(By.id("openwindow")).sendKeys(Keys.COMMAND + "a");
        Thread.sleep(2000);
        //driver.findElement(By.id("openwindow")).sendKeys(Keys.chord(Keys.COMMAND, "a"));
        //Thread.sleep(2000);
        String selectAll = Keys.chord(Keys.COMMAND, "a");
        driver.findElement(By.id("openwindow")).sendKeys(selectAll);
        Thread.sleep(4000);
    }

    @AfterEach
    public void tearDown() throws Exception {
        driver.quit();
    }
}