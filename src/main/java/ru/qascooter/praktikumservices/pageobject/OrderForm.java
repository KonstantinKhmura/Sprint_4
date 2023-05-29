package ru.qascooter.praktikumservices.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.assertEquals;

public class OrderForm {
    //задаю локаторы
    private static final By DELIVERY_DATE_FIELD_ID = By.cssSelector("[placeholder='* Когда привезти самокат']");
    private static final By RENT_TIME_FIELD_ID = By.className("Dropdown-placeholder");
    private static final By DROPDOWN_OPTION_ID = By.xpath("//div[text()='сутки']");
    private static final By COLOR_FIELD_ID = By.id("black");
    private static final By COMMENT_FIELD_ID = By.cssSelector("input[placeholder='Комментарий для курьера']");
    private static final By ORDER_BUTTON_ID = By.xpath("//div[2]/div[3]/button[2]"); //сократил. поиск по другим элементам не находит эту кнопку из-за наличия другой кнопки "Заказать" на странице и кнопки "Назад"
    private static final By AGREE_BUTTON_ID = By.xpath("//button[text()='Да']");
    private static final By ORDER_COMPLETE_ID = By.className("Order_ModalHeader__3FDaJ");
    private final WebDriver webDriver;

    public OrderForm(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    //задаю методы к локаторам
    public void setDeliveryDate(String date) {
        WebElement deliveryDateField = webDriver.findElement(DELIVERY_DATE_FIELD_ID);
        deliveryDateField.sendKeys(date);
        deliveryDateField.sendKeys(Keys.ENTER);
    }
    public void setRentTime() {
        WebElement rentTimeField = webDriver.findElement(RENT_TIME_FIELD_ID);
        rentTimeField.click();
        WebElement dropdownOption = webDriver.findElement(DROPDOWN_OPTION_ID);
        dropdownOption.click();
    }
    public void selectScooterColor() {
        WebElement colorField = webDriver.findElement(COLOR_FIELD_ID);
        colorField.click();
    }
    public void setComment(String comment) {
        WebElement commentField = webDriver.findElement(COMMENT_FIELD_ID);
        commentField.sendKeys(comment);
    }
    public void order() {
        WebElement orderButton = webDriver.findElement(ORDER_BUTTON_ID);
        orderButton.click();
    }
    public void confirm() {
        WebElement agreeButton = webDriver.findElement(AGREE_BUTTON_ID);
        agreeButton.click();
    }
    public void checkOrderIsComplete(){
        var confirmTextElement = webDriver.findElement(ORDER_COMPLETE_ID); //нашли элемент "Заказ оформлен. Заменил локатор в "Заказ оформлен". Был неверный
        var confirmText = confirmTextElement.getText(); //получаем текст
        assertEquals("Текст не соответствует ожидаемому", "Заказ оформлен", confirmText); //проверили, что заказ Оформлен
    }
}
