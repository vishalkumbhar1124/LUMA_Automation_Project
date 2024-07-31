package Verify_forgetPass;

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
	  driver.findElement(By.xpath("//div[@class='panel header']//a[contains(text(),'Sign In')]")).click();
	  driver.findElement(By.xpath("//a[@class='action remind']//span[contains(text(),'Forgot Your Password?')]")).click();
	  driver.findElement(By.xpath("//input[@id='email_address']")).sendKeys("john.doeVisha@example.com");
	  driver.findElement(By.xpath("//span[normalize-space()='Reset My Password']")).click();
	  
	  Assert.assertTrue(driver.getPageSource().contains("If there is an account associated with john.doeVisha@example.com you will receive an email with a link to reset your password."), "Password reset failed.");
  }
  @AfterClass
  public void teardown() {
     driver.quit();
 }
  }

