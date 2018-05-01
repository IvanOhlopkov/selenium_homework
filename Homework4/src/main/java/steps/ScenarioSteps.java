package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.When;

public class ScenarioSteps {

    MainSteps mainSteps = new MainSteps();

    InsuranceSteps insuranceSteps = new InsuranceSteps();

    FillFieldSteps fillFieldSteps = new FillFieldSteps();

    @When("^Выбран пункт меню \"(.*)\"$")
    public void stepSelectMainMenu(String menuItem){
            mainSteps.stepSelectMainMenu(menuItem);
    }

    @When("^Выбран вид страхования - \"(.*)\"$")
    public void stepSelectSubMenu(String menuItem){
            mainSteps.stepSelectSubMenu(menuItem);
    }

    @When("^Выполнено нажатие кнопки - Оформить онлайн")
    public void stepSendButton(){
            insuranceSteps.stepSendButton();
    }

    @When("^Проверка заголовка страницы \"(.*)\"$")
    public void stepCheckTitle(String menuItem){
            fillFieldSteps.stepCheckTitle(menuItem);
    }

    @When("^Выполнен переход на вторую вкладку браузера")
    public void stepTabPage(){
        BaseSteps.stepTabPage();
    }

    @When("^Выбор пакета страхования \"(.*)\"$")
    public void stepSelectBlock(String menuItem){
        fillFieldSteps.stepSelectBlock(menuItem);
    }

    @When("^Выполнено нажатие кнопки - Сохранить")
    public void stepSaveButton(){
        fillFieldSteps.stepSaveButton();
    }

    @When("^заполняются поля:")
    public void stepFillFields(DataTable fields){
        fields.asMap(String.class, String.class).forEach(
                (key, value) -> fillFieldSteps.stepFillField(key, value));
    }

    @When("^выбран пол \"(.*)\"$")
    public void stepSelectGender(String gender){
        fillFieldSteps.stepSelectGender(gender);
    }

    @When("^проверяются поля:")
    public void stepCheckFields(DataTable fields){
        fields.asMap(String.class, String.class).forEach(
                (key, value) -> fillFieldSteps.stepCheckField(key, value));
    }

    @When("^Выполняется проверка сообщения \"(.*)\"$")
    public void stepCheckRequiredFields(String message){
        fillFieldSteps.stepCheckRequiredFields(message);
    }

}
