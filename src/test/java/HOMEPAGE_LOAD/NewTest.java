//VERIFYING HOME PAGE IS LOADING PROPERLY OR NOT.(TC_01)

package HOMEPAGE_LOAD;

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
    public void verifyHomePageLoadsCorrectly() {
        driver.get("https://magento.softwaretestingboard.com/");
        assert driver.getTitle().contains("Home Page") : "Home page did not load correctly.";
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
