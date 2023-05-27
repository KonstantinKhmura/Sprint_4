package ru.qascooter.praktikum;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.qascooter.praktikumservices.pageobject.MainPage;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;
import static ru.qascooter.praktikumservices.config.AppConfig.APP_URL;

public class LowerSecondButtonTest {
    private WebDriver webDriver;
    @Before
    public void unit() {
        WebDriverManager.chromedriver().setup(); //устанавливаем веб-драйвер
        webDriver = new ChromeDriver();
        webDriver.get(APP_URL); //открываем тестируемую страницу
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //ставим таймаут на всякий
    }
    @Test
    public void whenClickLowerOrderButton_ThenOrderPageGetsShow() {
        MainPage.findLowerOrderButtonAndClick(webDriver); //обращаемся к методу-помошнику из POM
        var isDisplayed = webDriver.findElement(By.className("Order_Form__17u6u")).isDisplayed(); //получаем свойство isDisplayed
        assertTrue("Элемент не отображается", isDisplayed); //проверяем, что открылась следующая страница и отображается форма заказа
    }
    @After
    public void teardown() {
        // Закрой браузер
        webDriver.quit();
    }
}
