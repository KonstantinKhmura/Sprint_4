package ru.qascooter.praktikum;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.qascooter.praktikumservices.pageobject.MainPage;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;
import static ru.qascooter.praktikumservices.config.AppConfig.APP_URL;

//в этом классе я попытался реализовать код немного иначе, чем в других классах

public class AccordionMainPageTest {
    private WebDriver webDriver;
    @Before
    public void unit(){
        WebDriverManager.chromedriver().setup(); //устанавливаем веб-драйвер
        webDriver = new ChromeDriver();
        webDriver.get(APP_URL); //открываем тестируемую страницу
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //ставим таймаут на всякий случай
    }
    @Test
    public void checkListQuestions() {
        var mainPage = new MainPage();
        var accordionItems = webDriver.findElements(mainPage.getAccordionPanel());
        for (var webElement : accordionItems) { //создаем цикл поиск элементов и циклы
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", webElement); //скроллим
            webElement.click(); //кликаем
            WebElement expandedBody = webElement.findElement(By.className("accordion__button")); //ищем элемент
            boolean isExpanded = Boolean.parseBoolean(expandedBody.getAttribute("aria-expanded")) == true;  //получаем свойство атрибута со свойством true
            assertTrue("Элемент не расскрыт", isExpanded); //проверяем на раскрытие
        }
    }
    @After
    public void teardown() {
        // Закрой браузер
        webDriver.quit();
    }
}
