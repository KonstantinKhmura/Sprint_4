package ru.qascooter.praktikum;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.qascooter.praktikumservices.pageobject.MainPage;
import ru.qascooter.praktikumservices.pageobject.OrderFirstForm;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;
import static ru.qascooter.praktikumservices.config.AppConfig.APP_URL;


@RunWith(Parameterized.class)
public class OrderFirstPageTest {
    private WebDriver webDriver; //устанавливаю переменные для параметризации
    private final String userName;
    private final String userSureName;
    private final String userAddress;
    private final String userStation;
    private final String userPhone;

    public OrderFirstPageTest(String userName, String userSureName, String userAddress, String userStation, String userPhone) {
        this.userName = userName;
        this.userSureName = userSureName;
        this.userAddress = userAddress;
        this.userStation = userStation;
        this.userPhone = userPhone;
    }

    @Parameterized.Parameters // устанавливаю значения для проверок
    public static Object[][] getUserData() {
        return new Object[][]{
                {"Иван", "Петров", "Москва", "Черкизовская", "88005553535"},
                {"Петр", "Иванов", "Санкт-Петербург", "Лихоборы", "84239379992"},
        };
    }

    @Before
    public void unit() {
        WebDriverManager.chromedriver().setup(); //устанавливаем веб-драйвер
        webDriver = new ChromeDriver();
        webDriver.get(APP_URL); //открываем тестируемую страницу
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //ставим таймаут на всякий
        MainPage.findHeaderOrderButtonAndClick(webDriver); //обращаемся к методу-помошнику из POM
    }
    @Test
    public void testOrderForm() {
        fillFirstForm(webDriver);
    }
    public void fillFirstForm(WebDriver webDriver){
        OrderFirstForm.findNameFieldAndSendKeys(webDriver, userName); //обращаемся к методу-помошнику из POM
        OrderFirstForm.findSureNameFieldAndSendKeys(webDriver, userSureName); //обращаемся к методу-помошнику из POM
        OrderFirstForm.findAddressFieldAndSendKeys(webDriver, userAddress); //обращаемся к методу-помошнику из POM
        OrderFirstForm.selectStation(webDriver, userStation); //обращаемся к методу-помошнику из POM
        OrderFirstForm.findPhoneFieldAndSendKeys(webDriver, userPhone); //обращаемся к методу-помошнику из POM
        OrderFirstForm.findNextButtonAndClick(webDriver); //обращаемся к методу-помошнику из POM

        //проверка
        var isDisplayed = webDriver.findElement(By.className("Order_Header__BZXOb")).isDisplayed(); //получаем свойство isDisplayed
        assertTrue("Элемент не отображается", isDisplayed); //проверили
    }

    @After
    public void teardown() {
        // Закрой браузер
        webDriver.quit();
    }
}