package ru.qascooter.praktikumservices.unit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static ru.qascooter.praktikumservices.config.AppConfig.APP_URL;

public class OrderFormLoader {
    public static WebDriver Load() {
        WebDriverManager.chromedriver().setup(); //устанавливаем веб-драйвер
        var webDriver = new ChromeDriver();
        webDriver.get(APP_URL); //открываем тестируемую страницу
        //webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //ставим таймаут на всякий
        webDriver.findElement(By.className("Button_Button__ra12g")).click();
        return webDriver;
    }
}
