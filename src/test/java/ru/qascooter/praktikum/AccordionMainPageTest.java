package ru.qascooter.praktikum;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.qascooter.praktikumservices.pageobject.MainPage;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertTrue;
import static ru.qascooter.praktikumservices.config.AppConfig.APP_URL;

@RunWith(Parameterized.class)
public class AccordionMainPageTest {
    private final int index;
    private final String text;
    private WebDriver webDriver;

    public AccordionMainPageTest(int index, String text) {
        this.index = index;
        this.text = text;
    }
    @Parameterized.Parameters // устанавливаю значения для проверок
    public static Object[][] getUserData() {
        return new Object[][]{
                {0, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {1, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {2, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {3, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {4, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {5, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {6, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {7, "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }

    @Before
    public void unit(){
        WebDriverManager.chromedriver().setup(); //устанавливаем веб-драйвер
        webDriver = new ChromeDriver();
        webDriver.get(APP_URL); //открываем тестируемую страницу
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //ставим таймаут на всякий случай
    }
    @Test
    public void checkListQuestions() {
        var mainPage = new MainPage(webDriver);
        var webElement = (mainPage.getAccordionPanel(index));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", webElement); //скроллим
        webElement.click(); //кликаем
        WebElement expandedBody = webElement.findElement(By.className("accordion__button")); //ищем элемент
        boolean isExpanded = Boolean.parseBoolean(expandedBody.getAttribute("aria-expanded")) == true;  //получаем свойство атрибута со свойством true
        assertTrue("Элемент не расскрыт", isExpanded); //проверяем на раскрытие
        var displayedText = webElement.findElement(By.className("accordion__panel")).getText();
        assertTrue("Содержание не соответствует жизненным ожиданиям", displayedText.equals(text));


    }
    @After
    public void teardown() {
        // Закрой браузер
        webDriver.quit();
    }
}