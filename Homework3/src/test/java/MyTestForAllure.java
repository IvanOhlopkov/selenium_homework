import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Title;
import steps.BaseSteps;
import steps.FillFieldSteps;
import steps.InsuranceSteps;
import steps.MainSteps;

import java.util.HashMap;

public class MyTestForAllure extends BaseSteps{

    @Test
    @Title("Страхование путешественников")
    public void selectInsurance(){
        MainSteps mainSteps = new MainSteps();
        InsuranceSteps insuranceSteps = new InsuranceSteps();
        FillFieldSteps fillFieldSteps = new FillFieldSteps();

        HashMap<String,String> testData = new HashMap<>();
        testData.put("Фамилия застрахованного(англ)", "IVANOV");
        testData.put("Имя застрахованного(англ)", "IVAN");
        testData.put("Дата рождения застрахованного", "01.01.1990");
        testData.put("Фамилия", "Петров");
        testData.put("Имя", "Петр");
        testData.put("Отчество", "Петрович");
        testData.put("Дата рождения", "02.02.1992");
        testData.put("Серия паспорта", "1234");
        testData.put("Номер паспорта", "567890");
        testData.put("Дата выдачи", "02.02.2016");
        testData.put("Кем выдан", "УФМС г.Тестовый");

        mainSteps.stepSelectMainMenu("Застраховать себя");
        mainSteps.stepSelectSubMenu("Страхование путешественников");

        insuranceSteps.stepSendButton();

        BaseSteps.tabPage();

        fillFieldSteps.stepCheckTitle("Страхование путешественников");

        fillFieldSteps.stepSelectBlock("Минимальная");

        fillFieldSteps.stepSaveButton();

        fillFieldSteps.stepFillFields(testData);

        fillFieldSteps.stepSelectGender("мужской");

        //Проверки
        HashMap<String,String> checkTestData = new HashMap<>();
        checkTestData.put("IVANOV", "Фамилия застрахованного(англ)");
        checkTestData.put("IVAN", "Имя застрахованного(англ)");
        checkTestData.put("01.01.1990", "Дата рождения застрахованного");
        checkTestData.put("Петров", "Фамилия");
        checkTestData.put("Петр", "Имя");
        checkTestData.put("Петрович", "Отчество");
        checkTestData.put("02.02.1992", "Дата рождения");
        checkTestData.put("1234", "Серия паспорта");
        checkTestData.put("567890", "Номер паспорта");
        checkTestData.put("02.02.2016", "Дата выдачи");
        checkTestData.put("УФМС г.Тестовый", "Кем выдан");

        fillFieldSteps.stepChecksFields(checkTestData);

        fillFieldSteps.stepSaveButton();

        fillFieldSteps.stepCheckRequiredFields("Заполнены не все обязательные поля");
    }
}
