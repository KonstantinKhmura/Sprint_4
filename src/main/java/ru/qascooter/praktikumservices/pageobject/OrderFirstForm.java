package ru.qascooter.praktikumservices.pageobject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.assertTrue;

public class OrderFirstForm {
    //задаю локаторы
    private static final By NAME_FIELD_ID = By.cssSelector("[placeholder='* Имя']");
    private static final By SURE_NAME_FIELD_ID = By.cssSelector("[placeholder='* Фамилия']");
    private static final By ADDRESS_FIELD_ID = By.cssSelector("[placeholder='* Адрес: куда привезти заказ']");
    private static final By STATION_FIELD_ID = By.cssSelector("[placeholder='* Станция метро']");
    private static final By PHONE_FIELD_ID = By.cssSelector("[placeholder='* Телефон: на него позвонит курьер'] ");
    private static final By NEXT_BUTTON_ID = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");
    private final WebDriver webDriver;

    public OrderFirstForm(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public static By getUserStationId(String userStation){
        return By.xpath("//div[contains(text(), '" + userStation + "')]");
    }

    //задаю методы к локаторам

    public void setName(String name) {
        WebElement nameField = webDriver.findElement(NAME_FIELD_ID);
        nameField.sendKeys(name);
    }
    public void setSureName(String sureName) {
        WebElement sureNameField = webDriver.findElement(SURE_NAME_FIELD_ID);
        sureNameField.sendKeys(sureName);
    }
    public void setAddress(String address) {
        WebElement addressField = webDriver.findElement(ADDRESS_FIELD_ID);
        addressField.sendKeys(address);
    }
    public void selectStation (String station){
        WebElement stationField = webDriver.findElement(STATION_FIELD_ID);
        stationField.click();
        stationField.sendKeys(station);
        WebElement dropdownOption = webDriver.findElement(getUserStationId(station));
        dropdownOption.click();
    }
    public void setPhone(String phone) {
        WebElement phoneField = webDriver.findElement(PHONE_FIELD_ID);
        phoneField.sendKeys(phone);
    }
    public void clickNextButton() {
        WebElement nextButton = webDriver.findElement(NEXT_BUTTON_ID);
        nextButton.click();
    }
    public void secondFormIsDisplayed(){
        var isDisplayed = webDriver.findElement(By.className("Order_Form__17u6u")).isDisplayed(); //получаем свойство isDisplayed
        assertTrue("Элемент не отображается", isDisplayed); //проверяем, что открылась следующая страница и отображается форма заказа
    }
    public void checkFirstFormIsOpen(){
        var isSecondDisplayed = webDriver.findElement(By.className("Order_Header__BZXOb")).isDisplayed(); //получаем свойство isDisplayed
        assertTrue("Элемент не отображается", isSecondDisplayed); //проверили
    }
}
