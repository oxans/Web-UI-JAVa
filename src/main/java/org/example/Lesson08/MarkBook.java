package org.example.Lesson08;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class MarkBook {

    private SelenideElement reitingButton = $(By.xpath("//a[contains(text(),'Рейтинги')]"));
    private SelenideElement authorButton = $(By.xpath("//a[@href='/autor15']"));
    private SelenideElement bookButton = $(By.xpath("//div[contains(@onclick, 'selShow(this,10879')]"));
    private SelenideElement markBook = $(By.xpath("//*[@id=\"me_7\"]"));

    @Step("Go to Top")
    public MarkBook clickOnTop() {
        reitingButton.click();
        return this;
    }

    @Step("Go to Author")
    public  MarkBook clickOnAutor(){
        authorButton.click();
        return this;
    }
    @Step("Go to Book")
    public MarkBook clickOnBook(){
        bookButton.click();
        return this;
    }
    @Step("Mark book")
    public MainPage clickOnMark() {
        markBook.click();
        return page(MainPage.class);
    }
}
