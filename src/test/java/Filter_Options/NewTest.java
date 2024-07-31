package Filter_Options;

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
	      driver.findElement(By.xpath("//div[@class='panel header']//a[contains(text(),'Sign In')]")).click();
	      driver.findElement(By.xpath("//input[@id='email']")).sendKeys("john.doeVisha@example.com");
	      driver.findElement(By.xpath("//fieldset[@class='fieldset login']//input[@id='pass']")).sendKeys("Password@123456");
	      driver.findElement(By.xpath("//fieldset[@class='fieldset login']//button[@id='send2']")).click();
	      
	      
	      
	      
	      // Locate the element to hover over
	        WebElement elementToHover = driver.findElement(By.xpath("//a[@id='ui-id-5']//span[@class='ui-menu-icon ui-icon ui-icon-carat-1-e']"));
	        
	        // Create Actions object
	        Actions actions = new Actions(driver);
	        
	        // Perform hover action
	        actions.moveToElement(elementToHover).perform();
	      
	     WebElement elemen = driver.findElement(By.xpath("//a[@id='ui-id-17']//span[@class='ui-menu-icon ui-icon ui-icon-carat-1-e']"));
	     actions.moveToElement(elemen).perform();
	     
	     driver.findElement(By.xpath("//a[@id='ui-id-19']//span[contains(text(),'Jackets')]"));
	      Assert.assertTrue(driver.getPageSource().contains("Men"), "Filter failed.");

	  
	  }@AfterClass
	  public void teardown() {
		     driver.quit();
		 }
}
