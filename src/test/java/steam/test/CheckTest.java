package steam.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import steam.pages.PageSteamMain;
import steam.pages.enums.Language;
import steam.set_up.MainJenkinsProperty;

import static com.codeborne.selenide.Selenide.sleep;

@Tag("check_test")
public class CheckTest extends MainJenkinsProperty {
    final static String URL = "store.steampowered.com/";
    @Test
    void buyGameTest(){
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
