package Verifying_posters;

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
  public void f() {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://magento.softwaretestingboard.com/");
	
	driver.findElement(By.xpath("//img[@src='https://magento.softwaretestingboard.com/pub/media/wysiwyg/home/home-pants.jpg']")).click();
	
	Assert.assertTrue(driver.getPageSource().contains("Pants"), "Poster link failed.");
  }  @AfterClass
  public void teardown() {
	     driver.quit();
	 }
}
