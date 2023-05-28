package ru.qascooter.praktikumservices.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderSecondForm {
    //задаю локаторы
    private static final By DELIVERY_DATE_FIELD_ID = By.cssSelector("[placeholder='* Когда привезти самокат']");
    private static final By RENT_TIME_FIELD_ID = By.xpath("//div[@class='Dropdown-placeholder']");
    private static final By DROPDOWN_OPTION_ID = By.xpath("//div[@class='Dropdown-option'][text()='сутки']");
    private static final By COLOR_FIELD_ID = By.xpath("//label[@for='black' and text()='чёрный жемчуг']");
    private static final By COMMENT_FIELD_ID = By.xpath("//input[@type='text' and @class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='Комментарий для курьера']");
    private static final By ORDER_BUTTON_ID = By.xpath("/html/body/div/div/div[2]/div[3]/button[2]");
    private static final By AGREE_BUTTON_ID = By.xpath("/html/body/div/div/div[2]/div[5]/div[2]/button[2]");
    private final WebDriver webDriver;

    public OrderSecondForm(WebDriver webDriver){
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
        WebElement orderPanel = webDriver.findElement(By.className("Order_Content__bmtHS"));
        WebElement orderButton = orderPanel.findElement(ORDER_BUTTON_ID);
        orderButton.click();
    }
    public void confirm() {
        WebElement confirmPanel = webDriver.findElement(By.className("Order_Modal__YZ-d3"));
        WebElement agreeButton = confirmPanel.findElement(AGREE_BUTTON_ID);
        agreeButton.click();
    }
}
