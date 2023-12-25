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
import samokatpages.OrderPage;
import samokatpages.OrderPageAfterNext;


public class TestOrderDown {
    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
    }
    @Test
    public void testOrderDown() {
        WebDriver driver = new ChromeDriver();
        driver.get(urlSamokat);

        HomePage objHomePage = new HomePage(driver);
        objHomePage.clickOrderDown();
        assertEquals(urlSamokatOrder, driver.getCurrentUrl());

        OrderPage objOrderPage = new OrderPage(driver);
        objOrderPage.clickYes();
        objOrderPage.enterName("Евгения");
        objOrderPage.enterSurname("Шакина");
        objOrderPage.enterAddress("Томск");
        objOrderPage.selectStation("Сокольники");
        objOrderPage.enterPhone("89045858585");
        objOrderPage.clickNext();

        OrderPageAfterNext objOrderPageAfterNext = new OrderPageAfterNext(driver);
        objOrderPageAfterNext.selectData("1");
        objOrderPageAfterNext.selectDays("двое суток");
        objOrderPageAfterNext.clickOrder();
        objOrderPageAfterNext.clickYesInModal();
        assertEquals(true, objOrderPageAfterNext.orderConfirmationWindow());

        driver.quit();

    }
}

