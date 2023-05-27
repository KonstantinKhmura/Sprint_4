package ru.qascooter.praktikum;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//создаю один тест-сьют для общего запуска всех тестов
@RunWith(Suite.class)
@Suite.SuiteClasses({
        AccordionMainPageTest.class,
        HeaderOrderButtonTest.class,
        LowerSecondButtonTest.class,
        OrderFirstPageTest.class,
        OrderSecondPageTest.class,
})

public class TestSuite {

}

