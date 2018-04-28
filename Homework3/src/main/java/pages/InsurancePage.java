package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InsurancePage {

    @FindBy(xpath = "//p//a//*[contains(@src,'portalserver')]")
    public WebElement sendButton;

    public InsurancePage(WebDriver driver){
        PageFactory.initElements(driver,this);
        Wait<WebDriver> wait =  new WebDriverWait(driver,5,1000);
        wait.until(ExpectedConditions.visibilityOf(sendButton));
    }
}
