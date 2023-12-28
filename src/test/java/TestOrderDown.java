import org.junit.Test;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertEquals;
import org.openqa.selenium.firefox.FirefoxDriver;
import samokatpages.HomePage;
import static samokatpages.HomePage.*;
import static samokatpages.OrderPage.*;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestOrderDown {
    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
    }
    @Test
    public void testOrderDown() {
        WebDriver driver = new ChromeDriver();
        driver.get(URL_SAMOKAT);

        HomePage objHomePage = new HomePage(driver);
        objHomePage.clickOrderDown();
        assertEquals(URL_SAMOKAT_ORDER, driver.getCurrentUrl());

        driver.quit();

    }
}

