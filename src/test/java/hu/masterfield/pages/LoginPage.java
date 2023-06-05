package hu.masterfield.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginPage extends BasePage {

    SelenideElement acceptCookies = $(byClassName("beans-cookies-notification__button beans-button__container"));
    //SelenideElement userNameInput = $(byId("user-name"));
    //SelenideElement passwordInput = $(byId("password"));
    //SelenideElement loginButton = $(byId("login-button"));

    public void openPage() {
        open("https://bevasarlas.tesco.hu");
        isLoaded(acceptCookies);
    }

    public void acceptCookies(){
        acceptCookies.click();
    }


}

