package steam.pages.enums;

public enum Language {
    RUSSIAN("Русский"),ENGLISH("английский");
    String name;

    //Главная,Обсуждения,Мастерская,Торговая площадка,Трансляции
    Language(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
