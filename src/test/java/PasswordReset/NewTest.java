package PasswordReset;

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
  public void f() throws InterruptedException {
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      driver.get("https://magento.softwaretestingboard.com/");
      driver.findElement(By.xpath("//div[@class='panel header']//a[contains(text(),'Sign In')]")).click();
      driver.findElement(By.xpath("//input[@id='email']")).sendKeys("john.doeVishall@example.com");
      driver.findElement(By.xpath("//fieldset[@class='fieldset login']//input[@id='pass']")).sendKeys("Password@12323");
      driver.findElement(By.xpath("//fieldset[@class='fieldset login']//button[@id='send2']")).click();
      Thread.sleep(5000);
      driver.findElement(By.xpath("//div[@class='panel header']//button[@type='button']")).click();
     // Thread.sleep(3000);
      driver.findElement(By.xpath("//div[@aria-hidden='false']//a[normalize-space()='My Account']")).click();
     // Thread.sleep(2000);
      driver.findElement(By.xpath("//a[normalize-space()='Change Password']")).click();
      driver.findElement(By.xpath("//input[@id='current-password']")).sendKeys("Password@12323");
      driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Password@1232323");
      driver.findElement(By.xpath("//input[@id='password-confirmation']")).sendKeys("Password@1232323");
      driver.findElement(By.xpath("//span[normalize-space()='Save']")).click();
      Assert.assertTrue(driver.getPageSource().contains("You saved the account information."), "Account details update failed.");
  
  
  }
  @AfterClass
  public void teardown() {
     driver.quit();
 }
}
