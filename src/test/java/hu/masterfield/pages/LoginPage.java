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
    SelenideElement language = $(byXpath("//*[@id=\"utility-header-language-switch-link\"]/span/span"));


    public void openPage() {
        open(websiteURL);
        isLoaded(acceptCookies);
    }

    public void acceptCookies() throws InterruptedException {
        acceptCookies.hover();
        Thread.sleep(2000);
        acceptCookies.click();
    }

    public void getLanguage(){
        if(language.getText().equals("Magyar")){
            language.click();
        }
    }


}

