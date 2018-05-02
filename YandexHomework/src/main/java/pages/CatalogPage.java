package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertTrue;
import steps.BaseSteps;


public class CatalogPage {

    @FindBy(xpath = "//a[contains(text(), 'Перейти ко всем фильтрам')]")
    WebElement allFilter;

    @FindBy(xpath = "//div[contains(@class, 'n-pager-more')]")
    WebElement showMore;

    @FindBy(xpath = "//label[contains(@class, 'side_right')]/input")
    WebElement showListButton;

    @FindBy(xpath = "//div[contains(@class, 'vertical metrika')]/div[1]/div[contains(@class, 'center')]/div[contains(@class, 'header')]/div")
    WebElement firstProduct;

    @FindBy(xpath = "//input[@id='header-search']")
    WebElement searchProduct;

    @FindBy(xpath = "//span[@class='search2__button']//button[@role='button']")
    WebElement searchButton;

    @FindBy(xpath = "//div[@class = 'n-product-title__text-container-top']/div")
    WebElement productTitle;

    public void selectAllFilter(){
        PageFactory.initElements(BaseSteps.getDriver(),this);
        Wait<WebDriver> wait = new WebDriverWait(BaseSteps.getDriver(),5,1000);
        wait.until(ExpectedConditions.visibilityOf(allFilter));
        allFilter.click();
    }

    public String checkTotalProduct(){
        String total = showMore.getAttribute("total");
        return total;
    }

    public void checkFirstNameProduct(){
        PageFactory.initElements(BaseSteps.getDriver(),this);
        Wait<WebDriver> wait = new WebDriverWait(BaseSteps.getDriver(),5,1000);

        showListButton.click();

        wait.until(ExpectedConditions.visibilityOf(firstProduct));
        String firstTitle = firstProduct.findElement(By.xpath("./a")).getAttribute("title");
        firstTitle = firstTitle.replaceAll("Наушники","");

        searchProduct.sendKeys(firstTitle);
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
        searchButton.click();

        wait.until(ExpectedConditions.visibilityOf(productTitle));
        String secondTitle = productTitle.findElement(By.xpath("./h1")).getText();
        secondTitle = secondTitle.replaceAll("Наушники","");

        assertTrue(String.format("Наименование товара в списке - [%s]. Наименование после поиска - [$s]", firstTitle, secondTitle),firstTitle.contains(secondTitle));
    }

}
