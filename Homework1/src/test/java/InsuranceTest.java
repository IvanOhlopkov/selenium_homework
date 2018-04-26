
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InsuranceTest {
    WebDriver driver;
    String baseUrl;

    @Before
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
        baseUrl = "http://www.sberbank.ru/ru/person";
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void testInsurance() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/table/tbody/tr/td/div/div/div/div/div/div[1]/div[1]/div[4]/div/div/div/ul/li[5]/a/span/span[1]")).click();
        driver.findElement(By.xpath("//li[@class='alt-menu-collapser alt-menu-collapser_branch alt-menu-collapser_opened alt-menu-collapser_delayed-hover alt-menu-mid__item']//div[@class='alt-menu-collapser__area alt-menu-collapser__area_cols_3']//div[@class='alt-menu-collapser__hidder']//div[@class='alt-menu-collapser__column']//div[@class='alt-menu-list__item alt-menu-list__item_leaf alt-menu-list__item_closed alt-menu-list__item_level_1']//a[@class='kit-link kit-link_color_black alt-menu-list__link alt-menu-list__link_level_1']")).click();
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);

        WebElement check = driver.findElement(By.xpath("//div[contains(@class,'sbrf-rich-out')]/H1"));
        wait.until(ExpectedConditions.visibilityOf(check));
        Assert.assertEquals("Страхование путешественников", check.getText());

        WebElement sendBtn = driver.findElement(By.xpath("//p//a//*[contains(@src,'portalserver')]"));
        wait.until(ExpectedConditions.visibilityOf(sendBtn)).click();

        //переход по вкладке 2
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));

        Wait<WebDriver> wait2 = new WebDriverWait(driver, 5, 1000);
        WebElement check2 = driver.findElement(By.xpath("//div[@ng-show='!cbi']//h2[@class='l-header-title ng-binding']"));
        wait2.until(ExpectedConditions.visibilityOf(check2));
        Assert.assertEquals("Страхование путешественников",check2.getText());

        driver.findElement(By.xpath("//div[@class='b-form-box-title ng-binding'][contains(text(),'Минимальная')]")).click();
        driver.findElement(By.xpath("//span[@ng-click='save()']")).click();
        //заполняем
        fillField(By.name("insured0_surname"), "IVANOV");
        fillField(By.name("insured0_name"), "IVAN");
        fillField(By.name("insured0_birthDate"),"01.01.1990");
        fillField(By.name("surname"), "Петров");
        fillField(By.name("name"), "Петр");
        fillField(By.name("middlename"),"Петрович");
        fillField(By.name("birthDate"),"02.02.1992");

        driver.findElement(By.xpath("//fieldset//span//input[@name='male']")).click();

        fillField(By.name("passport_series"), "1230");
        fillField(By.name("passport_number"), "456789");
        fillField(By.name("issueDate"), "02.02.2016");
        fillField(By.name("issuePlace"),"УВД г.Тестовый");

        driver.findElement(By.xpath("//span[@ng-click='save()']")).click();

        //Проверки
        assertEquals("IVANOV", driver.findElement(By.name("insured0_surname")).getAttribute("value"));
        assertEquals("IVAN", driver.findElement(By.name("insured0_name")).getAttribute("value"));
        assertEquals("01.01.1990", driver.findElement(By.name("insured0_birthDate")).getAttribute("value"));
        assertEquals("Петров", driver.findElement(By.name("surname")).getAttribute("value"));
        assertEquals("Петр", driver.findElement(By.name("name")).getAttribute("value"));
        assertEquals("Петрович", driver.findElement(By.name("middlename")).getAttribute("value"));
        assertEquals("02.02.1992", driver.findElement(By.name("birthDate")).getAttribute("value"));
        assertEquals("1230", driver.findElement(By.name("passport_series")).getAttribute("value"));
        assertEquals("456789", driver.findElement(By.name("passport_number")).getAttribute("value"));
        assertEquals("02.02.2016", driver.findElement(By.name("issueDate")).getAttribute("value"));
        assertEquals("УВД г.Тестовый", driver.findElement(By.name("issuePlace")).getAttribute("value"));
        //на обязательность полей
        assertEquals("Заполнены не все обязательные поля", driver.findElement(By.xpath("//div[@ng-show='tryNext && myForm.$invalid']")).getText());

    }
    public void fillField(By locator, String value){
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
    }
    @After
    public void afterTest(){
        driver.quit();
    }
}
