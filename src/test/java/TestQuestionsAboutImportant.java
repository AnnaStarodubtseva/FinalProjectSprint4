import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertEquals;
import samokatpages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;


@RunWith(Parameterized.class)
    public class TestQuestionsAboutImportant {
        private final String textAnswer;
        private final  int indexTest;

        public TestQuestionsAboutImportant(int indexTest, String textAnswer) {
            this.indexTest = indexTest;
            this.textAnswer = textAnswer;
        }
        @Parameterized.Parameters
        public static Object[][] getText() {
            return new Object[][]{
                    {0, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                    {3, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
            };
        }
        @Before
        public void startUp() {
            WebDriverManager.chromedriver().setup();
        }
        @Test
        public void questionAboutImportantTest() {
            WebDriver driver = new ChromeDriver();
            driver.get("https://qa-scooter.praktikum-services.ru/");
            HomePage objHomePage = new HomePage(driver);
            objHomePage.clickQuestion(indexTest);
            assertEquals(textAnswer, objHomePage.getTextAnswer(indexTest));
            driver.quit();
        }

    }


