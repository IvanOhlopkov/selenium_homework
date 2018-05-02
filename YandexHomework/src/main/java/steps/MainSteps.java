package steps;

import pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

public class MainSteps{

    @Step("Выбрано на главной странице {0}")
    public void stepSelectHomeTab(String tabItem){
        new MainPage().selectHomeTab(tabItem);
    }

}
