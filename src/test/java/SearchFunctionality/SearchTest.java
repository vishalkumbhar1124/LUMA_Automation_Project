//VERIFYING SEARCH FUNCTIONALITY BY SEARCHING SHIRT

package SearchFunctionality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SearchTest {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
    }

    @Test
    public void verifySearchFunctionality() {
        driver.get("https://magento.softwaretestingboard.com/");
        driver.manage().window().maximize();
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("shirt");
        searchBox.submit();
        assert driver.getPageSource().contains("shirt") : "Search functionality failed.";
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
