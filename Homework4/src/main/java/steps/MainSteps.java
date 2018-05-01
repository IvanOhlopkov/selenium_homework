package steps;

import pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

public class MainSteps{

    @Step("Выбран пункт меню на главной странице {0}")
    public void stepSelectMainMenu(String menuItem){
        new MainPage().selectMainMenu(menuItem);
    }

    @Step("Выбран пункт страхования {0}")
    public void stepSelectSubMenu(String menuItem){
        new MainPage().selectSubMenu(menuItem);
    }
}
