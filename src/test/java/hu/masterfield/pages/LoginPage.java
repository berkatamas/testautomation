package hu.masterfield.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.devtools.v112.indexeddb.model.Key;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginPage extends BasePage {
    SelenideElement usernameInput = $(byId("email"));
    SelenideElement passwordInput = $(byId("password"));
    SelenideElement loginButton = $(byClassName("button-primary"));

    public LoggedHomePage login() {
        log.info(username);
        log.info(password);
        usernameInput.setValue(username);
        passwordInput.setValue(password);
        loginButton.click();
        return new LoggedHomePage();
    }

}

