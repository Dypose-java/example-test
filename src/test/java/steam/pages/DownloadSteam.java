package steam.pages;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import java.io.File;
import static com.codeborne.selenide.Selenide.$;

public class DownloadSteam{
      File download;

    @Step("Скачиваем файл")
    public DownloadSteam downloadSteam(){
        download = $("#about_greeting a").download();
        System.out.println(download.getName());
        return this;
    }
    @Step("Проверка скаченного название файла")
    public DownloadSteam asserDownloadSteamFile(String name){
        Assertions.assertEquals(download.getName(),name);
        return this;
    }
}
