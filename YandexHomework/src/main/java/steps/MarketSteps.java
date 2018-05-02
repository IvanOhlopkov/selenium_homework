package steps;


import pages.MarketPage;
import ru.yandex.qatools.allure.annotations.Step;

public class MarketSteps {

    @Step("Выбран раздел в маркете {0}")
    public void stepSelectMenuList(String tabItem){
        new MarketPage().selectMenuList(tabItem);
    }

    @Step("Установка региона - {0}")
    public void stepSelectRegion(String regionItem){
        new MarketPage().checkRegion(regionItem);
    }

    @Step("Выбрано в разделе {0}")
    public void stepSetSubMenuElectronics(String subItem){
        new MarketPage().setSubMenuElectronics(subItem);
    }
}
