package javascriptexecution;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JavaScriptClick {
    private WebDriver driver;
    private JavascriptExecutor js;

    @BeforeEach
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        js = (JavascriptExecutor) driver;

        // Maximize the browser's window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testJSClick1() throws Exception {
        driver.get("https://letskodeit.teachable.com/pages/practice");
        Thread.sleep(3000);

        WebElement checkBoxElement = driver.findElement(By.id("bmwcheck"));
        js.executeScript("arguments[0].click();", checkBoxElement);
    }

    @AfterEach
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.quit();
    }
}