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

    SelenideElement acceptCookies = $(byXpath("//*[@id=\"sticky-bar-cookie-wrapper\"]/span/div/div/div[2]/form[1]/button/span/span"));

    public void openPage() {
        open("https://bevasarlas.tesco.hu");
        isLoaded(acceptCookies);
    }

    public void acceptCookies() throws InterruptedException {
        acceptCookies.hover();
        Thread.sleep(1000);
        acceptCookies.click();
    }


}

