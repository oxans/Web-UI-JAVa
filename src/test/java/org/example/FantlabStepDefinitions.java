package org.example;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Lesson08.MainPage;
import org.example.Lesson08.LoginPage;
import org.example.Lesson08.MarkBook;


public class FantlabStepDefinitions {
    @Given("^User login on cite$")
    public  void loginToFantlab(){
        Selenide.open("https://fantlab.ru/");
        new MainPage()
                .fillLogin("test_test");
                .fillPassword("Test123456");
                .clickLoginButton();
    }

    @When("^User mark a book$")
    public void userMarkBook(){
        new MainPage()
                .clickOnTop();
                .clickOnAutor();
                .clickOnBook();
                .clickOnMark();

    }

    @After(value = "@close_brower")
    public void after() {
        Selenide.closeWebDriver();
    }


}
