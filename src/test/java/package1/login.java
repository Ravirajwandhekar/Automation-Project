package package1;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import java.time.Duration;

public class login {
    WebDriver driver;
    @BeforeTest
    public void beforeMethod(){
        driver = new ChromeDriver();
    }

    public static void switchToLatestWindow(WebDriver driver) {
        for (String window : driver.getWindowHandles()) {
            driver.switchTo().window(window);
        }
    }

    @Test(priority = 1)
    public void loginTest(){
        driver.navigate().to("https://manage-osondemand.orangehrm.com/auth/login");
        driver.manage().window().maximize();
        String parentWindow = driver.getWindowHandle();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("Admin");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Raviraj@123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
//    @AfterTest
//    public void afterMethod(){ driver.close(); }

}


