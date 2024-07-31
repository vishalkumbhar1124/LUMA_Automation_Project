package Quantity_in_cart;

import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
    public void verifyUpdateQuantityInCart() throws InterruptedException {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://magento.softwaretestingboard.com/");
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Radiant Tee")).click();
        driver.findElement(By.xpath("//div[@id='option-label-size-143-item-167']")).click();
        driver.findElement(By.xpath("//div[@id='option-label-color-93-item-50']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Add to Cart']")).click();//add to cart button
     Thread.sleep(5000);
        driver.findElement(By.xpath("//a[@class='action showcart']")).click();
//WebElement Qnt =        driver.findElement(By.xpath("//input[@id='cart-item-211121-qty']"));
//        Qnt.click();
//        Qnt.clear();
//        Qnt.sendKeys("2");
        WebElement qtyBox = driver.findElement(By.cssSelector(".input-text.qty"));
        qtyBox.click();
        qtyBox.clear();
        qtyBox.sendKeys("2");
        driver.findElement(By.cssSelector(".update")).click();
       // WebElement HM = driver.findElement(By.xpath("//input[@id='qty']"));
      // driver.findElement(By.xpath("//span[normalize-space()='Update']")).click();
        
     assert qtyBox.getAttribute("id").equals("qty") : "Update quantity in cart failed.";
    }

//    @AfterClass
//    public void teardown() {
//        driver.quit();
//    }
}

