package steam.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import steam.pages.enums.BasesBaner;
import steam.pages.enums.Language;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PageSteamMain {
    private final ElementsCollection popUpWindowsBanerShop = $$(".submenu_Store a").filter(visible);
    private final ElementsCollection popUpWindowsBanerCommunity = $$(".submenu_Community a").filter(visible);
    private final ElementsCollection banerBaseUrl = $$("#global_header .supernav_container a").filter(visible);

    @Step("Open url:{url}")
    public PageSteamMain openUrl(String url) {
        Selenide.open(url);
        return this;
    }
    @Step("Выбор языка{language}")
    public PageSteamMain setLanguage(Language language){
        /*$("#language_pulldown").click();
 $$("#language_dropdown a").filter(text(language.getName())).first().click();*/

        SelenideElement butLang =$("#language_pulldown");
        butLang.click();
        ElementsCollection elements =$$("#language_dropdown a").filter(text(language.getName()));

        if (elements.isEmpty()){
            System.out.println("url on your set lang"+language.getName());
            butLang.click();
        }
        else{
            System.out.println("url dont your set leng");
            elements.first().click();
        }
        return this;
    }
    @Step("Проверка отображение логотипа Steam")
    public PageSteamMain assertBaseTitleUrl() {
        $("#logo_holder a").shouldHave(Condition.attribute("aria-label", "Ссылка на домашнюю страницу Steam"));
        return this;
    }
    @Step("Клик элемента {element} на главном банере")
    public PageSteamMain banerBaseUrlClickElement(String element) {
        banerBaseUrl.filter(visible).filter(text(element)).first().click();
        return this;
    }
    @Step("Навести курсор на {element}")
    public PageSteamMain banerBaseUrlHoverElement(String element) {
        banerBaseUrl.filter(visible).filter(text(element)).first().hover();
        return this;
    }
    @Step("Клик на всплывающий элемент {element} в банере магазин")
    public PageSteamMain clickElementPopUpWindowsBanerShop(String element) {
        popUpWindowsBanerShop.filter(text(element)).first().click();
        return this;
    }
    @Step("Проверка всплывающего окна магазин")
    public PageSteamMain assertPopUpWindowsBanerShop(int six) {
        Assertions.assertEquals(six, popUpWindowsBanerShop.stream().count());
        return this;
    }
    @Step("Клик на всплывающий {element} на банере сообщество")
    public PageSteamMain clickElementPopUpWindowsBanerCommunity(String element) {
        popUpWindowsBanerCommunity.filter(text(element)).first().click();
        return this;
    }
    @Step("Проверка банера сообщества")
    public PageSteamMain assertBanerCommunity(int five) {
        Assertions.assertEquals(five, popUpWindowsBanerCommunity.stream().count());
        return this;
    }
    @Step("Устанавливаем значение {value} в поиск и нажимаем enter")
    public SerchPage setValueInSearch(String value) {
        Selenide.sleep(2_000);
        $("#store_nav_search_term").setValue(value).pressEnter();
        return new SerchPage();
    }
    @Step("Клик кнопки установить приложение")
    public DownloadSteam butDownloadSteam(){
       $(".header_installsteam_btn_content").click();
        return new DownloadSteam();
    }
}

