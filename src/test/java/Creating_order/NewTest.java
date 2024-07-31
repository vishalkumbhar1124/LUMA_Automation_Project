package Creating_order;

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
	  public void f() throws InterruptedException {
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
		  driver.get("https://magento.softwaretestingboard.com/");
	      driver.findElement(By.xpath("//div[@class='panel header']//a[contains(text(),'Sign In')]")).click();
	      driver.findElement(By.xpath("//input[@id='email']")).sendKeys("john.doeVisha@example.com");
	      driver.findElement(By.xpath("//fieldset[@class='fieldset login']//input[@id='pass']")).sendKeys("Password@123456");
	      driver.findElement(By.xpath("//fieldset[@class='fieldset login']//button[@id='send2']")).click();
	      driver.findElement(By.xpath("//a[normalize-space()='Fusion Backpack']")).click();
	      driver.findElement(By.xpath("//span[normalize-space()='Add to Cart']")).click();
	    //  driver.findElement(By.xpath("//button[@id='product-addtocart-button']")).click();
	      Thread.sleep(5000);
	      driver.findElement(By.xpath("//a[@class='action showcart']")).click();
	      driver.findElement(By.xpath("//button[@id='top-cart-btn-checkout']")).click();
	      driver.findElement(By.xpath("//input[@name='ko_unique_1']")).click();
	      driver.findElement(By.xpath("//span[normalize-space()='Next']")).click();
	      Thread.sleep(5000);
	     driver.findElement(By.xpath("//button[@title='Place Order']")).click();	     // driver.findElement(By.xpath("//span[normalize-space()='Next']")).click();
	     Thread.sleep(6000); 
	     Assert.assertTrue(driver.getPageSource().contains("Thank you for your purchase!"), "Order Purchase failed.");
	      
	      
  }

	  @AfterClass
	  public void teardown() {
	     driver.quit();
	 }
}
