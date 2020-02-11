package basicweb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.firefox.FirefoxDriver;

public class TestClass {
    public static void main(String[] args) throws InterruptedException {
        String baseURL = "https://learn.letskodeit.com";
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseURL);

        driver.findElement(By.xpath("//a[@href='/sign_in']")).click();
        driver.findElement(By.id("user_email")).sendKeys("letskodeit@gmail.com");
        driver.findElement(By.name("enter-name")).sendKeys("Automation");

        driver.findElement(By.linkText("Login")).click();
        Thread.sleep(3000);

        driver.findElement(By.partialLinkText("Pract")).click();

        driver.findElement(By.className("btn-style")).click();
        driver.findElement(By.className("inputtext")).sendKeys("Automation");
        driver.findElement(By.className("uiButtonConfirm")).click();
        driver.findElement(By.tagName("a")).click();


    }
}
