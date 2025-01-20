package steam.set_up;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public abstract class MainSelenide {
    @BeforeAll
   static void setUp() {
        Configuration.browser="chrome";
        Configuration.timeout=5_000;
        Configuration.browserSize="1920x1980";
    }
@BeforeEach
void allure(){
    SelenideLogger.addListener("allure",new AllureSelenide());
}
    @AfterAll
    static void afterAll() {
        WebDriverRunner.closeWindow();
    }
}


