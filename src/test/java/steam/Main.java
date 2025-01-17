package steam;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class Main extends MainSelenide{
    final static String URL ="https://store.steampowered.com/";

    @ParameterizedTest
    @EnumSource(BaseBaner.class)
    void test1(BaseBaner baseBaner){
        Steam steam = new Steam();
        step("Open url:{URL}",()->steam.openUrl(URL));
        step("Проверка отображение логотипа Steam",()->{
            steam.assertBaseTitleUrl();
        });
        step("Клик элемента {strings} на главном банере",()->{
            steam.banerBaseUrlClickElement(baseBaner.getName());
        });

    }
    @ParameterizedTest
    @EnumSource(ValuePopUpWindowsShop.class)
    void test2(ValuePopUpWindowsShop value){
        String nameElementBaner="МАГАЗИН";
        Steam steam = new Steam();
        step("Open url:{URL}",()->{
            steam.openUrl(URL);
        });
        step("Проверка отображение логотипа Steam",()->{
            steam.assertBaseTitleUrl();
        });
        step("Навести курсор на {nameElementBaner}",()->{
            steam.banerBaseUrlHoverElement(nameElementBaner);
        });
        step("assert",()->{
            steam.assertPopUpWindowsBanerShop(6);
        });
        step("Нажать на {value}",()->{
            steam.clickElementPopUpWindowsBanerShop(value.getName());
        });
    }
    @ParameterizedTest
    @EnumSource(ValuePopUpWindowsCommunity.class)
    void test3(ValuePopUpWindowsCommunity value){
        Steam steam = new Steam();
        step("Open url:{URL}",()->{
            steam.openUrl(URL);
        });
        step("Навестить на элемент "+BaseBaner.COMMUNITY.getName(),()->{
            steam.banerBaseUrlHoverElement(BaseBaner.COMMUNITY.getName());
        });
        step("Проверка что всплывающие элементы равны 5",()->{
            steam.assertBanerCommunity(5);
        });
        step("Нажать на элемент {value} всплывающего окна",()->{
            steam.clickElementPopUpWindowsBanerCommunity(value.getName());
        });

    }


    @ParameterizedTest
    @EnumSource(BaseBaner.class)
    void testWithEnumSource(BaseBaner baseBaner) {
        Steam steam = new Steam();
        step("Open url:{URL}",()->steam.openUrl(URL));
        step("Проверка отображение логотипа Steam",()->{
            steam.assertBaseTitleUrl();
        });
        step("Клик элемента {strings} на главном банере",()->{
            steam.banerBaseUrlClickElement(baseBaner.getName());
        });
    }

    String nameGame="Valheim";
    @Test
    void test(){
        Steam steam = new Steam();
        steam.openUrl(URL);
        steam.setValueInSearch(nameGame);
        steam.assertSearchNameGame(nameGame);
        steam.clickNameGame(nameGame);
    }
}
