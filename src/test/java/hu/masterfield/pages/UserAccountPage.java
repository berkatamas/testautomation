package hu.masterfield.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class UserAccountPage extends BasePage{
    SelenideElement userDataEditLink = $(byClassName("account-settings--form--actions--edit"));
    SelenideElement userMobileNumber = $(byId("primary-phone"));
    SelenideElement userDataSaveLink = $(byClassName("account-settings--form--actions--submit"));

    public void editUserMobileNumber(){
        userDataEditLink.click();
        userMobileNumber.clear();
        userMobileNumber.setValue(newMobileNumber);
        userDataSaveLink.click();
    }

}
