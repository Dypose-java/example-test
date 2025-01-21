package steam.test;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import steam.pages.PageSteamMain;
import steam.pages.enums.BasesBaner;
import steam.pages.enums.Language;
import steam.pages.enums.ValuesPopUpWindowsCommunity;
import steam.pages.enums.ValuesPopUpWindowsShop;
import steam.set_up.MainJenkinsProperty;
import steam.set_up.MainSelenoid;
@Tags({@Tag("UITests"),@Tag("Steam")})
public class Main extends MainJenkinsProperty {
    final static String NAME_FILE="steam_latest.deb";
    final static String URL = "https://store.steampowered.com/";

    @Epic("Steam")
    @Story("Установка")
    @Severity(SeverityLevel.BLOCKER)
    @Tag("BLOCKER")
    @Owner("Dypose")
    @Test
    @DisplayName("Проверка скачивания файла "+NAME_FILE)
    void testdsda(){
        new PageSteamMain().openUrl(URL)
                .setLanguage(Language.RUSSIAN)
                .butDownloadSteam()
                .downloadSteam()
                .asserDownloadSteamFile(NAME_FILE);
    }

    @Epic("Steam")
    @Feature("Параметризованный тест")
    @Story("Клик")
    @Severity(SeverityLevel.NORMAL)
    @Tag("NORMAL")
    @Owner("Dypose")
    @ParameterizedTest
    @EnumSource(BasesBaner.class)
    @DisplayName("Проверка кликабельности главной панели")
    void test1(BasesBaner baseBaner) {

        new PageSteamMain().openUrl(URL)
                .setLanguage(Language.RUSSIAN)
                .assertBaseTitleUrl()
                .banerBaseUrlClickElement(baseBaner.getName());
    }
    @Epic("Steam")
    @Feature("Параметризованный тест")
    @Story("Магазин")
    @Severity(SeverityLevel.NORMAL)
    @Tag("NORMAL")
    @Owner("Dypose")
    @ParameterizedTest
    @EnumSource(ValuesPopUpWindowsShop.class)
    @DisplayName("Проверка всплываюших окон кнопки магазин")
    void test2(ValuesPopUpWindowsShop value) {
        String nameElementBaner = "МАГАЗИН";
        new PageSteamMain().openUrl(URL)
                .setLanguage(Language.RUSSIAN)
                .assertBaseTitleUrl()
                .banerBaseUrlHoverElement(nameElementBaner)
                .assertPopUpWindowsBanerShop(6)
                .clickElementPopUpWindowsBanerShop(value.getName());
    }

    @Epic("Steam")
    @Feature("Параметризованный тест")
    @Story("Сообщество")

    @Severity(SeverityLevel.NORMAL)
    @Tag("NORMAL")
    @Owner("Dypose")
    @ParameterizedTest
    @EnumSource(ValuesPopUpWindowsCommunity.class)
    @DisplayName("Проверка всплываюших окон кнопки сообщество")
    void test3(ValuesPopUpWindowsCommunity value) {

        new PageSteamMain()
                .openUrl(URL)
                .setLanguage(Language.RUSSIAN)
                .banerBaseUrlHoverElement(BasesBaner.COMMUNITY.getName())
                .assertBanerCommunity(5)
                .clickElementPopUpWindowsBanerCommunity(value.getName());
    }

    @Epic("Steam")
    @Owner("Dypose")
    @Stories({@Story("Поиск"),@Story("Покупка")})
    @Severity(SeverityLevel.BLOCKER)
    @Tag("BLOCKER")
    @DisplayName("Проверка поиска,главной страницы и покупки игры {nameGame}")
    @Test
    void test() {
        String nameGame = "Valheim";
        PageSteamMain steam = new PageSteamMain();
        steam.openUrl(URL)
                .setLanguage(Language.RUSSIAN)
                .setValueInSearch(nameGame)
                .assertSearchNameGame(nameGame)
                .clickNameGame(nameGame)
                .butIntoABasket()
                .butOpenBasket()
                .butPayGame();
    }
}
