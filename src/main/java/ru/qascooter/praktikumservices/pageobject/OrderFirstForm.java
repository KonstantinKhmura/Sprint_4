package ru.qascooter.praktikumservices.pageobject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderFirstForm {
    //задаю локаторы
    private static final By nameFieldID = By.cssSelector("[placeholder='* Имя']");
    private static final By sureNameFieldID = By.cssSelector("[placeholder='* Фамилия']");
    private static final By addressFieldID = By.cssSelector("[placeholder='* Адрес: куда привезти заказ']");
    private static final By stationFieldID = By.cssSelector("[placeholder='* Станция метро']");
    private static final By dropdownOptionID = By.xpath("//div[contains(text()]");
    private static final By phoneFieldID = By.cssSelector("[placeholder='* Телефон: на него позвонит курьер']");
    private static final By nextButtonID = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");

    public static By getUserStationId(String userStation){
        return By.xpath("//div[contains(text(), '" + userStation + "')]");
    }

    //задаю методы к локаторам

    public static void findNameFieldAndSendKeys(WebDriver webDriver, String name) {
        WebElement nameField = webDriver.findElement(nameFieldID);
        nameField.sendKeys(name);
    }
    public static void findSureNameFieldAndSendKeys(WebDriver webDriver, String sureName) {
        WebElement sureNameField = webDriver.findElement(sureNameFieldID);
        sureNameField.sendKeys(sureName);
    }
    public static void findAddressFieldAndSendKeys(WebDriver webDriver, String address) {
        WebElement addressField = webDriver.findElement(addressFieldID);
        addressField.sendKeys(address);
    }
    public static void selectStation (WebDriver webDriver, String station){
        WebElement stationField = webDriver.findElement(stationFieldID);
        stationField.click();
        stationField.sendKeys(station);
        WebElement dropdownOption = webDriver.findElement(getUserStationId(station));
        dropdownOption.click();
    }
    public static void findPhoneFieldAndSendKeys(WebDriver webDriver, String phone) {
        WebElement phoneField = webDriver.findElement(phoneFieldID);
        phoneField.sendKeys(phone);
    }
    public static void findNextButtonAndClick(WebDriver webDriver) {
        WebElement nextButton = webDriver.findElement(nextButtonID);
        nextButton.click();
    }

}
