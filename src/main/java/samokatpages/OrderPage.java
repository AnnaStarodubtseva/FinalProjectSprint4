package samokatpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage {
    public static final String urlSamokatOrder = "https://qa-scooter.praktikum-services.ru/order";
    private WebDriver driver;
    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }
    // кликаем кнопку "Да все привыкли"
    public void clickYes() {
        driver.findElement(By.className("App_CookieButton__3cvqF")).click();
    }
    // кликаем поле Имя и вводим тестовые данные
    public void enterName(String name) {
        driver.findElement(By.cssSelector("[placeholder='* Имя']")).sendKeys(name);
    }
    // кликаем поле Фамилия и вводим тестовые данные
    public void enterSurname(String surname) {
        driver.findElement(By.cssSelector("[placeholder='* Фамилия']")).sendKeys(surname);
    }
    // кликаем поле Адрес и вводим тестовые данные
    public void enterAddress(String address) {
        driver.findElement(By.cssSelector("[placeholder='* Адрес: куда привезти заказ']")).sendKeys(address);
    }
    // кликаем поле Станция метро и выбираем станцию из предложенного списка
    public void selectStation(String station) {
        driver.findElement(By.cssSelector("[placeholder='* Станция метро']")).click();
        driver.findElement(By.xpath(".//button/div[text() = '"+station+"']")).click();
    }
    // кликаем поле Телефон и вводим тестовые данные
    public void enterPhone(String phone) {
        driver.findElement(By.cssSelector("[placeholder='* Телефон: на него позвонит курьер']")).sendKeys(phone);
    }
    // кликаем кнопку Далее
    public void clickNext() {
        driver.findElement(By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM' and text()='Далее']")).click();
    }
}
