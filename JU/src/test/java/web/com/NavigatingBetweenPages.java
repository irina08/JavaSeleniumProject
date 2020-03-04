package web.com;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

class NavigatingBetweenPages {
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

    @Test
    void test() throws InterruptedException {
        driver.get(baseUrl);
        String title = driver.getTitle();
        System.out.println("Title of the page is: " + title);

        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL is: " + currentUrl);

        String urlToNavigate = "https://sso.teachable.com/secure/42299/users/sign_in?reset_purchase_session=1";
        driver.navigate().to(urlToNavigate);
        System.out.println("Navigating To Login");
        currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL is: " + currentUrl);

        Thread.sleep(2000);

        driver.navigate().back();
        System.out.println("Navigate Back");
        currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL is: " + currentUrl);

        Thread.sleep(2000);

        driver.navigate().forward();
        System.out.println("Navigate Forward");
        currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL is: " + currentUrl);

        Thread.sleep(2000);

        driver.navigate().back();
        System.out.println("Navigate Back");
        currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL is: " + currentUrl);

        driver.navigate().refresh();
        System.out.println("Navigate Refresh");
        driver.get(currentUrl);
        System.out.println("Navigate Refresh");

        String pageSource = driver.getPageSource();
        System.out.println(pageSource);
    }

    @AfterEach
    public void tearDown() throws Exception {
        driver.quit();
    }
}

