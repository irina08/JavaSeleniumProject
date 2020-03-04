package web.com;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

class BasicActions {
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
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        baseUrl = "http://letskodeit.teachable.com/";
    }

    @Test
    public void test() {
        driver.get(baseUrl);
        driver.findElement(By.xpath("//div[@id='navbar']//a[@href='/sign_in']")).click();
        System.out.println("Clicked on login");
        driver.findElement(By.id("user_email")).sendKeys("test@email.com");
        System.out.println("Sending keys to username field");
        driver.findElement(By.id("user_password")).sendKeys("test");
        System.out.println("Sending keys to password field");
        driver.findElement(By.id("user_email")).clear();
        System.out.println("Clearing the username field");
    }

    @AfterEach
    public void tearDown() throws Exception {
        driver.quit();
    }
}