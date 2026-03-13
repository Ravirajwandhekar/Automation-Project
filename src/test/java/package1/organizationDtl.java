package package1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class organizationDtl {
    WebDriver driver;

    @BeforeTest
    public void beforeMethod(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testOrganizationDtls() throws InterruptedException {
        driver.get("https://manage-osondemand.orangehrm.com/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("Admin");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Raviraj@123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.get("https://manage-osondemand.orangehrm.com/admin/viewOrganizationGeneralInformation");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//span[@class='oxd-switch-input oxd-switch-input--active --label-left']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement orgName = wait.until(ExpectedConditions.presenceOfElementLocated(
                (By.xpath("//div[@class='oxd-grid-item oxd-grid-item--gutters organization-name-container']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']"))
        ));
        orgName.click();
        orgName.sendKeys(Keys.CONTROL + "a");
        orgName.sendKeys("MGM University");
        driver.findElement(By.xpath("//body[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/div[2]/input[1]")).sendKeys("123");
        driver.findElement(By.xpath("//input[@modelmodifiers='[object Object]']")).sendKeys("02628956");
        driver.findElement(By.xpath("//body[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/form[1]/div[3]/div[1]/div[3]/div[1]/div[2]/input[1]")).sendKeys("abc@mgmu.ac.in");
        driver.findElement(By.xpath("//body[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/form[1]/div[4]/div[1]/div[3]/div[1]/div[2]/input[1]")).sendKeys("Ch. Sambhaji Nagar");
        driver.findElement(By.xpath("//body[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/form[1]/div[5]/div[1]/div[2]/div[1]/div[2]/input[1]")).sendKeys("431003");
        WebElement country = driver.findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']"));
        country.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@role='option']//span[text()='India']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
    }
}
