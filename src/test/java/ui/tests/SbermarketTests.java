package ui.tests;

import io.qameta.allure.*;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SbermarketPage;
import ui.steps.SbermarketSteps;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

@Epic("UI тесты")
@Feature("Sbermarket тесты")
@Story("Поиск товаров")
public class SbermarketTests {
    private SbermarketSteps sbermarketSteps;

    @BeforeClass(description = "Добавляем фильтр Allure для RestAssured", alwaysRun = true)
    void addFilters() {
        RestAssured.filters(new AllureRestAssured());
    }
    @BeforeClass(alwaysRun = true)
    void beforeClass() {
        sbermarketSteps = new SbermarketSteps();
    }

    @BeforeMethod
    public void beforeMethod() {
        Configuration.startMaximized = true;
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver118");
        open("https://sbermarket.ru/");
    }

    @AfterMethod
    public void afterMethod() {
        closeWebDriver();
    }

    @Issue("SPC-2122")
    @TmsLink("231500")
    @Test(description = "Поиск и сравнение цен на яблоки")
    public void searchTest() {
        String productNameExp = "яблоко";
        sbermarketSteps.closeInfoMessage();
        String productPriceMetro = sbermarketSteps.searchItem("Метро", productNameExp);
        sbermarketSteps.leaveStore();
        String productPriceAuchan = sbermarketSteps.searchItem("Ашан", productNameExp);
        Assert.assertNotEquals(productPriceMetro, productPriceAuchan, "Цены одинаковые");
    }
}
