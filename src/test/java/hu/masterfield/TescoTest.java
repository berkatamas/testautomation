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
        Thread.sleep(3000);
        getWebDriver().manage().window().maximize();
        Thread.sleep(3000);
        loginPage.acceptCookies();

        Thread.sleep(2000);
    }
}
