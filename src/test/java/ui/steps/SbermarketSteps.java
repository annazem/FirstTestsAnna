package ui.steps;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.SbermarketPage;

public class SbermarketSteps {
    @Step("Ищем цену на первую позицию яблок в МЕТРО")
    public String searchMetro(String value) {
        SbermarketPage.metroButton.click();
        SbermarketPage.searchField.setValue(value);
        SbermarketPage.searchButton.click();
        return SbermarketPage.firstProductPrice.getText();
    }

    @Step("Ищем цену на первую позицию яблок в АШАН")
    public String searchAuchan(String value) {
        SbermarketPage.auchanButton.click();
        SbermarketPage.searchField.setValue(value);
        SbermarketPage.searchButton.click();
        return SbermarketPage.firstProductPrice.getText();
    }

    @Step("Выходим из каталога магазина, переход в список всех ретейлеров")
    public String leaveStore() {
        SbermarketPage.goToAllStoreButton.click();
        return null;
    }

    @Step("Закрываем информационное сообщение на главной странице")
    public String closeInfoMessage() {
        SbermarketPage.closeInfoButton.click();
        return null;
    }
}
