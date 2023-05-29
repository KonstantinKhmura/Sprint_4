package ru.qascooter.praktikumservices.pageobject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import static java.awt.SystemColor.text;
import static org.junit.Assert.assertTrue;

public class MainPage {
    private final WebDriver webDriver;
    //создаю локаторы и методы
    private static final By LOWER_ORDER_BUTTON_ID = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");
    private static final By HEADER_ORDER_BUTTON_ID = By.className("Button_Button__ra12g");

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public WebElement getAccordionPanel(int index) {
        var accordion = webDriver.findElement(By.className("accordion"));
        return accordion.findElements(By.className("accordion__item")).get(index);

    }
    //создаю методы для полей аккордеона
    public void accordionButton() {
        WebElement accordionButton = webDriver.findElement(By.className("accordion__button")); //ищем элемент
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", accordionButton); //скроллим
        accordionButton.click(); //кликаем
        boolean isExpanded = Boolean.parseBoolean(accordionButton.getAttribute("aria-expanded")) == true;  //получаем свойство атрибута со свойством true
        assertTrue("Элемент не расскрыт", isExpanded); //проверяем на раскрытие
    }
    public List<WebElement> getAccordionPanels()
    {
        var accordion = webDriver.findElement(By.className("accordion"));
        return accordion.findElements(By.className("accordion__item"));
    }

    public void accordionFieldFirst() {
        var displayedText = webDriver.findElement(By.className("accordion__panel")).getText();
        assertTrue("Содержание не соответствует жизненным ожиданиям", displayedText.equals(text));
    }

        //создаю локатор и метод на верхнюю кнопку заказать
        public void findHeaderOrderButtonAndClick () {
            WebElement headerOrderButton = webDriver.findElement(HEADER_ORDER_BUTTON_ID);//находим элемент
            headerOrderButton.click(); //кликаем
        }

        //создаю локатор и метод на нижнюю кнопку заказать
        public void findLowerOrderButtonAndClick () {
            WebElement lowerOrderButton = webDriver.findElement(LOWER_ORDER_BUTTON_ID);//находим элемент
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", lowerOrderButton); //скроллим
            lowerOrderButton.click(); //кликаем
        }
    }

