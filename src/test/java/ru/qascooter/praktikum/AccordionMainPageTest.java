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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static ru.qascooter.praktikumservices.config.AppConfig.APP_URL;

public class AccordionMainPageTest {

    private WebDriver webDriver;

    private final String[] tips =
            {
                    "Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
                    "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
                    "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
                    "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
                    "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
                    "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
                    "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
                    "Да, обязательно. Всем самокатов! И Москве, и Московской области.",
            };
    @Before
    public void unit(){
        WebDriverManager.chromedriver().setup(); //устанавливаем веб-драйвер
        webDriver = new ChromeDriver();
        webDriver.get(APP_URL); //открываем тестируемую страницу
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //ставим таймаут на всякий случай
    }
    @Test
    public void checkListQuestions2()
    {
        var mainPage = new MainPage(webDriver);
        var accordionItems = mainPage.getAccordionPanels();
        var failed = false;

        for (var i = 0; i < accordionItems.size(); i++)
        {
            var webElement = accordionItems.get(i);

            try
            {
                ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", webElement);
                webElement.click();
                WebElement expandedBody = webElement.findElement(By.className("accordion__button"));
                boolean isExpanded = Boolean.parseBoolean(expandedBody.getAttribute("aria-expanded"));
                assertTrue("Element is not expanded", isExpanded);

                var desiredText = tips.length > i ? tips[i] : "";
                var displayedText = webElement.findElement(By.className("accordion__panel")).getText();
                assertTrue("Содержание не соответствует жизненным ожиданиям, индекс элемента " + i, displayedText.equals(desiredText));
            } catch (AssertionError e)
            {
                System.out.println(e);
                failed = true;
            }
        }
        assertFalse("Один или несколько првоерок упала(и)! Смотри сообщение выше", failed);
    }

    @After
    public void teardown() {
        // Закрой браузер
        webDriver.quit();
    }
}