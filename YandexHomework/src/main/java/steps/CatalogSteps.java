package steps;

import pages.CatalogPage;
import ru.yandex.qatools.allure.annotations.Step;

public class CatalogSteps {

    @Step("Нажата кнопка - Перейти ко всем фильтрам")
    public void stepSelectAllFilter(){
        new CatalogPage().selectAllFilter();
    }

    @Step("Общее количество найденных - {0}")
    public String stepTotalProduct(){
        return new CatalogPage().checkTotalProduct();
    }

    @Step("Проверка наименование товара в списке и после поиска")
    public void stepCheckNameFirstProduct(){
        new CatalogPage().checkFirstNameProduct();
    }

}
