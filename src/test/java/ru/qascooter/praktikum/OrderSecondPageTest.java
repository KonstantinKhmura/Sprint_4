package ru.qascooter.praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.qascooter.praktikumservices.pageobject.OrderSecondForm;
import ru.qascooter.praktikumservices.unit.OrderFormLoader;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderSecondPageTest {
    private WebDriver webDriver; //устанавливаю переменные для параметризации
    private final String deliveryDate;
    private final String comment;
        public OrderSecondPageTest(String deliveryDate, String comment) {
            this.deliveryDate = deliveryDate;
            this.comment = comment;
        }

        @Parameterized.Parameters // устанавливаю значения для проверок
        public static Object[][] getUserData() {
            return new Object[][]{
                    {"27.05.2023", "Доставить быстро"},
                    {"27.06.2023","How u doing?"},
            };
        }

    @Test
    public void firstPageIsDone() {
            OrderFirstPageTest orderFirstPageTest = new OrderFirstPageTest("Иван", "Петров", "Москва", "Черкизовская", "88005553535");
            var webDriver = OrderFormLoader.Load();
            orderFirstPageTest.fillFirstForm(webDriver);
            OrderSecondForm.deliveryDateFieldAndSendKeys(webDriver, deliveryDate);  //обращаемся к методу-помошнику из POM
            OrderSecondForm.rentTimeFieldAndSendKeys(webDriver);  //обращаемся к методу-помошнику из POM
            OrderSecondForm.dropdownOptionAndSendKeys(webDriver);  //обращаемся к методу-помошнику из POM
            OrderSecondForm.colorFieldAndSendKeys(webDriver);  //обращаемся к методу-помошнику из POM
            OrderSecondForm.commentFieldAndClick(webDriver, comment);  //обращаемся к методу-помошнику из POM
            OrderSecondForm.orderButtonAndClick(webDriver); //обращаемся к методу-помошнику из POM
            OrderSecondForm.agreeButton(webDriver); //обращаемся к методу-помошнику из POM

        //проверка. на хроме не рабоатет (баг)
        //проверка
        var isDisplayed = webDriver.findElement(By.className("Order_ModalHeader__3FDaJ")).isDisplayed(); //получаем свойство isDisplayed
        assertTrue("Элемент не отображается", isDisplayed); //проверили
    }
}
