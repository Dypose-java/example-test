package steam.pages.enums;

public enum BasesBaner {
    SHOP("МАГАЗИН"), COMMUNITY("СООБЩЕСТВО"), INFORMATION("Информация"), SUPPORT("ПОДДЕРЖКА");
    String name;

    BasesBaner(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
