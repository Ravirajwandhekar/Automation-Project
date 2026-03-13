package package1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class addLeave {
    WebDriver driver;
    @BeforeTest
    public void beforeMethod(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void leaveTest() throws InterruptedException {
        driver.get("https://manage-osondemand.orangehrm.com/auth/login");
        driver.manage().window().maximize();
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("Admin");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Raviraj@123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.get("https://manage-osondemand.orangehrm.com/leave/defineLeavePeriod");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // month
        WebElement month = driver.findElement(By.xpath("//div[@class='oxd-grid-4 orangehrm-full-width-grid']//div[1]//div[1]//div[2]//div[1]//div[1]//div[2]//i[1]"));
        month.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//div[@role='option'])[2]")).click();

        //date
        WebElement date = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/i[1]"));
        date.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//div[@role='option'])[6]")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();

    }

    @AfterTest
    public void afterMethod(){ driver.close(); }
}
