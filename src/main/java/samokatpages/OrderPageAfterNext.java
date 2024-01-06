package samokatpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPageAfterNext {
    private WebDriver driver;
    public OrderPageAfterNext(WebDriver driver) {
        this.driver = driver;
    }
    // выбор Даты
    public void selectData(String data) {
        driver.findElement(By.cssSelector("[placeholder='* Когда привезти самокат']")).click();
        driver.findElement(By.xpath(".//div[text() = '"+data+"']")).click();
    }
    // выбор Срока аренды
    public void selectDays(String days) {
        driver.findElement(By.className("Dropdown-placeholder")).click();
        driver.findElement(By.xpath(".//div[text() = '"+days+"']")).click();
    }
    // кликаем Заказать
    public void clickOrder() {
        driver.findElement(By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']")).click();
    }
    // кликаем Да в модальном окне
    public void clickYesInModal() {
        driver.findElement(By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']")).click();
    }
    // проверяем наличие надписи "Заказ оформлен"
    public  boolean signOrderCompleted() {
        return driver.findElement(By.xpath(".//div[@class = 'Order_ModalHeader__3FDaJ' and text()='Заказ оформлен']")).isDisplayed();
    }
}