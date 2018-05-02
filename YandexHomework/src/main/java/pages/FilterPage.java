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

public class FilterPage {

    @FindBy(xpath = "//input[@id='glf-pricefrom-var']")
    WebElement priceFrom;

    @FindBy(xpath = "//span[contains(text(), 'Производитель')]/parent::h4/parent::div/parent::div")
    WebElement manafacturer;

    @FindBy(xpath = "//div[@class='layout layout_type_maya']//a/span[contains(text(), 'Показать подходящие')]/parent::a")
    WebElement applyFilter;

    public void setPriceFrom(String priceItem){
        PageFactory.initElements(BaseSteps.getDriver(),this);
        Wait<WebDriver> wait = new WebDriverWait(BaseSteps.getDriver(),5,1000);
        wait.until(ExpectedConditions.visibilityOf(priceFrom));
        priceFrom.sendKeys(priceItem);
    }

    public void selectManafacturer(String manafacturerItem){
        PageFactory.initElements(BaseSteps.getDriver(),this);
        Wait<WebDriver> wait = new WebDriverWait(BaseSteps.getDriver(),5,1000);
        wait.until(ExpectedConditions.visibilityOf(manafacturer));
        manafacturer.findElement(By.xpath(".//label[contains(text(), '"+manafacturerItem+"')]")).click();
    }

    public void setApplyFilter(){
        PageFactory.initElements(BaseSteps.getDriver(),this);
        Wait<WebDriver> wait = new WebDriverWait(BaseSteps.getDriver(),5,1000);
        wait.until(ExpectedConditions.elementToBeClickable(applyFilter)).click();
    }
}
