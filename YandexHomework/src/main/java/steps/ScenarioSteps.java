package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ScenarioSteps {

    MainSteps mainSteps = new MainSteps();
    MarketSteps marketSteps = new MarketSteps();
    CatalogSteps catalogSteps = new CatalogSteps();
    FilterSteps filterSteps = new FilterSteps();


    @When("^Выбран пункт меню \"(.*)\"$")
    public void stepSelectTabMenu(String tabItem){
        mainSteps.stepSelectHomeTab(tabItem);
    }

    @When("^Установка региона - \"(.*)\"$")
    public void  stepSelectRegion(String regionItem){
        marketSteps.stepSelectRegion(regionItem);
    }

    @When("^Выбран раздел в маркете - \"(.*)\"$")
    public void stepSelectMenuList(String menuItem){
        marketSteps.stepSelectMenuList(menuItem);
    }

    @When("^Выбрано в разделе - \"(.*)\"$")
    public void stepSetSubMenuElectronics(String subItem){
        marketSteps.stepSetSubMenuElectronics(subItem);
    }

    @When("^Указана сумма от: \"(.*)\"$")
    public void stepSetPriceFrom(String priceItem){
        filterSteps.stepSetPriceFrom(priceItem);
    }

    @When("^Выбран производитель - \"(.*)\"$")
    public void stepSelectManafacture(String manafactureItem){
        filterSteps.stepSelectManafacture(manafactureItem);
    }

    @When("^Нажата кнопка - Перейти ко всем фильтрам")
    public void stepSelectAllFilter(){
        catalogSteps.stepSelectAllFilter();
    }

    @When("^Нажата кнопка - Показать подходящие")
    public void stepApplyFilter(){
        filterSteps.stepSetApplyFilter();
    }

    @When("^Общее кол-во")
    public void stepTotalProduct(){
        catalogSteps.stepTotalProduct();
    }

    @Then("^Общее кол-во \"(.+)\"$")
    public void stepCheckTotal(){
        catalogSteps.stepTotalProduct();
    }

    @Then("^Проверка наименование первого товара")
    public void stepCheckProduct(){
        catalogSteps.stepCheckNameFirstProduct();
    }
}
