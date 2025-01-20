package steam.pages.enums;

public enum ValuesPopUpWindowsShop {
    HOME_PAGE("Главная"), RECOMMENDATIONS("Рекомендации"), WISHLIST("Список желаемого"), ITEMS_FOR_POINTS("Предметы за очки"), NEWS("Новости"), STATISTICS("Статистика");
    String name;

    ValuesPopUpWindowsShop(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
