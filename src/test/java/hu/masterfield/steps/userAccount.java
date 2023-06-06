package hu.masterfield.steps;

import com.codeborne.selenide.Configuration;
import hu.masterfield.pages.HomePage;
import hu.masterfield.pages.LoggedHomePage;
import hu.masterfield.pages.LoginPage;
import hu.masterfield.pages.UserAccountPage;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
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
    UserAccountPage userAccountPage = new UserAccountPage();

    @Before
    public void setup(){
        Configuration.reportsFolder = "target/reports";

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--incognito");
        Configuration.browserCapabilities = options;
    }

    @After
    public void waitFor() throws InterruptedException {
        Thread.sleep(3000);
        getWebDriver().quit();
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

    }

    @Then("change the language to Magyar")
    public void changeTheLanguageToMagyar() {
        homePage.setLanguage();
    }

    @When("user fill login data")
    public void userFillLoginData() {
        loginPage = homePage.loginStart();
    }

    @Then("login to store")
    public void loginToStore() {
        loggedHomePage = loginPage.login();
    }

    @And("open user account page")
    public void openUserAccountPage() {
        userAccountPage = loggedHomePage.openUserAccount();
    }


    @Then("edit user mobile number")
    public void editUserMobileNumber() {

    }
}
