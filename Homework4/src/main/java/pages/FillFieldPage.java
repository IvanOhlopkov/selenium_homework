package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class FillFieldPage{

    @FindBy(xpath = "//div[@ng-show='!cbi']//h2[@class='l-header-title ng-binding']")
    public WebElement title;

    @FindBy(xpath = "//div[contains(@class,'b-form-prog-block ng-scope')]/parent::div")
    WebElement block;

    public FillFieldPage(){
        PageFactory.initElements(BaseSteps.getDriver(), this);
        Wait<WebDriver> wait =  new WebDriverWait(BaseSteps.getDriver(),5,1000);
        wait.until(ExpectedConditions.visibilityOf(title));
    }

    public void selectBlockItem(String menuItem){
        block.findElement(By.xpath(".//div[contains(text(),'"+menuItem+"')]")).click();

    }

    @FindBy(xpath = "//span[@ng-click='save()']")
    public WebElement sendButton;

    @FindBy(name = "insured0_surname")
    public WebElement insuredSurname;

    @FindBy(name = "insured0_name")
    public WebElement insuredName;

    @FindBy(name = "insured0_birthDate")
    public WebElement insuredBirthDate;

    @FindBy(name = "surname")
    public WebElement surName;

    @FindBy(name = "name")
    public WebElement name;

    @FindBy(name = "middlename")
    public WebElement middleName;

    @FindBy(name = "birthDate")
    public WebElement birthDate;

    @FindBy(xpath = "//fieldset[@class='b-form-fieldset-splash b-form-margtop-fieldset']")
    public WebElement gender;

    public void selectGender(String menuItem) {
        gender.findElement(By.xpath("./label[contains(text(),'"+menuItem+"')]")).click();
    }

    @FindBy(name = "passport_series")
    public WebElement passportSeries;

    @FindBy(name = "passport_number")
    public WebElement passportNumber;

    @FindBy(name = "issueDate")
    public WebElement issueDate;

    @FindBy(name = "issuePlace")
    public WebElement issuePlace;

    @FindBy(xpath = "//div[@ng-show='tryNext && myForm.$invalid']")
    public WebElement requiredFields;

    public void fillField(String fieldName, String value){
        switch (fieldName){
            case "Фамилия застрахованного(англ)":
                fieldField(insuredSurname, value);
                break;
            case "Имя застрахованного(англ)":
                fieldField(insuredName, value);
                break;
            case "Дата рождения застрахованного":
                fieldField(insuredBirthDate, value);
                break;
            case "Фамилия":
                fieldField(surName, value);
                break;
            case "Имя":
                fieldField(name, value);
                break;
            case "Отчество":
                fieldField(middleName, value);
                break;
            case "Дата рождения":
                fieldField(birthDate, value);
                break;
            case "Серия паспорта":
                fieldField(passportSeries, value);
                break;
            case "Номер паспорта":
                fieldField(passportNumber, value);
                break;
            case "Дата выдачи":
                fieldField(issueDate, value);
                break;
            case "Кем выдан":
                fieldField(issuePlace, value);
                break;
            default: throw new AssertionError("Поле '"+fieldName+"' не объявлено на странице");
        }
    }
    protected void fieldField(WebElement element, String value){
        element.clear();
        element.sendKeys(value);
    }

    public void checkFillField(String value, String fieldName){
        switch (fieldName){
            case "Фамилия застрахованного(англ)":
                checkField(value, insuredSurname);
                break;
            case "Имя застрахованного(англ)":
                checkField(value, insuredName);
                break;
            case "Дата рождения застрахованного":
                checkField(value, insuredBirthDate);
                break;
            case "Фамилия":
                checkField(value, surName);
                break;
            case "Имя":
                checkField(value, name);
                break;
            case "Отчество":
                checkField(value, middleName);
                break;
            case "Дата рождения":
                checkField(value, birthDate);
                break;
            case "Серия паспорта":
                checkField(value, passportSeries);
                break;
            case "Номер паспорта":
                checkField(value, passportNumber);
                break;
            case "Дата выдачи":
                checkField(value, issueDate);
                break;
            case "Кем выдан":
                checkField(value, issuePlace);
                break;
            default: throw new AssertionError("Поле '"+fieldName+"' не объявлено на странице");
        }
    }
    protected void checkField(String checkText, WebElement element){
        String text = element.getAttribute("value");
        assertEquals(checkText, text);
    }
}
