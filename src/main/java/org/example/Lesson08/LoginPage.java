package org.example.Lesson08;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;


public class LoginPage {

    private SelenideElement loginInput = $(By.xpath("//input[@placeholder='логин']"));

    private SelenideElement passwordInput = $(By.xpath("//input[@placeholder='пароль']"));

    private  SelenideElement logginButtom = $(By.xpath("//button[@class='btn btn-default btn-xs']"));

    @Step("Fill login")
    public LoginPage fillLogin (String login) {
        loginInput.sendKeys(login);
        return this;
    }

    @Step("Fill password")
    public LoginPage fillPassword (String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    @Step("Click on button")
    public MainPage clickLoginButton() {
        logginButtom.click();
        return  page(MainPage.class);
    }

}
