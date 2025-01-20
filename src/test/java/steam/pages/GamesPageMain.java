package steam.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class GamesPageMain {

    @Step("Клик кнопки в корзину")
    public GamesPageMain butIntoABasket() {
        $(".game_area_purchase_game_wrapper .btn_addtocart a span").click();
        return this;
    }
    @Step("Открытие корзины")
    public BasketsPage butOpenBasket(){
        $(".Primary").click();
        return new BasketsPage();
    }
}
