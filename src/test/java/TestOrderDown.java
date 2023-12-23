import org.junit.Test;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertEquals;
import samokatpages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestOrderDown {
    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
    }
    @Test
    public void testOrderDown() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        HomePage objHomePage = new HomePage(driver);
        objHomePage.clickOrderDown();
        assertEquals("https://qa-scooter.praktikum-services.ru/order", driver.getCurrentUrl());

        driver.quit();

    }
}

