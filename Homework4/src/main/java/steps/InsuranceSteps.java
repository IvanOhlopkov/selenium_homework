package steps;

import pages.InsurancePage;
import ru.yandex.qatools.allure.annotations.Step;

public class InsuranceSteps{

    @Step("Выполнено нажатие на кнопку Оформить онлайн")
    public void stepSendButton(){
        new InsurancePage().sendButton.click();
    }
}
