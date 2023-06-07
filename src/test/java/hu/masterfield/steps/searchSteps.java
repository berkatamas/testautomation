package hu.masterfield.steps;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import hu.masterfield.pages.BasePage;
import hu.masterfield.pages.HomePage;
import hu.masterfield.pages.SearchResultPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class searchSteps {
    HomePage homePage = new HomePage();
    SearchResultPage searchResultPage = new SearchResultPage();

    @Before
    public void setup() throws IOException {
        BasePage basePage = new BasePage();
        basePage.setup();
    }

    // minden keresés után várjon egy kicsit, hogy vizuálisan is ellenőrizni lehessen az eredményt
    @After
    public void waitFor() throws InterruptedException {
        Thread.sleep(2000);
        getWebDriver().quit();
    }

    @When("search with the word {string}")
    public void searchWithTheWord(String searchWord) {
        searchResultPage = homePage.search(searchWord);
    }

    @Then("get title with the word {string}")
    public void getTitleWithTheWord(String searchWord) {
        searchResultPage.searchResultTitle(searchWord);
    }

    @And("product names in the result list contains the word {string}")
    public void productNamesInTheResultListContainsTheWord(String searchWord) throws InterruptedException {
        searchResultPage.searchResult(searchWord);
    }
}
