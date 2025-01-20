package steam.test;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import steam.pages.enums.Language;
import steam.set_up.MainSelenide;
import steam.pages.enums.BasesBaner;
import steam.pages.PageSteamMain;
import steam.pages.enums.ValuesPopUpWindowsCommunity;
import steam.pages.enums.ValuesPopUpWindowsShop;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertNotNull;
@Tag("UITests")
public class LocalTest extends MainSelenide {
    final static String URL = "https://store.steampowered.com/";
    final static String NAME_FILE="SteamSetup.exe";
    @Epic("Параметризованный тест")
    @Feature("Главная панель")
    @DisplayName("Проверка кликабельности главной панели")
    @Owner("Dypose")
    @Severity(SeverityLevel.NORMAL)
    @Tag("NORMAL")
    @ParameterizedTest
    @EnumSource(BasesBaner.class)
    void test1(BasesBaner baseBaner) {

        new PageSteamMain().openUrl(URL).
                assertBaseTitleUrl().
                banerBaseUrlClickElement(baseBaner.getName());
    }
    @Epic("Параметризованный тест")
    @Feature("Главная панель")
    @Owner("Dypose")
    @Story("Магазин")
    @DisplayName("Проверка всплываюших окон кнопки магазин")
    @Severity(SeverityLevel.NORMAL)
    @Tag("NORMAL")
    @ParameterizedTest
    @EnumSource(ValuesPopUpWindowsShop.class)
    void test2(ValuesPopUpWindowsShop value) {
        String nameElementBaner = "МАГАЗИН";
        new PageSteamMain().openUrl(URL)
                .assertBaseTitleUrl()
                .banerBaseUrlHoverElement(nameElementBaner)
                .assertPopUpWindowsBanerShop(6)
                .clickElementPopUpWindowsBanerShop(value.getName());
    }

    @Epic("Параметризованный тест")
    @Feature("Главная панель")
    @Owner("Dypose")
    @Story("Сообщество")
    @DisplayName("Проверка всплываюших окон кнопки сообщество")
    @Severity(SeverityLevel.NORMAL)
    @Tag("NORMAL")
    @ParameterizedTest
    @EnumSource(ValuesPopUpWindowsCommunity.class)
    void test3(ValuesPopUpWindowsCommunity value) {

        new PageSteamMain()
                .openUrl(URL)
                .banerBaseUrlHoverElement(BasesBaner.COMMUNITY.getName())
                .assertBanerCommunity(5)
                .clickElementPopUpWindowsBanerCommunity(value.getName());
    }

    @Owner("Dypose")
    @Test
    @Stories({@Story("Поиск"),@Story("Покупка")})
    @Severity(SeverityLevel.BLOCKER)
    @Tag("BLOCKER")
    @DisplayName("Проверка поиска,главной страницы и покупки игры {nameGame}")
    void test() {
        String nameGame = "Valheim";
        PageSteamMain steam = new PageSteamMain();
        steam.openUrl(URL)
                .setValueInSearch(nameGame)
                .assertSearchNameGame(nameGame)
                .clickNameGame(nameGame)
                .butIntoABasket()
                .butOpenBasket()
                .butPayGame();
    }

    @Owner("Dypose")
    @Test
    @Story("Установка")
    @Severity(SeverityLevel.BLOCKER)
    @Tag("BLOCKER")
    @DisplayName("Проверка скачивания файла "+NAME_FILE)
    void testdsda(){
        new PageSteamMain().openUrl(URL)
                .butDownloadSteam()
                .downloadSteam()
                .asserDownloadSteamFile(NAME_FILE);
    }
    @Test
    void Lang(){
        new PageSteamMain().openUrl(URL);
        SelenideElement butLang =$("#language_pulldown");
        butLang.click();
        ElementsCollection elements =$$("#language_dropdown a").filter(text(Language.ENGLISH.getName()));
        if (elements.isEmpty()){
            System.out.println("url on your set lang");
            butLang.click();
        }
        else{
            System.out.println("url dont your set leng");
            elements.first().click();
            sleep(3_000);

        }


//        $$("#language_dropdown a").filter(text(Language.RUSSIAN.getName())).first().click();
    }

}
