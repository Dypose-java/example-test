package steam.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$$;

public class BasketsPage {
    @Step("Клик кнопки оплаты")
    public BasketsPage butPayGame(){
        $$(".qV80oahDZsbXiS6lIDLND").get(5).click();
        return this;
    }
}
