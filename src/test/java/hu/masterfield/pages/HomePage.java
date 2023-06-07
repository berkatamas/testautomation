package hu.masterfield.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomePage extends BasePage{

    SelenideElement acceptCookies = $(byXpath("//*[@id=\"sticky-bar-cookie-wrapper\"]/span/div/div/div[2]/form[1]/button/span/span"));
    SelenideElement language = $(byXpath("//*[@id=\"utility-header-language-switch-link\"]/span/span"));
    SelenideElement loginStartButton = $(byClassName("signin-register--signin-button"));
    SelenideElement searchInput = $(byId("search-input"));
    SelenideElement searchButton = $(byClassName("search-bar__submit"));


    public void openPage() {
        open(websiteURL);
        isLoaded(acceptCookies);
    }

    public void acceptCookies() throws InterruptedException {
        acceptCookies.click();
    }

    public String getLanguage(){
        return language.getText();
    }

    public void setLanguage(){
        if(language.getText().equals("Magyar")){
            language.click();
        }
    }

    public LoginPage loginStart(){
        loginStartButton.click();

        return new LoginPage();
    }

    public SearchResultPage search(String searchText){
        searchInput.setValue(searchText);
        searchButton.click();

        return new SearchResultPage();
    }

}
