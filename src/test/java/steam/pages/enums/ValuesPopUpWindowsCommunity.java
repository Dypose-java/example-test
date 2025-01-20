package steam.pages.enums;

public enum ValuesPopUpWindowsCommunity {
    NOME("Главная"), DISCUSSIONS("Обсуждения"), WORKSHOP("Мастерская"), TRAIDING_PLATFORM("Торговая площадка"), BROADCASTS("Трансляции");
    String name;

    //Главная,Обсуждения,Мастерская,Торговая площадка,Трансляции
    ValuesPopUpWindowsCommunity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
