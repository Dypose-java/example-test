package steam.pages;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;

public class SerchPage {
    private final ElementsCollection searchGame = $$("#search_resultsRows div .ellipsis");
    @Step("Проверка отображение {name} в поиске")
    public SerchPage assertSearchNameGame(String name) {
        searchGame.filter(text(name)).first().shouldHave(text(name));
        return this;
    }

    @Step("Клик на {name}")
    public GamesPageMain clickNameGame(String name) {
        searchGame.filter(text(name)).first().click();
        return new GamesPageMain();
    }
}
