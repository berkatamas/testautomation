package hu.masterfield;

import org.junit.jupiter.api.BeforeAll;
import com.codeborne.selenide.Configuration;

public class BaseTest {

    @BeforeAll
    public static void setup(){
        Configuration.reportsFolder = "target/reports";
    }
}
