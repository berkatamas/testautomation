package hu.masterfield.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
}
