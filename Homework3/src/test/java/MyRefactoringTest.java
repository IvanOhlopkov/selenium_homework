import org.junit.Ignore;
import org.junit.Test;

import pages.FillFieldPage;
import pages.InsurancePage;
import pages.MainPage;
import steps.BaseSteps;

import static org.junit.Assert.*;

public class MyRefactoringTest extends BaseSteps {

    @Test
    @Ignore
    public void newInsuranceTest() {

        MainPage mainPage = new MainPage(driver);

        mainPage.selectMainMenu("Застраховать");

        mainPage.selectSubMenu("Страхование путешественников");

        new InsurancePage(driver).sendButton.click();

        super.tabPage();

        FillFieldPage fillFieldPage = new FillFieldPage(driver);
        String actualTitle = fillFieldPage.title.getText();
        assertEquals("Страхование путешественников", actualTitle);

        fillFieldPage.selectBlockItem("Минимальная");

        fillFieldPage.sendButton.click();

        fillFieldPage.fillField("Фамилия застрахованного(англ)", "IVANOV");
        fillFieldPage.fillField("Имя застрахованного(англ)", "IVAN");
        fillFieldPage.fillField("Дата рождения застрахованного", "01.01.1990");
        fillFieldPage.fillField("Фамилия", "Петров");
        fillFieldPage.fillField("Имя", "Петр");
        fillFieldPage.fillField("Отчество", "Петрович");
        fillFieldPage.fillField("Дата рождения", "02.02.1992");

        fillFieldPage.selectGender("мужской");

        fillFieldPage.fillField("Серия паспорта", "1234");
        fillFieldPage.fillField("Номер паспорта", "567890");
        fillFieldPage.fillField("Дата выдачи", "02.02.2016");
        fillFieldPage.fillField("Кем выдан", "УФМС г.Тестовый");

        //Проверки
        fillFieldPage.checkFillField("IVANOV", "Фамилия застрахованного(англ)");
        fillFieldPage.checkFillField("IVAN", "Имя застрахованного(англ)");
        fillFieldPage.checkFillField("01.01.1990", "Дата рождения застрахованного");
        fillFieldPage.checkFillField("Петров", "Фамилия");
        fillFieldPage.checkFillField("Петр", "Имя");
        fillFieldPage.checkFillField("Петрович", "Отчество");
        fillFieldPage.checkFillField("02.02.1992", "Дата рождения");
        fillFieldPage.checkFillField("1234", "Серия паспорта");
        fillFieldPage.checkFillField("567890", "Номер паспорта");
        fillFieldPage.checkFillField("02.02.2016", "Дата выдачи");
        fillFieldPage.checkFillField("УФМС г.Тестовый", "Кем выдан");

        new FillFieldPage(driver).sendButton.click();

        String actualFields = fillFieldPage.requiredFields.getText();
        assertEquals("Заполнены не все обязательные поля", actualFields);

    }
}
