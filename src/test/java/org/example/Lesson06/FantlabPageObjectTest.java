package org.example.Lesson06;


import io.github.bonigarcia.wdm.WebDriverManager;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.util.Iterator;


@Story("Work this a book")
public class FantlabPageObjectTest {
    WebDriver driver;
    private final static String FANTLAB_URL = "https://fantlab.ru/";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver();
        driver.get(FANTLAB_URL);
    }

    @Test
    @Feature("Mark book")
    @Description("Mark Book")
    void markBook(){
        new MainPage(driver)
                .fillLogin("test_test")
                .fillPassword("Test123456")
                .clickLoginButton()
                .clickOnTop()
                .clickOnAutor()
                .clickOnBook()
                .clickOnMark();

    }


    @AfterEach
    void killDriver(){
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        Iterator<LogEntry> iterator = logEntries.iterator();

        while (iterator.hasNext()) {
            Allure.addAttachment("Лог браузера:", iterator.next().getMessage());
        }

        for (LogEntry log: logEntries) {
            Allure.addAttachment("Лог браузера:", log.getMessage());
        }



        driver.quit();
    }

}
