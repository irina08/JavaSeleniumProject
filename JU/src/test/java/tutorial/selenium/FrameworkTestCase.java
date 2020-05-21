package tutorial.selenium;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import page.classes.SearchPageFactory;

public class FrameworkTestCase {
    private WebDriver driver;
    private String baseUrl;
    SearchPageFactory searchPage;

    @BeforeEach
    public void beforeClass() {
        driver = new FirefoxDriver();
        baseUrl = "https://www.expedia.com/";

        searchPage = new SearchPageFactory(driver);

        // Maximize the browser's window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @Test
    public void test() throws Exception {
        searchPage.clickFlightsTab();
        searchPage.setOriginCity("New York");
        searchPage.setDestinationCity("San Francisco");
        searchPage.setDepartureDate("10/28/2015");
        searchPage.setReturnDate("10/31/2015");
    }

    @AfterEach
    public void afterClass() {
    }
}