package Compare_product;

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
	      driver.findElement(By.xpath("//a[normalize-space()='Radiant Tee']")).click();
	      driver.findElement(By.xpath("//span[normalize-space()='Add to Compare']")).click();
	      driver.findElement(By.xpath("//a[normalize-space()='Gabrielle Micro Sleeve Top']")).click();
	      driver.findElement(By.xpath("//span[normalize-space()='Add to Compare']")).click();
	      driver.findElement(By.xpath("//a[@title='Compare Products']")).click();

	      Assert.assertTrue(driver.getPageSource().contains("Compare Products"), "Compare Products failed.");

	  
	  
	  
	  }

	  @AfterClass
	  public void teardown() {
	     driver.quit();
	 }
}
