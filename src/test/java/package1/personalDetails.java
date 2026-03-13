package package1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;

public class personalDetails {
    WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public static void switchToLatestWindow(WebDriver driver) {
        for (String window : driver.getWindowHandles()) {
            driver.switchTo().window(window);
        }
    }

    @Test
    public void fillDetails() throws InterruptedException {
        driver.navigate().to("https://manage-osondemand.orangehrm.com/auth/login");
        driver.manage().window().maximize();
        String parentWindow = driver.getWindowHandle();
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("Admin");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Raviraj@123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='My Info']")).click();
        switchToLatestWindow(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500)");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//label[normalize-space()='Male']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
    }
}
