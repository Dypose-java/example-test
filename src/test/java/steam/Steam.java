package steam;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Steam {
    private final ElementsCollection popUpWindowsBanerShop =$$(".submenu_Store a").filter(visible);
    private final ElementsCollection popUpWindowsBanerCommunity =$$(".submenu_Community a").filter(visible);
    private final ElementsCollection banerBaseUrl =$$("#global_header .supernav_container a").filter(visible);
    private final ElementsCollection searchGame = $$("#search_resultsRows div .ellipsis");

    //@Step("Открытие страницы Steam")
    public Steam openUrl(String url){
        Selenide.open(url);
        return this;
    }
public Steam assertBaseTitleUrl(){
    $("#logo_holder a").shouldHave(Condition.attribute("aria-label","Ссылка на домашнюю страницу Steam"));
    return this;
}
public Steam banerBaseUrlClickElement(String element){
    banerBaseUrl.filter(visible).filter(text(element)).first().click();
    return this;
}
public Steam banerBaseUrlHoverElement(String element){
    banerBaseUrl.filter(visible).filter(text(element)).first().hover();
    return this;
}

public Steam clickElementPopUpWindowsBanerShop(String element){
    popUpWindowsBanerShop.filter(text(element)).first().click();
    return this;
}
public Steam assertPopUpWindowsBanerShop(int six){
    Assertions.assertEquals(six, popUpWindowsBanerShop.stream().count());
      return this;
}
    public Steam clickElementPopUpWindowsBanerCommunity(String element){
        popUpWindowsBanerCommunity.filter(text(element)).first().click();
        return this;
    }
    public Steam assertBanerCommunity(int five){
       Assertions.assertEquals(five,popUpWindowsBanerCommunity.stream().count());
        return this;
    }

public Steam setValueInSearch(String value){
        $("#store_nav_search_term").setValue(value).pressEnter();
        return this;
}
public Steam assertSearchNameGame(String name){
    searchGame.filter(text(name)).first().shouldHave(text(name));
    return this;
}
public Steam clickNameGame(String name){
    searchGame.first().click();
    return this;
}

}

enum BaseBaner{
    SHOP("МАГАЗИН"),COMMUNITY("СООБЩЕСТВО"),INFORMATION("Информация"),SUPPORT("ПОДДЕРЖКА");
    String name;

    BaseBaner(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}

enum ValuePopUpWindowsShop{
    HOME_PAGE("Главная"),RECOMMENDATIONS("Рекомендации")
    ,WISHLIST("Список желаемого"),ITEMS_FOR_POINTS("Предметы за очки")
    ,NEWS("Новости"),STATISTICS("Статистика");
    String name;

    ValuePopUpWindowsShop(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

enum ValuePopUpWindowsCommunity{
   NOME("Главная"),DISCUSSIONS("Обсуждения")
    ,WORKSHOP("Мастерская"),TRAIDING_PLATFORM("Торговая площадка"),BROADCASTS("Трансляции");
   String name;
    //Главная,Обсуждения,Мастерская,Торговая площадка,Трансляции
    ValuePopUpWindowsCommunity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

