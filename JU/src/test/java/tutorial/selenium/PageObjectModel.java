package tutorial.selenium;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import page.classes.SearchPage;

public class PageObjectModel {
    private WebDriver driver;
    private String baseUrl;

    @BeforeEach
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://www.expedia.com/";

        // Maximize the browser's window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test() {
        driver.get(baseUrl);
        SearchPage.fillOriginTextBox(driver, "New York");
        SearchPage.destinationTextBox(driver).sendKeys("Chicago");
        SearchPage.departureDateTextBox(driver).sendKeys("12/25/2014");
        // Added a line to clear the return date text box
        // before entering the return date, because Expedia by default
        // enters the return date same as the departure date
        SearchPage.returnDateTextBox(driver).clear();
        SearchPage.returnDateTextBox(driver).sendKeys("12/31/2014");
        SearchPage.clickOnSearchButton(driver);
    }

    @AfterEach
    public void tearDown() throws Exception {
        driver.quit();
    }

}
