package Cart_Display;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NewTest {
    WebDriver driver;
    @Test(priority=1)
    public void login() {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	driver.get("https://magento.softwaretestingboard.com/");
        driver.findElement(By.linkText("Sign In")).click();

        // Enter login credentials
        driver.findElement(By.id("email")).sendKeys("john.doe123@example.com");
        driver.findElement(By.id("pass")).sendKeys("Password@123");

        // Click login button
        driver.findElement(By.id("send2")).click();
    	
    }
        
    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
    }

    @Test(priority=2)
    public void verifyCartPageDisplaysProducts() throws InterruptedException {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.linkText("Radiant Tee")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@id='option-label-size-143-item-167']")).click();
        driver.findElement(By.xpath("//div[@id='option-label-color-93-item-50']"));
        driver.findElement(By.xpath("//span[normalize-space()='Add to Cart']")).click();
        driver.findElement(By.xpath("//a[@class='action showcart']")).click();
        assert driver.getPageSource().contains("Radiant Tee") : "Add to cart functionality failed.";
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
