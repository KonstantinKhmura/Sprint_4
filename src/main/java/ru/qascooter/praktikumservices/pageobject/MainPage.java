package ru.qascooter.praktikumservices.pageobject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    private final WebDriver webDriver;
    //создаю локаторы и методы
    private static final By LOWER_ORDER_BUTTON_ID = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");
    private static final By HEADER_ORDER_BUTTON_ID = By.className("Button_Button__ra12g");
    public MainPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }
    public WebElement getAccordionPanel(int index) {
        var accordion = webDriver.findElement(By.className("accordion"));
        return accordion.findElements(By.className("accordion__item")).get(index);
    }

    //создаю локатор и метод на верхнюю кнопку заказать
    public void findHeaderOrderButtonAndClick() {
        WebElement headerOrderButton = webDriver.findElement(HEADER_ORDER_BUTTON_ID);//находим элемент
        headerOrderButton.click(); //кликаем
    }

    //создаю локатор и метод на нижнюю кнопку заказать
    public void findLowerOrderButtonAndClick(){
        WebElement lowerOrderButton = webDriver.findElement(LOWER_ORDER_BUTTON_ID);//находим элемент
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView();", lowerOrderButton); //скроллим
        lowerOrderButton.click(); //кликаем
    }
}
