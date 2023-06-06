package hu.masterfield.steps;

import hu.masterfield.pages.BasePage;
import hu.masterfield.pages.HomePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

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

    @When("give the word {string}\"")
    public void giveTheWord(String arg0) throws Throwable {
        HomePage homePage = new HomePage();
        homePage.search(arg0);
        Thread.sleep(2000);
    }

    @Then("get the right result")
    public void getTheRightResult() {

    }
}
