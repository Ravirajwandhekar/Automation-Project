package package1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class addJob {
    WebDriver driver;

    @BeforeTest
    public void beforeTest(){
        driver = new ChromeDriver();
    }

    @Test
    public void addJobTest(){
        driver.get("https://manage-osondemand.orangehrm.com/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("Admin");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Raviraj@123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.get("https://manage-osondemand.orangehrm.com/admin/saveJobTitle");
        WebElement jobTitle = driver.findElement(By.xpath("//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']"));
        jobTitle.sendKeys("ERP Co-ordinator");
        WebElement description = driver.findElement(By.xpath("//textarea[@placeholder='Type description here']"));
        description.sendKeys("The role is about to manage the Juno ERP Configuration's and handle the query's of the people who are using the ERP and stuck in berween.");
        driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
    }

//    @AfterTest
//    public void afterMethod(){ driver.close(); }
}
