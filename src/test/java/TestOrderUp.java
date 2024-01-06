import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertEquals;

import org.openqa.selenium.firefox.FirefoxDriver;
import samokatpages.HomePage;

import static org.junit.Assert.assertTrue;
import static samokatpages.HomePage.*;
import static samokatpages.OrderPage.*;
import samokatpages.OrderPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import samokatpages.OrderPageAfterNext;

@RunWith(Parameterized.class)
public class TestOrderUp {
    private final String firstName;
    private final  String secondName;
    private final String city;
    private final String station;
    private final String phoneNumber;
    private final String data;
    private final String amountDays;
    public TestOrderUp(String firstName, String secondName, String city, String station, String phoneNumber, String data, String amountDays) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.city = city;
        this.station = station;
        this.phoneNumber = phoneNumber;
        this.data = data;
        this.amountDays = amountDays;
    }
    @Parameterized.Parameters
    public static Object[][] getDate() {
        return new Object[][]{
                {"Анна", "Шакина", "Москва", "Черкизовская", "89045878787", "22", "сутки"},
                {"Евгений", "Стародубцев", "Томск", "Сокольники", "89514263816", "1", "двое суток"}
        };
    }

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
    }
    @Test
    public void testOrderUp() {
        WebDriver driver = new ChromeDriver();
        driver.get(URL_SAMOKAT);

        HomePage objHomePage = new HomePage(driver);
        objHomePage.clickOrderUp();
        assertEquals(URL_SAMOKAT_ORDER, driver.getCurrentUrl());

        OrderPage objOrderPage = new OrderPage(driver);
        objOrderPage.clickYes();
        objOrderPage.enterName(firstName);
        objOrderPage.enterSurname(secondName);
        objOrderPage.enterAddress(city);
        objOrderPage.selectStation(station);
        objOrderPage.enterPhone(phoneNumber);
        objOrderPage.clickNext();

        OrderPageAfterNext objOrderPageAfterNext = new OrderPageAfterNext(driver);
        objOrderPageAfterNext.selectData(data);
        objOrderPageAfterNext.selectDays(amountDays);
        objOrderPageAfterNext.clickOrder();
        objOrderPageAfterNext.clickYesInModal();
        assertTrue(objOrderPageAfterNext.signOrderCompleted());

        driver.quit();

    }
}

