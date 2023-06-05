package hu.masterfield.steps;

import com.codeborne.selenide.Configuration;
import hu.masterfield.pages.HomePage;
import hu.masterfield.pages.LoggedHomePage;
import hu.masterfield.pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class userAccount {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    LoggedHomePage loggedHomePage = new LoggedHomePage();

    @Before
    public void setup(){
        Configuration.reportsFolder = "target/reports";

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--incognito");
        Configuration.browserCapabilities = options;
    }

    @Given("open main page")
    public void openMainPage() {
        homePage.openPage();
        getWebDriver().manage().window().maximize();
    }

    @And("accept cookies")
    public void acceptCookies() throws InterruptedException {
        homePage.acceptCookies();
    }

    @When("the language is English")
    public void theLanguageIsEnglish() {
        homePage.getLanguage();
    }

    @Then("change the language to Magyar")
    public void changeTheLanguageToMagyar() {
        //
    }

    @When("user fill login data")
    public void userFillLoginData() {
        loginPage = homePage.loginStart();
    }

    @Then("login to store")
    public void loginToStore() {
        loggedHomePage = loginPage.login();
    }

    @After
    public void waitFor() throws InterruptedException {
        Thread.sleep(5000);
    }
}
