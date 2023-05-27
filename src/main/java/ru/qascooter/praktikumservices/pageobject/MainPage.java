package ru.qascooter.praktikumservices.pageobject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {

    //создаю локатор и метод на аккордеон
    private static final String accordionItemTag = "accordion__item";
    private static final By lowerOrderButtonID = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");
    private static final By headerOrderButtonID = By.className("Button_Button__ra12g");
    public By getAccordionPanel() {
        return By.id(accordionItemTag);
    }

    //создаю локатор и метод на верхнюю кнопку заказать
    public static void findHeaderOrderButtonAndClick(WebDriver webDriver) {
        WebElement headerOrderButton = webDriver.findElement(headerOrderButtonID);//находим элемент
        headerOrderButton.click(); //кликаем
    }

    //создаю локатор и метод на нижнюю кнопку заказать
    public static void findLowerOrderButtonAndClick(WebDriver webDriver){
        WebElement lowerOrderButton = webDriver.findElement(lowerOrderButtonID);//находим элемент
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView();", lowerOrderButton); //скроллим
        lowerOrderButton.click(); //кликаем
    }
}
