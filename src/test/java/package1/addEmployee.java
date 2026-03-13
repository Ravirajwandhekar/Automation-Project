package package1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class addEmployee {

//    @BeforeTest
//    public void beforeTest(){
//    }

    @Test(dataProvider = "DP")
    public void testAddEmployeeField(String firstName, String lastName) {
        WebDriver driver;
        driver = new ChromeDriver();
        driver.get("https://manage-osondemand.orangehrm.com/auth/login");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String parentWindow = driver.getWindowHandle();
        WebElement username = wait.until(ExpectedConditions.elementToBeClickable(By.name("username")));
        username.sendKeys("Admin");
        WebElement pass = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='password']")));
        pass.sendKeys("Raviraj@123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.get("https://manage-osondemand.orangehrm.com/pim/addEmployee");
        WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='First Name']")));
        element1.sendKeys(firstName);
        WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Last Name']")));
        element2.sendKeys(lastName);
        driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
        driver.quit();
    }


    @DataProvider
    public Object[][] DP(){
        return new Object[][] {
            {"Aditya", "surve"},
                {"Hitesh", "Chaudhry"},
                {"Jivan", "Dhemshe"}
        };
    }
}
