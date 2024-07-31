package Compare_product_remove;

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
	      driver.findElement(By.xpath("//thead//td[1]//a[1]")).click();
	      driver.findElement(By.xpath("//button[@class='action-primary action-accept']")).click();
	      driver.findElement(By.xpath("//a[@title='Remove Product']")).click();
	      driver.findElement(By.xpath("//span[normalize-space()='OK']")).click();
	      
	      
	      Assert.assertTrue(driver.getPageSource().contains("You removed product Radiant Tee from the comparison list."), "Compare Products Remove failed.");
	      
	      
	      
  }

	  @AfterClass
	  public void teardown() {
	     driver.quit();
	 }
}
