package hu.masterfield.steps;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import hu.masterfield.pages.BasePage;
import hu.masterfield.pages.HomePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import java.io.IOException;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class search {

    @Before
    public void setup() throws IOException {
        BasePage basePage = new BasePage();
        basePage.setup();
    }

    @After
    public void waitFor() throws InterruptedException {
        Thread.sleep(3000);
        getWebDriver().quit();
    }


    @When("give the word {string}")
    public void giveTheWord(String arg0) throws InterruptedException {
        HomePage homePage = new HomePage();
        homePage.search(arg0);
        Thread.sleep(2000);
    }


    @Then("get the right result with the word {string}")
    public void getTheRightResultWithTheWord(String arg0) {
        BasePage basePage = new BasePage();
        try {
            SelenideElement searchResult = $(byClassName("product-list"));
            if (searchResult.exists()) {
                int newLineIndex = searchResult.getText().indexOf('\n');
                if (newLineIndex != -1) {
                    String searchResultPart = searchResult.getText().substring(0, newLineIndex);
                    basePage.log.info("Keresett szó: " + arg0);
                    basePage.log.info("Első találat termék neve: " + searchResultPart);
                }
            } else {
                basePage.log.info("Nincs találat");
            }
        } catch (ElementNotFound e) {
            basePage.log.info("Nincs találat a következő szóra: " + arg0);
        }
    }
}
