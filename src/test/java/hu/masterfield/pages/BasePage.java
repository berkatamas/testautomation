package hu.masterfield.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.WebDriverRunner.url;

public class BasePage {
    public void isLoaded(SelenideElement element) {
        element.shouldBe(Condition.visible);
    }

    public void isInteractable(SelenideElement element) {
        element.shouldBe(Condition.enabled);
    }
    public String getURL() {
        return url();
    }
}
