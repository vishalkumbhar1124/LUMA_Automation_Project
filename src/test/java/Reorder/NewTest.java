package Reorder;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
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
	  public void verifyHomePageLoadsCorrectly() throws InterruptedException {
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
		  driver.get("https://magento.softwaretestingboard.com/");
	      driver.findElement(By.xpath("//div[@class='panel header']//a[contains(text(),'Sign In')]")).click();
	      driver.findElement(By.xpath("//input[@id='email']")).sendKeys("john.doeVisha@example.com");
	      driver.findElement(By.xpath("//fieldset[@class='fieldset login']//input[@id='pass']")).sendKeys("Password@123456");
	      driver.findElement(By.xpath("//fieldset[@class='fieldset login']//button[@id='send2']")).click();
driver.findElement(By.xpath("//div[@class='panel header']//button[@type='button']")).click();
driver.findElement(By.xpath("//div[@aria-hidden='false']//a[normalize-space()='My Account']")).click();
driver.findElement(By.xpath("//a[normalize-space()='My Orders']")).click();
driver.findElement(By.xpath("//tbody/tr[1]/td[6]/a[2]/span[1]")).click();
driver.findElement(By.xpath("//span[normalize-space()='Proceed to Checkout']")).click();
Thread.sleep(5000);
driver.findElement(By.xpath("//input[@name='ko_unique_1']")).click();
driver.findElement(By.xpath("//span[normalize-space()='Next']")).click();
Thread.sleep(5000);
driver.findElement(By.xpath("//button[@title='Place Order']")).click();
Thread.sleep(4000);
Assert.assertTrue(driver.getPageSource().contains("Thank you for your purchase!"), "Re Order failed.");
	  
	  
	  }
	  @AfterClass
	  public void teardown() {
	     driver.quit();
	 }
	}

