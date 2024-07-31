package Product_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
    public void verifyProductDetailPageDisplays() {
        driver.get("https://magento.softwaretestingboard.com/");
        driver.findElement(By.linkText("Radiant Tee")).click();
        assert driver.getTitle().contains("Radiant Tee") : "Product detail page did not display correctly.";
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
