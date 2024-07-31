package Verify_Hori_Vert;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
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
		  Actions actions = new Actions(driver);
	      WebElement act = driver.findElement(By.xpath("//a[@id='ui-id-4']//span[@class='ui-menu-icon ui-icon ui-icon-carat-1-e']"));
	      actions.moveToElement(act).perform();
	      WebElement act1 = driver.findElement(By.xpath("//a[@id='ui-id-9']"));
	      actions.moveToElement(act1).perform();
	      driver.findElement(By.xpath("//a[@id='ui-id-11']")).click();
		  driver.findElement(By.xpath("//div[@class='column main']//div[2]//div[1]//a[1]")).click();
		  Assert.assertTrue(driver.getPageSource().contains("Olivia 1/4 Zip Light Jacket"), "verticle horizontal alignment failed.");
		  
		  
	  }
	  @AfterClass
	  public void teardown() {
		     driver.quit();
		 }
}
