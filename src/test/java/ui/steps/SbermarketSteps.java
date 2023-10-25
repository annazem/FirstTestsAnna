package ui.steps;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.SbermarketPage;

public class SbermarketSteps {
    @Step("Поиск цены на первую позицию {value} в {retailerName}")
    public String searchItem (String retailerName,String value) {
        switch (retailerName) {
            case "Метро":
                SbermarketPage.metroButton.click();
                break;

            case "Ашан":
                SbermarketPage.auchanButton.click();
                break;
        }
        SbermarketPage.searchField.setValue(value);
        SbermarketPage.searchButton.click();
        return SbermarketPage.firstProductPrice.getText();
    }

    @Step("Выход из каталога магазина, переход в список всех ретейлеров")
    public void leaveStore() {
        SbermarketPage.goToAllStoreButton.click();
    }

    @Step("Закрытие информационного сообщения на главной странице")
    public void closeInfoMessage() {
        SbermarketPage.closeInfoButton.click();
    }
}
