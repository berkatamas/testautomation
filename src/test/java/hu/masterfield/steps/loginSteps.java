package hu.masterfield.steps;

import com.codeborne.selenide.Configuration;
import hu.masterfield.pages.LoginPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class loginSteps {
    LoginPage loginPage = new LoginPage();

    @Before
    public static void setup() {
        Configuration.reportsFolder = "target/reports";

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--incognito");
        Configuration.browserCapabilities = options;
    }

    @Given("open main page")
    public void openMainPage() {
        loginPage.openPage();
        getWebDriver().manage().window().maximize();
    }

    @And("accept cookies")
    public void acceptCookies() throws InterruptedException {
        loginPage.acceptCookies();
    }

    @When("the language is English")
    public void theLanguageIsEnglish() {
        loginPage.getLanguage();
    }

    @Then("change the language to Magyar")
    public void changeTheLanguageToMagyar() {
    }

}
