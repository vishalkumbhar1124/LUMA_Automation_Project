package Address_Selection_Checkout;

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
	      Thread.sleep(3000);
	      driver.findElement(By.xpath("//a[@title='Hero Hoodie'][normalize-space()='Hero Hoodie']")).click();
	      driver.findElement(By.xpath("//div[@id='option-label-size-143-item-167']")).click();
	      driver.findElement(By.xpath("//div[@id='option-label-color-93-item-53']")).click();
	      driver.findElement(By.xpath("//span[normalize-space()='Add to Cart']")).click();
	      Thread.sleep(3000);
	      driver.findElement(By.xpath("//a[@class='action showcart']")).click();
	      driver.findElement(By.xpath("//button[@id='top-cart-btn-checkout']")).click();
	      Thread.sleep(3000);
	      driver.findElement(By.xpath("//div[@id='checkout-step-shipping']//div[2]//button[2]")).click();
	      Thread.sleep(3000);
//	      driver.findElement(By.xpath("//input[@name='ko_unique_8']")).click();
//	      driver.findElement(By.xpath("//span[normalize-space()='Next']")).click();
	   
	      Assert.assertTrue(driver.getPageSource().contains("Shipping Address"), "Address Selection failed.");


	      
	      
	  }
	  @AfterClass
	  public void teardown() {
	     driver.quit();
	 }
}
