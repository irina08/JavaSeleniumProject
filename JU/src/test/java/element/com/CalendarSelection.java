package element.com;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CalendarSelection {
    private WebDriver driver;
    private String baseUrl;

    @BeforeEach
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://www.expedia.com/";

        // Maximize the browser's window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test1() throws Exception {
        driver.get(baseUrl);
        // Click flights tab
        driver.findElement(By.id("tab-flight-tab-hp")).click();
        // Find departing field
        WebElement departingField = driver.findElement(By.id("flight-departing-hp-flight"));
        // Click departing field
        departingField.click();
        Thread.sleep(3000);
        // Find the date to be selected
        WebElement dateToSelect = driver.findElement(By.xpath("//section[@class='cal-month'][position()=1]//a[text()='31']"));
        // Click the date
        dateToSelect.click();
    }

    @AfterEach
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.quit();
    }
}
