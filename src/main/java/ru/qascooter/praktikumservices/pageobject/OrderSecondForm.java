package ru.qascooter.praktikumservices.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderSecondForm {
    //задаю локаторы
    private static final By deliveryDateFieldID = By.cssSelector("[placeholder='* Когда привезти самокат']");
    private static final By rentTimeFieldID = By.xpath("//div[@class='Dropdown-placeholder']");
    private static final By dropdownOptionID = By.xpath("//div[@class='Dropdown-option'][text()='сутки']");
    private static final By colorFieldID = By.xpath("//label[@for='black' and text()='чёрный жемчуг']");
    private static final By commentFieldID = By.xpath("//input[@type='text' and @class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='Комментарий для курьера']");
    private static final By orderButtonID = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");
    private static final By agreeButtonID = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");

    //задаю методы к локаторам

    public static void deliveryDateFieldAndSendKeys(WebDriver webDriver, String date) {
        WebElement deliveryDateField = webDriver.findElement(deliveryDateFieldID);
        deliveryDateField.sendKeys(date);
        deliveryDateField.sendKeys(Keys.ENTER);
    }
    public static void rentTimeFieldAndSendKeys(WebDriver webDriver) {
        WebElement rentTimeField = webDriver.findElement(rentTimeFieldID);
        rentTimeField.click();
    }
    public static void dropdownOptionAndSendKeys(WebDriver webDriver) {
        WebElement dropdownOption = webDriver.findElement(dropdownOptionID);
        dropdownOption.click();
    }
    public static void colorFieldAndSendKeys(WebDriver webDriver) {
        WebElement colorField = webDriver.findElement(colorFieldID);
        colorField.click();
    }
    public static void commentFieldAndClick(WebDriver webDriver, String comment) {
        WebElement commentField = webDriver.findElement(commentFieldID);
        commentField.sendKeys(comment);
    }
    public static void orderButtonAndClick(WebDriver webDriver) {
        WebElement orderButton = webDriver.findElement(orderButtonID);
        orderButton.click();
    }
    public static void agreeButton(WebDriver webDriver) {
        WebElement agreeButton = webDriver.findElement(agreeButtonID);
        agreeButton.click();
    }
}
