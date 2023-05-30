package ru.qascooter.praktikumservices.pageobject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.assertEquals;


public class MainPage {
    private final WebDriver webDriver;
    //создаю локаторы и методы
    private static final By LOWER_ORDER_BUTTON_ID = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");
    private static final By HEADER_ORDER_BUTTON_ID = By.className("Button_Button__ra12g");
    private static final By FIRST_ACCORDION_BUTTON = By.id("accordion__heading-0");
    private static final By FIRST_ACCORDION_FIELD = By.id("accordion__panel-0");
    private static final By SECOND_ACCORDION_BUTTON = By.id("accordion__heading-1");
    private static final By SECOND_ACCORDION_FIELD = By.id("accordion__panel-1");
    private static final By THIRD_ACCORDION_BUTTON = By.id("accordion__heading-2");
    private static final By THIRD_ACCORDION_FIELD = By.id("accordion__panel-2");
    private static final By FOURTH_ACCORDION_BUTTON = By.id("accordion__heading-3");
    private static final By FOURTH_ACCORDION_FIELD = By.id("accordion__panel-3");
    private static final By FIFTH_ACCORDION_BUTTON = By.id("accordion__heading-4");
    private static final By FIFTH_ACCORDION_FIELD = By.id("accordion__panel-4");
    private static final By SIXTH_ACCORDION_BUTTON = By.id("accordion__heading-5");
    private static final By SIXTH_ACCORDION_FIELD = By.id("accordion__panel-5");
    private static final By SEVENTH_ACCORDION_BUTTON = By.id("accordion__heading-6");
    private static final By SEVENTH_ACCORDION_FIELD = By.id("accordion__panel-6");
    private static final By EIGHTH_ACCORDION_BUTTON = By.id("accordion__heading-7");
    private static final By EIGHTH_ACCORDION_FIELD = By.id("accordion__panel-7");

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    public void checkFirstAccordionField() {
        WebElement accordionFirstButton = webDriver.findElement(FIRST_ACCORDION_BUTTON); //ищем элемент
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", accordionFirstButton); //скроллим
        accordionFirstButton.click(); //кликаем
        var confirmTextElement = webDriver.findElement(FIRST_ACCORDION_FIELD);
        var confirmText = confirmTextElement.getText(); //получаем текст
        assertEquals("Текст не соответствует ожидаемому", "Сутки — 400 рублей. Оплата курьеру — наличными или картой.", confirmText);
    }
    public void checkSecondAccordionField() {
        WebElement accordionFirstButton = webDriver.findElement(SECOND_ACCORDION_BUTTON); //ищем элемент
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", accordionFirstButton); //скроллим
        accordionFirstButton.click(); //кликаем
        var confirmTextElement = webDriver.findElement(SECOND_ACCORDION_FIELD);
        var confirmText = confirmTextElement.getText(); //получаем текст
        assertEquals("Текст не соответствует ожидаемому", "Пока что у нас так: один заказ — один самокат. " +
                "Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", confirmText);
    }
    public void checkThirdAccordionField() {
        WebElement accordionFirstButton = webDriver.findElement(THIRD_ACCORDION_BUTTON); //ищем элемент
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", accordionFirstButton); //скроллим
        accordionFirstButton.click(); //кликаем
        var confirmTextElement = webDriver.findElement(THIRD_ACCORDION_FIELD);
        var confirmText = confirmTextElement.getText(); //получаем текст
        assertEquals("Текст не соответствует ожидаемому", "Допустим, вы оформляете заказ на 8 мая. " +
                "Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. " +
                "Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", confirmText);
    }
    public void checkFourthAccordionField() {
        WebElement accordionFirstButton = webDriver.findElement(FOURTH_ACCORDION_BUTTON); //ищем элемент
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", accordionFirstButton); //скроллим
        accordionFirstButton.click(); //кликаем
        var confirmTextElement = webDriver.findElement(FOURTH_ACCORDION_FIELD);
        var confirmText = confirmTextElement.getText(); //получаем текст
        assertEquals("Текст не соответствует ожидаемому", "Только начиная с завтрашнего дня. " +
                "Но скоро станем расторопнее.", confirmText);
    }
    public void checkFifthAccordionField() {
        WebElement accordionFirstButton = webDriver.findElement(FIFTH_ACCORDION_BUTTON); //ищем элемент
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", accordionFirstButton); //скроллим
        accordionFirstButton.click(); //кликаем
        var confirmTextElement = webDriver.findElement(FIFTH_ACCORDION_FIELD);
        var confirmText = confirmTextElement.getText(); //получаем текст
        assertEquals("Текст не соответствует ожидаемому", "Пока что нет! " +
                "Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", confirmText);
    }
    public void checkSixthAccordionField() {
        WebElement accordionFirstButton = webDriver.findElement(SIXTH_ACCORDION_BUTTON); //ищем элемент
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", accordionFirstButton); //скроллим
        accordionFirstButton.click(); //кликаем
        var confirmTextElement = webDriver.findElement(SIXTH_ACCORDION_FIELD);
        var confirmText = confirmTextElement.getText(); //получаем текст
        assertEquals("Текст не соответствует ожидаемому", "Самокат приезжает к вам с полной зарядкой. " +
                "Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", confirmText);
    }
    public void checkSeventhAccordionField() {
        WebElement accordionFirstButton = webDriver.findElement(SEVENTH_ACCORDION_BUTTON); //ищем элемент
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", accordionFirstButton); //скроллим
        accordionFirstButton.click(); //кликаем
        var confirmTextElement = webDriver.findElement(SEVENTH_ACCORDION_FIELD);
        var confirmText = confirmTextElement.getText(); //получаем текст
        assertEquals("Текст не соответствует ожидаемому", "Да, пока самокат не привезли. " +
                "Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", confirmText);
    }
    public void checkEigthAccordionField() {
        WebElement accordionFirstButton = webDriver.findElement(EIGHTH_ACCORDION_BUTTON); //ищем элемент
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", accordionFirstButton); //скроллим
        accordionFirstButton.click(); //кликаем
        var confirmTextElement = webDriver.findElement(EIGHTH_ACCORDION_FIELD);
        var confirmText = confirmTextElement.getText(); //получаем текст
        assertEquals("Текст не соответствует ожидаемому", "Да, обязательно. Всем самокатов! " +
                "И Москве, и Московской области.", confirmText);
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

