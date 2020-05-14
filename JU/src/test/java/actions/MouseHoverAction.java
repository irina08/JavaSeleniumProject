package actions;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHoverAction {
    private WebDriver driver;
    private String baseUrl;
    JavascriptExecutor jse;

    @BeforeEach
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://letskodeit.teachable.com/pages/practice";
        jse = (JavascriptExecutor)driver;

        // Maximize the browser's window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @Test()
    public void testMouseHoverActions() throws Exception {
        driver.get(baseUrl);
        jse.executeScript("window.scrollBy(0, 600)");
        Thread.sleep(2000);

        WebElement mainElement = driver.findElement(By.id("mousehover"));

        Actions action = new Actions(driver);
        action.moveToElement(mainElement).perform();
        Thread.sleep(2000);

        WebElement subElement = driver.findElement(By.xpath("//div[@class='mouse-hover-content']//a[text()='Top']"));
        action.moveToElement(subElement).click().perform();
    }

    @AfterEach
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }
}

