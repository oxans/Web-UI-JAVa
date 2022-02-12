package org.example.Lesson08;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private SelenideElement loginButton = $(By.xpath("\"//button[@class='btn btn-default btn-xs']\""));

    @Step("Login")
    public LoginPage clickLoginButton(){
        loginButton.click();
        return page(LoginPage.class);
    }

    private SelenideElement markBook = $(By.xpath("//*[@id=\"me_7\"]"));

    @Step("Mark book")
    public MarkBook clickOnMark(){
        markBook.click();
        return page(MarkBook.class);
    }

}
