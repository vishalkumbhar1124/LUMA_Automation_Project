package WishList_function;

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
	      driver.findElement(By.xpath("//a[normalize-space()='Argus All-Weather Tank']")).click();
	      driver.findElement(By.xpath("//div[@class='product-addto-links']//span[contains(text(),'Add to Wish List')]")).click();
	      driver.findElement(By.xpath("//input[@id='email']")).sendKeys("john.doeVisha@example.com");
	      driver.findElement(By.xpath("//fieldset[@class='fieldset login']//input[@id='pass']")).sendKeys("Password@123456");
	      driver.findElement(By.xpath("//fieldset[@class='fieldset login']//span[contains(text(),'Sign In')]")).click();
	      
	      Assert.assertTrue(driver.getPageSource().contains("My Wish List"), "Account details update failed.");
}

	  @AfterClass
	  public void teardown() {
	     driver.quit();
	 }
}