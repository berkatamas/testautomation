package hu.masterfield.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.ThreadLocalRandom;

import static com.codeborne.selenide.WebDriverRunner.url;

public class BasePage {
    String websiteURL = "https://bevasarlas.tesco.hu/";
    String username = "test01@testmail.hu";
    String password = "Test1234+";

    public static Logger log = LogManager.getLogger();

    public void isLoaded(SelenideElement element) {
        element.shouldBe(Condition.visible);
    }

    public void isInteractable(SelenideElement element) {
        element.shouldBe(Condition.enabled);
    }

    public String getURL() {
        return url();
    }

    public String generateMobileNumber(){
        ThreadLocalRandom random = ThreadLocalRandom.current();
        long generatedNumber = random.nextLong(10_000_00L, 99_999_99L);
        String newMobileNumber = "0630";
        newMobileNumber = newMobileNumber + generatedNumber;

        return newMobileNumber;
    }

    public void setup(){
        Configuration.reportsFolder = "target/reports";

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--incognito");
        Configuration.browserCapabilities = options;

        // browser.properties megvalósítása: Az elején jó de később közben access denied-et ad az oldal
        /*
        Properties props = new Properties();
        InputStream is = userAccount.class.getResourceAsStream("/browser.properties");
        props.load(is);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments(props.getProperty("chrome.arguments"));
        Configuration.browserCapabilities = chromeOptions;
        */
    }
}
