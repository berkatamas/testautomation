package hu.masterfield.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class SearchResultPage extends BasePage {
    SelenideElement resultTitle = $(byId("results"));

    public void searchResultTitle(String searchWord){
        log.info("Oldal title szöveg: " + resultTitle.getText());
        assertTrue(resultTitle.getText().contains(searchWord));

    }

    public void searchResult(String searchWord) throws InterruptedException {
        // kigyűjti a találati listából a termékeket (max az első oldalnyit) és egyesével ellenőrzi tartalmazza-e a terméknév a keresett szöveget
        ElementsCollection productCardList = $$(byClassName("product-list--list-item"));
        for (SelenideElement productCard : productCardList) {
            try {
                SelenideElement spanElement = productCard.$("a[data-auto='product-tile--title'] span.beans-link__text");
                if (spanElement.exists()) {
                    String productTitle = spanElement.text().toLowerCase();
                    log.info("A termék neve: " + productTitle);
                    assertTrue(productTitle.contains(searchWord));
                } else {
                    log.info("Nem található megfelelő span elem." );
                }
            } catch (Exception e) {
                log.info("Hiba történt az elem keresésekor: " + e.getMessage());
                fail();
            }
        }
    }

    public void searchNotFound(){
        SelenideElement notFoundMessage = $(byClassName("empty-section--heading"));
        log.info("Visszaadott üzenet: " + notFoundMessage.getText());
        assertTrue((notFoundMessage.getText()).contains("Sajnos nem található olyan termék"));
    }
}
