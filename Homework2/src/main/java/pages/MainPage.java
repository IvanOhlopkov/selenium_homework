package pages;

import junit.runner.BaseTestRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class MainPage {

    @FindBy(xpath = "//div[contains(@class,'more_nav')]//div[@class = 'alt-menu-mid']//ul")

    WebElement mainMenu;

    @FindBy(xpath = "//div[@class='sbrf-div-list-inner --area bp-area header_more_nav']//ul[contains(@class,'mid__list')]//li[5]//div[contains(@class,'_hidder')]")
    WebElement subMenu;

    @FindBy(xpath = "//div[contains(@class,'more_nav')]//div[@class = 'alt-menu-mid']//ul/li/a/span[@class = 'multiline']/span[contains(text(), 'Застраховать себя')]/parent::span/parent::a")
    WebElement menuButton;

    public MainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        //Wait<WebDriver> wait =  new WebDriverWait(driver,10,1000);
        //wait.until(ExpectedConditions.elementToBeClickable(menuButton));
    }


    public void selectMainMenu(String menuItem){

        //Wait<WebDriver> wait = new WebDriverWait(driver,10,1000);
        //wait.until(ExpectedConditions.elementToBeClickable(mainMenu.findElement(By.xpath("./li/a/span/span[contains(text(),'"+menuItem+"')]"))));
        mainMenu.findElement(By.xpath("./li/a/span/span[contains(text(),'"+menuItem+"')]")).click();
        mainMenu.findElement(By.xpath("./li/a/span/span[contains(text(),'"+menuItem+"')]")).click();
        mainMenu.findElement(By.xpath("./li/a/span/span[contains(text(),'"+menuItem+"')]")).click();
        mainMenu.findElement(By.xpath("./li/a/span/span[contains(text(),'"+menuItem+"')]")).click();
    }

    public void selectSubMenu(String menuItem){

        subMenu.findElement(By.xpath(".//a[contains(text(),'"+menuItem+"')]")).click();
    }
}