package AddingProduct_re;

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
	      driver.findElement(By.xpath("//a[normalize-space()='Breathe-Easy Tank']")).click();
	      driver.findElement(By.xpath("//a[@id='tab-label-reviews-title']")).click();
	      driver.findElement(By.xpath("//label[@id='Rating_1_label']")).click();
	      driver.findElement(By.xpath("//input[@id='nickname_field']")).sendKeys("Leo");
	      driver.findElement(By.xpath("//input[@id='summary_field']")).sendKeys("LEo Das");
	      driver.findElement(By.xpath("//textarea[@id='review_field']")).sendKeys("Amazing Product");
	      driver.findElement(By.xpath("//span[normalize-space()='Submit Review']")).click();
	      
	      Assert.assertTrue(driver.getPageSource().contains("You submitted your review for moderation."), "Review failed.");
	      
	  }
	  @AfterClass
	  public void teardown() {
	     driver.quit();
	 }
}
