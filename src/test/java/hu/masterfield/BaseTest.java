package hu.masterfield;

import org.junit.jupiter.api.BeforeAll;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {

    @BeforeAll
    public static void setup(){
        Configuration.reportsFolder = "target/reports";

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--incognito");

    }
}
