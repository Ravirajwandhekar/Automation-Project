package package1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class addUser {
    WebDriver driver;
    @BeforeTest
    public void beforeMethod(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public static void switchToLatestWindow(WebDriver driver) {
        for (String window : driver.getWindowHandles()) {
            driver.switchTo().window(window);
        }
    }

    @Test(priority = 1)
    public void loginTest() throws InterruptedException {
        driver.get("https://manage-osondemand.orangehrm.com/auth/login");
        driver.manage().window().maximize();
        String parentWindow = driver.getWindowHandle();
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("Admin");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Raviraj@123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.get("https://manage-osondemand.orangehrm.com/admin/saveSystemUser");
        Thread.sleep(3000);
        //switchToLatestWindow(driver);
        WebElement userRoleDropdown = driver.findElement(By.xpath("//div[@class='oxd-grid-2 orangehrm-full-width-grid']//div[1]//div[1]//div[2]//div[1]//div[1]//div[2]//i[1]"));
        userRoleDropdown.click(); // Click to open dropdown
        Thread.sleep(1000); // Wait for dropdown options to appear

        // Select option from dropdown (e.g., "Admin" or "ESS")
        WebElement userRoleOption = driver.findElement(By.xpath("//div[@role='listbox']//span[text()='Admin']"));
        userRoleOption.click();

        WebElement employeeName = driver.findElement(By.xpath("//input[@placeholder='Type for hints...']"));
        employeeName.sendKeys("Raviraj"); // Type partial employee name
        Thread.sleep(4000); // Wait for autocomplete suggestions to appear

        // Click on the first suggestion from autocomplete dropdown
        WebElement employeeSuggestion = driver.findElement(By.xpath("(//div[@role='option'])[1]"));
        employeeSuggestion.click();

        WebElement status = driver.findElement(By.xpath("//div[3]//div[1]//div[2]//div[1]//div[1]//div[2]//i[1]"));
        status.click(); // Type partial employee name
        Thread.sleep(2000); // Wait for autocomplete suggestions to appear

        // Click on the first suggestion from autocomplete dropdown
        WebElement statusSuggestion = driver.findElement(By.xpath("(//div[@role='option'])[2]"));
        statusSuggestion.click();

        WebElement username1 = driver.findElement(By.xpath("//div[@class='oxd-form-row']//div[@class='oxd-grid-2 orangehrm-full-width-grid']//div[@class='oxd-grid-item oxd-grid-item--gutters']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']"));
        username1.sendKeys("Ravirajwandekar"); // Type partial employee name

        WebElement password1 = driver.findElement(By.xpath("//div[@class='oxd-grid-item oxd-grid-item--gutters user-password-cell']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@type='password']"));
        password1.sendKeys("Raviraj@123");

        WebElement cfmpass = driver.findElement(By.xpath("//div[@class='oxd-grid-item oxd-grid-item--gutters']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@type='password']"));
        cfmpass.sendKeys("Raviraj@123");

        WebElement savebtn = driver.findElement(By.xpath("//button[normalize-space()='Save']"));
        savebtn.click();
    }

}
