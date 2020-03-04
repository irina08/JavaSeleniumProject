package web.com;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class ElementState {
    private WebDriver driver;
    private String baseUrl;

    @BeforeAll
    static void setUpBeforeClass() throws Exception
    {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUp() throws Exception {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NONE);
        driver = new ChromeDriver(options);
        baseUrl = "http://letskodeit.teachable.com/";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterEach
    void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    void test() throws InterruptedException {
        WebElement e1 = driver.findElement(By.id("gs_htif0"));
        System.out.println("E1 is Enabled? " + e1.isEnabled());

        WebElement e2 = driver.findElement(By.id("gs_taif0"));
        System.out.println("E2 is Enabled? " + e2.isEnabled());

        WebElement e3 = driver.findElement(By.id("lst-ib"));
        System.out.println("E3 is Enabled? " + e3.isEnabled());

        e3.sendKeys("letskodeit");
    }
}
