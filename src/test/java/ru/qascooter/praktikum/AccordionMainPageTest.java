package ru.qascooter.praktikum;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.qascooter.praktikumservices.pageobject.MainPage;
import java.util.concurrent.TimeUnit;
import static ru.qascooter.praktikumservices.config.AppConfig.APP_URL;

public class AccordionMainPageTest {
    private WebDriver webDriver;

    @Before
    public void openMainPage(){
        WebDriverManager.chromedriver().setup(); //устанавливаем веб-драйвер
        webDriver = new ChromeDriver();
        webDriver.get(APP_URL); //открываем тестируемую страницу
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //ставим таймаут на всякий случай
    }
    @Test
    public void checkFirstFieldOfAccordion (){
        var mainPage = new MainPage(webDriver);
        mainPage.checkFirstAccordionField();
    }
    @Test
    public void checkSecondFieldOfAccordion (){
        var mainPage = new MainPage(webDriver);
        mainPage.checkSecondAccordionField();
    }
    @Test
    public void checkThirdFieldOfAccordion (){
        var mainPage = new MainPage(webDriver);
        mainPage.checkThirdAccordionField();
    }
    @Test
    public void checkFourthFieldOfAccordion (){
        var mainPage = new MainPage(webDriver);
        mainPage.checkFourthAccordionField();
    }
    @Test
    public void checkFifthFieldOfAccordion (){
        var mainPage = new MainPage(webDriver);
        mainPage.checkFifthAccordionField();
    }
    @Test
    public void checkSixthFieldOfAccordion (){
        var mainPage = new MainPage(webDriver);
        mainPage.checkSixthAccordionField();
    }
    @Test
    public void checkSeventhFieldOfAccordion (){
        var mainPage = new MainPage(webDriver);
        mainPage.checkSeventhAccordionField();
    }
    @Test
    public void checkEighthFieldOfAccordion (){
        var mainPage = new MainPage(webDriver);
        mainPage.checkEigthAccordionField();
    }

    @After
    public void teardown() {
        // Закрой браузер
        webDriver.quit();
    }
}