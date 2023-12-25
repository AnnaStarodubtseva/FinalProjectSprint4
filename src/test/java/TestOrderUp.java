import org.junit.Test;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertEquals;

import org.openqa.selenium.firefox.FirefoxDriver;
import samokatpages.HomePage;
import static samokatpages.HomePage.*;
import static samokatpages.OrderPage.*;
import samokatpages.OrderPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import samokatpages.OrderPageAfterNext;

public class TestOrderUp {
    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
    }
    @Test
    public void testOrderUp() {
        WebDriver driver = new ChromeDriver();
        driver.get(urlSamokat);

        HomePage objHomePage = new HomePage(driver);
        objHomePage.clickOrderUp();
        assertEquals(urlSamokatOrder, driver.getCurrentUrl());

        OrderPage objOrderPage = new OrderPage(driver);
        objOrderPage.clickYes();
        objOrderPage.enterName("Анна");
        objOrderPage.enterSurname("Стародубцева");
        objOrderPage.enterAddress("Москва");
        objOrderPage.selectStation("Черкизовская");
        objOrderPage.enterPhone("89045878787");
        objOrderPage.clickNext();

        OrderPageAfterNext objOrderPageAfterNext = new OrderPageAfterNext(driver);
        objOrderPageAfterNext.selectData("22");
        objOrderPageAfterNext.selectDays("сутки");
        objOrderPageAfterNext.clickOrder();
        objOrderPageAfterNext.clickYesInModal();
        assertEquals(true, objOrderPageAfterNext.orderConfirmationWindow());

        driver.quit();

    }
}

