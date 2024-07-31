package Remove_wishlist;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;


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
	      
	     Actions actions = new Actions(driver);
	     
	     WebElement act2 = driver.findElement(By.xpath("//li[3]//div[1]//div[1]//div[3]//div[1]//div[2]//a[1]"));
	     actions.moveToElement(act2).perform();
	     driver.findElement(By.xpath("//div[@class='panel header']//button[@type='button']")).click();
	      driver.findElement(By.xpath("//div[@aria-hidden='false']//ul[@class='header links']//li[@class='link wishlist']//a[@href='https://magento.softwaretestingboard.com/wishlist/']")).click();
	     WebElement act1 = driver.findElement(By.xpath("//div[@data-container='product-grid']//img[@alt='Argus All-Weather Tank']"));
	     actions.moveToElement(act1).perform();
	     driver.findElement(By.xpath("//a[@title='Remove Item']")).click();
	     Assert.assertTrue(driver.getPageSource().contains("You have no items in your wish list."), "Wishlist delete failed.");

	 }
	  @AfterClass
	  public void teardown() {
	     driver.quit();
	 }
	  }
