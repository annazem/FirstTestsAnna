package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class SbermarketPage {
    public static SelenideElement metroButton = $x("//a[@href='/metro']/picture/..");
    public static SelenideElement auchanButton = $x("//a[@href='/auchan']/picture/..");
    public static SelenideElement searchField = $x("//input[@data-qa='suggester_header_form_input']");
    public static SelenideElement searchButton = $x("//button[@data-qa='suggester_header_form_search_button']");
    public static SelenideElement firstProductPrice = $x("//div[contains(@class, 'ProductsGrid')]//div[contains(@class, 'ProductCard')][1]//div[contains(@class, 'ProductCardPrice_price')]");
    public static SelenideElement goToAllStoreButton = $x("//div[contains(@class, 'Link_iconContainer')]//span");
    public static SelenideElement closeInfoButton = $x("//div[contains(@class, 'CookiesConcent')]//button");
}