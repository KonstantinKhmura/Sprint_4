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
import ru.qascooter.praktikumservices.pageobject.OrderSecondForm;

import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertTrue;
import static ru.qascooter.praktikumservices.config.AppConfig.APP_URL;

@RunWith(Parameterized.class)
public class OrderTest {
    private WebDriver webDriver;
    private final String userName;
    private final String userSureName;
    private final String userAddress;
    private final String userStation;
    private final String userPhone;
    private final String deliveryDate;
    private final String comment;
    public OrderTest(String userName, String userSureName, String userAddress,
                     String userStation, String userPhone, String deliveryDate, String comment) {
        this.userName = userName;
        this.userSureName = userSureName;
        this.userAddress = userAddress;
        this.userStation = userStation;
        this.userPhone = userPhone;
        this.deliveryDate = deliveryDate;
        this.comment = comment;
    }
    @Parameterized.Parameters // устанавливаю значения для проверок
    public static Object[][] getUserData() {
        return new Object[][]{
                {"Иван", "Петров", "Москва", "Черкизовская", "88005553535", "27.05.2023", "Доставить быстро"},
                {"Петр", "Иванов", "Санкт-Петербург", "Лихоборы", "84239379992", "27.06.2023","How u doing?"},
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
    public void testOrderFormHeaderButton() {
        var mainPage = new MainPage(webDriver);
        mainPage.findHeaderOrderButtonAndClick(); //обращаемся к методу-помошнику из POM
        var isDisplayed = webDriver.findElement(By.className("Order_Form__17u6u")).isDisplayed(); //получаем свойство isDisplayed
        assertTrue("Элемент не отображается", isDisplayed); //проверяем, что открылась следующая страница и отображается форма заказа

        testOrderForm();
    }
    @Test
    public void testOrderFormLowerButton() {
        var mainPage = new MainPage(webDriver);
        mainPage.findLowerOrderButtonAndClick(); //обращаемся к методу-помошнику из POM
        var isDisplayed = webDriver.findElement(By.className("Order_Form__17u6u")).isDisplayed(); //получаем свойство isDisplayed
        assertTrue("Элемент не отображается", isDisplayed); //проверяем, что открылась следующая страница и отображается форма заказа

        testOrderForm();
    }

    public void testOrderForm() {
        fillFirstForm();

        var isSecondDisplayed = webDriver.findElement(By.className("Order_Header__BZXOb")).isDisplayed(); //получаем свойство isDisplayed
        assertTrue("Элемент не отображается", isSecondDisplayed); //проверили

        fillSecondForm();

        //проверка. на хроме не рабоатет (баг)
        var isConfirmDisplayed = webDriver.findElement(By.className(".Button_Button__ra12g.Button_Middle__1CSJM")).isDisplayed(); //получаем свойство isDisplayed
        assertTrue("Элемент не отображается", isConfirmDisplayed); //проверили, что открылось окно с кнопкой "Посомтреть заказ"
    }
    public void fillFirstForm(){
        var orderFirstForm = new OrderFirstForm(webDriver);
        orderFirstForm.setName(userName); //обращаемся к методу-помошнику из POM
        orderFirstForm.setSureName(userSureName); //обращаемся к методу-помошнику из POM
        orderFirstForm.setAddress(userAddress); //обращаемся к методу-помошнику из POM
        orderFirstForm.selectStation(userStation); //обращаемся к методу-помошнику из POM
        orderFirstForm.setPhone(userPhone); //обращаемся к методу-помошнику из POM
        orderFirstForm.clickNextButton(); //обращаемся к методу-помошнику из POM
    }
    public void fillSecondForm() {
        var orderSecondForm = new OrderSecondForm(webDriver);
        orderSecondForm.setDeliveryDate("27.05.2023");  //обращаемся к методу-помошнику из POM
        orderSecondForm.setRentTime();  //обращаемся к методу-помошнику из POM
        orderSecondForm.selectScooterColor();  //обращаемся к методу-помошнику из POM
        orderSecondForm.setComment("Доставить быстро");  //обращаемся к методу-помошнику из POM
        orderSecondForm.order(); //обращаемся к методу-помошнику из POM
        orderSecondForm.confirm(); //обращаемся к методу-помошнику из POM
    }
    @After
    public void teardown() {
        // Закрой браузер
        webDriver.quit();
}
}
