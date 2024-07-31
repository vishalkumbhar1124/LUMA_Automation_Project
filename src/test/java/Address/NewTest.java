package Address;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
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
	      Thread.sleep(5000);
	      driver.findElement(By.xpath("//div[@class='panel header']//button[@type='button']")).click();
	     // Thread.sleep(3000);
	      driver.findElement(By.xpath("//div[@aria-hidden='false']//a[normalize-space()='My Account']")).click();
	      driver.findElement(By.xpath("//a[normalize-space()='Address Book']")).click();
	      driver.findElement(By.xpath("//span[normalize-space()='Add New Address']")).click();
	      driver.findElement(By.xpath("//input[@id='street_1']")).sendKeys("Street 14c");
	      driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Washington DC");
	      WebElement stateDropdown = driver.findElement(By.xpath("//select[@id='region_id']"));
	      
	      
	      Select selectState = new Select(stateDropdown);
	      selectState.selectByVisibleText("California");
	      
	      driver.findElement(By.xpath("//input[@id='telephone']")).sendKeys("2343543654");
	      driver.findElement(By.xpath("//input[@id='zip']")).sendKeys("20001");
	      driver.findElement(By.xpath("//input[@id='primary_billing']")).click();
	      driver.findElement(By.xpath("//span[normalize-space()='Save Address']")).click();
	      
	      Assert.assertTrue(driver.getPageSource().contains("You saved the address."), "Saving Address failed.");

	      
	      
	      
}
	  @AfterClass
	  public void teardown() {
	     driver.quit();
	 }
}