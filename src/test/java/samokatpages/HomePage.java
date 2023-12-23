package samokatpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver = driver;
    }
    // находим Вопрос, скроллим до него и кликаем
    public void clickQuestion(int index) {
        WebElement question = driver.findElement(By.id(String.format("accordion__heading-%d", index)));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", question);
        question.click();
    }
    // получаем текст открывшегося Ответа
    public String getTextAnswer(int index) {
        return driver.findElement(By.id(String.format("accordion__panel-%d", index))).getText();
    }
    // находим сверху кнопку Заказать и кликаем
    public void clickOrderUp() {
        driver.findElement(By.className("Button_Button__ra12g")).click();
    }
    // находим снизу кнопку Заказать и кликаем
    public void clickOrderDown() {
        WebElement orderDown = driver.findElement(By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", orderDown);
        orderDown.click();
    }
}

