package hu.masterfield.layout;

import com.galenframework.api.Galen;
import com.galenframework.junit.GalenJUnitTestBase;
import com.galenframework.reports.GalenTestInfo;
import com.galenframework.reports.HtmlReportBuilder;
import com.galenframework.reports.TestReport;
import com.galenframework.reports.model.LayoutReport;
import freemarker.template.utility.DateUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LayoutTest extends GalenJUnitTestBase {
    static WebDriver driver;
    static WebDriverWait wait;
    static TestDevice device = new TestDevice("desktop", new Dimension(1024,800), Arrays.asList("desktop"));
    //static TestDevice device = new TestDevice("mobile", new Dimension(360,640), Arrays.asList("mobile"));

    @BeforeAll
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        /* Nexus 5 */
/*        Map<String, String> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", "Nexus 5");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
        driver = new  ChromeDriver(chromeOptions); // for mobile
*/
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().setSize(device.getScreenSize());

    }

    @Test
    @DisplayName("TC1 - Tesco Login")
    public void TC1() throws InterruptedException, IOException {

        driver.get("https://bevasarlas.tesco.hu/groceries/hu-HU/login?from=https%3A%2F%2Fbevasarlas.tesco.hu%2Fgroceries%2Fhu-HU%2F");

        layoutReport = Galen.checkLayout(driver, "/specs/loginPage.gspec", device.getTags());
    }

    @Override
    public WebDriver createDriver() {
        super.driver.set(driver);
        super.report.set(new TestReport());
        return driver;
    }

    static LayoutReport layoutReport;

    public static void reportUpdate() {
        try {
            List<GalenTestInfo> tests = new LinkedList<>();
            GalenTestInfo test = GalenTestInfo.fromString("Tesco loginpage test");
            test.getReport().layout(layoutReport, "Verify login layout");
            tests.add(test);
            new HtmlReportBuilder().build(tests, "target/galen-html-reports");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterAll
    public static void cleanup(){
        reportUpdate();
        driver.quit();
    }
}

