package actions;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderAction {
    private WebDriver driver;
    private String baseUrl;

    @BeforeEach
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://jqueryui.com/slider/";

        // Maximize the browser's window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testSliderActions() throws Exception {
        driver.get(baseUrl);
        driver.switchTo().frame(0);
        Thread.sleep(3000);

        // Using the actions class
        WebElement element = driver.findElement(By.xpath("//div[@id='slider']/span"));
        Actions action = new Actions(driver);
        action.dragAndDropBy(element, 100, 0).perform();
    }

    @AfterEach
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }
}

