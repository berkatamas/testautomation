package hu.masterfield;

import hu.masterfield.pages.LoginPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class TescoTest extends BaseTest{


    @Test
    @DisplayName("Tesco TC1 - Login")
    public void login() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.openPage();
        getWebDriver().manage().window().maximize();
        loginPage.acceptCookies();

        Thread.sleep(2000);
    }
}
