package steam.testMy;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selenide.$x;

public class Test {
    final static String URL ="https://store.steampowered.com/";

    @ValueSource(strings = {
            "Google",
            "Yandex"
    })//в метод передается массив значений которые мы проверяем
    @ParameterizedTest
//Чтобы выполнить тест несколько раз, но с разными аргументами
    void gfdgdgdf(String strings){
        PageTextBox pageTest = new PageTextBox();
//        pageTest.testFullName(strings);
    }

    @ValueSource(strings = {
            "Google",
            "Yandex"
    })//в метод передается массив значений которые мы проверяем
    @ParameterizedTest
//Чтобы выполнить тест несколько раз, но с разными аргументами
    void gdfgdfg(String strings){
        new TestPage().openUrl(URL);

    }
}
class PageTextBox{
    private final SelenideElement inputFullName=$x("//input[@id='userName']");
    public PageTextBox() {
        Selenide.open("https://demoqa.com/text-box");
    }
    void testFullName(String name){
        inputFullName.setValue(name);

    }
}
class TestPage{
    TestPage openUrl(String url){
        Selenide.open(url);
        return  this;
    }
}
