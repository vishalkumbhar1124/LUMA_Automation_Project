package Login;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;

//import dev.failsafe.internal.util.Assert;

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
           driver.findElement(By.linkText("Sign In")).click();
           driver.findElement(By.id("email")).sendKeys("john.doeVisha@example.com");
           driver.findElement(By.id("pass")).sendKeys("Password@123456");
           driver.findElement(By.id("send2")).click();
           Assert.assertTrue(driver.getPageSource().contains("customer-welcome"), "User login failed.");
       }
  @AfterClass
  public void teardown() {
      driver.quit();
 }
  }

