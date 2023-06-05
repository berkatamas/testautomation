package hu.masterfield.steps;

import hu.masterfield.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class loginSteps {
    LoginPage loginPage = new LoginPage();

    @Given("open main page")
    public void openMainPage() {
        loginPage.openPage();
        getWebDriver().manage().window().maximize();
    }

    @And("accept cookies")
    public void acceptCookies() throws InterruptedException {
        loginPage.acceptCookies();
    }

    @Given("language is set to {string}")
    public void languageIsSetTo(String arg0) {
    }

    @When("change the language to {string}")
    public void changeTheLanguageTo(String arg0) {
    }

    @Then("it shows elements in {string}")
    public void itShowsElementsIn(String arg0) {
    }
}
