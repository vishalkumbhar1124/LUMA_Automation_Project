package Register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NewTest {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
    }

    @Test
    public void verifyUserRegistration() {
        driver.get("https://magento.softwaretestingboard.com/");
        driver.findElement(By.linkText("Create an Account")).click();
        driver.findElement(By.id("firstname")).sendKeys("John");
        driver.findElement(By.id("lastname")).sendKeys("Doe");
        driver.findElement(By.id("email_address")).sendKeys("john.doeVishall@example.com");
        driver.findElement(By.id("password")).sendKeys("Password@12323");
        driver.findElement(By.id("password-confirmation")).sendKeys("Password@12323");
        driver.findElement(By.cssSelector(".submit")).click();
        assert driver.getPageSource().contains("Thank you for registering") : "User registration failed.";
    }

   @AfterClass
   public void teardown() {
       driver.quit();
  }
}

