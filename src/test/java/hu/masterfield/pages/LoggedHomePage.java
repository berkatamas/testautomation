package hu.masterfield.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class LoggedHomePage extends BasePage{
    SelenideElement userAccountLink = $(byId("utility-header-account-link"));

    public UserAccountPage openUserAccount(){
        userAccountLink.click();

        return new UserAccountPage();
    }
}
