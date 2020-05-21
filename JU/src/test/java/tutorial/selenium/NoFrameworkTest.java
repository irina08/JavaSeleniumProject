package tutorial.selenium;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NoFrameworkTest {
    private WebDriver driver;
    private String baseUrl;

    @BeforeEach
    public void beforeClass() {
        driver = new FirefoxDriver();
        baseUrl = "https://www.expedia.com/";

        // Maximize the browser's window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @Test
    public void test() {
        driver.findElement(By.id("header-history")).click();
        driver.findElement(By.id("tab-flight-tab")).click();
        driver.findElement(By.id("flight-origin")).sendKeys("New York");
        driver.findElement(By.id("flight-destination")).sendKeys("Chicago");
        driver.findElement(By.id("flight-departing")).sendKeys("10/28/2014");
        driver.findElement(By.id("flight-returning")).sendKeys("10/31/2014");
        driver.findElement(By.id("search-button")).click();
    }

    @AfterEach
    public void afterClass() {
    }

}