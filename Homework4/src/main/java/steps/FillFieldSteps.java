package steps;

import pages.FillFieldPage;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class FillFieldSteps{

    @Step("Выбор пакета страхования {0}")
    public void stepSelectBlock(String menuItem){
        new FillFieldPage().selectBlockItem(menuItem);
    }

    @Step("Нажатие кнопки Сохранить")
    public void stepSaveButton(){
        new FillFieldPage().sendButton.click();
    }

    @Step("Выбор пола {0}")
    public void stepSelectGender(String menuItem){
        new FillFieldPage().selectGender(menuItem);
    }

    @Step("Поле {0} заполняется значением {1}")
    public void stepFillField(String field, String value){
        new FillFieldPage().fillField(field,value);
    }

    @Step("Заполняются поля:")
    public void stepFillFields(HashMap<String,String> fields){
        fields.forEach(this::stepFillField);
    }

    @Step("Проверяется значение {0} в поле {1}")
    public void stepCheckField(String value, String field){
        new FillFieldPage().checkFillField(value,field);
    }

    @Step("Проверяются поля:")
    public void stepChecksFields(HashMap<String,String> fields){
        fields.forEach(this::stepCheckField);
    }

    @Step("Проверка сообщения - {0}")
    public void stepCheckRequiredFields(String expectedText){
        String actualFields = new FillFieldPage().requiredFields.getText();
        assertEquals(expectedText,actualFields);
    }

    @Step("Проверка названия страницы - {0}")
    public void stepCheckTitle(String expectedTitle){
        String actualTitle = new FillFieldPage().title.getText();
        assertEquals(expectedTitle,actualTitle);
    }
}
