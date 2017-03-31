import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * Created by Maria on 31.03.2017.
 */
public class NegativeLinkTest {

    WebDriver driver = new ChromeDriver();

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
    }

    @Test
    public void notFoundTest() {
        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
        driver.get("http://www.thomas-bayer.com/sqlrest/PRODUCT/1d/");
        assertTrue(driver.getPageSource().contains("HTTP Status 404 - Resource not found"));
    }

    @Test
    public void wrongTableNameTest() {
        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
        driver.get("http://www.thomas-bayer.com/sqlrest/PRODUCbT/55/");
        assertTrue(driver.getPageSource().contains("HTTP Status 500 - Error: java.lang.IllegalArgumentException: Wrong tablename"));
    }

    @AfterClass
    public void closeDriver() {
        driver.quit();
    }
}
