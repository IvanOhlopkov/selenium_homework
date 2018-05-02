package steps;

import pages.FilterPage;
import ru.yandex.qatools.allure.annotations.Step;

public class FilterSteps {

    @Step("Указана сумма от: {0}")
    public void stepSetPriceFrom(String priceItem){
        new FilterPage().setPriceFrom(priceItem);
    }

    @Step("Выбран производитель - {0}")
    public void stepSelectManafacture(String manafactureItem){
        new FilterPage().selectManafacturer(manafactureItem);
    }

    @Step("Нажата кнопка применения фильтра - Показать подходящие")
    public void stepSetApplyFilter(){
        new  FilterPage().setApplyFilter();
    }
}
