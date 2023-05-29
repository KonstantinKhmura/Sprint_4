package ru.qascooter.praktikum;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.qascooter.praktikumservices.pageobject.MainPage;
import ru.qascooter.praktikumservices.pageobject.UserForm;
import ru.qascooter.praktikumservices.pageobject.OrderForm;
import java.util.concurrent.TimeUnit;
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
    public void openMainPage(){
        WebDriverManager.chromedriver().setup(); //устанавливаем веб-драйвер
        webDriver = new ChromeDriver();
        webDriver.get(APP_URL); //открываем тестируемую страницу
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //ставим таймаут на всякий случай
    }
    @Test
    public void testOrderFormHeaderButton() {       //решил не объединять методы в POM в два больших метода.
        var mainPage = new MainPage(webDriver);     //Возможность объединения - увидел, но методы получается громоздкими.
        var userForm = new UserForm(webDriver);     //К тому же такое оформление показывалось на вебинаре (небольшие методы).
        var orderForm = new OrderForm(webDriver);
        mainPage.findHeaderOrderButtonAndClick();
        userForm.setName(userName);
        userForm.setSureName(userSureName);
        userForm.setAddress(userAddress);
        userForm.selectStation(userStation);
        userForm.setPhone(userPhone);
        userForm.clickNextButton();
        orderForm.setDeliveryDate(deliveryDate);
        orderForm.setRentTime();
        orderForm.selectScooterColor();
        orderForm.setComment(comment);
        orderForm.order();
        orderForm.confirm();
        orderForm.checkOrderIsComplete();
    }

    @Test
    public void testOrderFormLowerButton() {
        var mainPage = new MainPage(webDriver);
        var orderFirstForm = new UserForm(webDriver);
        var orderSecondForm = new OrderForm(webDriver);
        mainPage.findLowerOrderButtonAndClick();
        orderFirstForm.setName(userName);
        orderFirstForm.setSureName(userSureName);
        orderFirstForm.setAddress(userAddress);
        orderFirstForm.selectStation(userStation);
        orderFirstForm.setPhone(userPhone);
        orderFirstForm.clickNextButton();
        orderSecondForm.setDeliveryDate(deliveryDate);
        orderSecondForm.setRentTime();
        orderSecondForm.selectScooterColor();
        orderSecondForm.setComment(comment);
        orderSecondForm.order();
        orderSecondForm.confirm();
        orderSecondForm.checkOrderIsComplete();
    }

    @After
    public void teardown() {
        // Закрой браузер
        webDriver.quit();
    }
}
