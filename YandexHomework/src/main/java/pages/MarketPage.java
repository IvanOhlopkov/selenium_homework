package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;

public class MarketPage {

    @FindBy(xpath = "//ul[@class='topmenu__list']")
    WebElement menuList;

    @FindBy(xpath = "//div[contains(@class, 'topmenu__sublist')]")
    WebElement subMenuElectronics;

    @FindBy(xpath = "//div[@class='n-region-notification b-zone i-bem n-region-notification_js_inited']")
    WebElement popup;

    @FindBy(xpath = "//div[@class='n-region-notification__header-location']")
    WebElement region;

    @FindBy(xpath = "//span[contains(@class, 'ok')]/parent::div")
    WebElement buttonYes;

    @FindBy(xpath = "//span[contains(@class, 'change')]/parent::div")
    WebElement buttonNo;

    @FindBy(xpath = "//div[contains(@class, 'input input_size')]//input")
    WebElement inputField;

    @FindBy(xpath = "//div[contains(@class, 'suggest2-item_type_text')][1]")
    WebElement regionSuggest;

    @FindBy(xpath = "//button[contains(@class, 'button region-select')]")
    WebElement selectRegion;

    @FindBy(xpath = "//div[@class = 'popup2__closer']")
    WebElement sendClose;

    public void selectMenuList(String menuItem){
        PageFactory.initElements(BaseSteps.getDriver(),this);
        Wait<WebDriver> wait = new WebDriverWait(BaseSteps.getDriver(),5,1000);
        wait.until(ExpectedConditions.visibilityOf(menuList)).findElement(By.xpath(".//a[@class='link topmenu__link'][contains(text(),'"+menuItem+"')]//parent::li"));
        new Actions(BaseSteps.getDriver()).moveToElement(menuList.findElement(By.xpath(".//a[@class='link topmenu__link'][contains(text(),'"+menuItem+"')]//parent::li"))).perform();
    }

    public void checkRegion(String checkText){
        PageFactory.initElements(BaseSteps.getDriver(), this);
        Wait<WebDriver> wait = new WebDriverWait(BaseSteps.getDriver(), 5, 1000);
        wait.until(ExpectedConditions.visibilityOf(popup));
        String text = region.getAttribute("value");
        if(text==null ? checkText==null : text.equals(checkText)){
            buttonYes.click();
        }else {
            wait.until(ExpectedConditions.elementToBeClickable(buttonNo)).click();
            inputField.sendKeys(checkText);
            wait.until(ExpectedConditions.visibilityOf(regionSuggest)).click();
            wait.until(ExpectedConditions.elementToBeClickable(selectRegion)).click();
            wait.until(ExpectedConditions.elementToBeClickable(sendClose)).click();
        }
    }

    public void setSubMenuElectronics(String subItem){
        PageFactory.initElements(BaseSteps.getDriver(),this);
        Wait<WebDriver> wait = new WebDriverWait(BaseSteps.getDriver(),5,1000);
        wait.until(ExpectedConditions.visibilityOf(subMenuElectronics));
        subMenuElectronics.findElement(By.xpath("./a[contains(text(), '"+subItem+"')]")).click();
    }

}
