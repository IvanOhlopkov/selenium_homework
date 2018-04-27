import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BaseTest {
    protected static WebDriver driver;
    protected static String baseUrl;

    public static Properties properties =  TestProperties.getInstance().getProperties();

    @BeforeClass
    public static void setup() throws Exception{
        switch (properties.getProperty("browser")){
            case "firefox":
                System.setProperty("webdriver.gecko.driver", properties.getProperty("webdriver.gecko"));
                driver = new FirefoxDriver();
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome"));
                driver = new ChromeDriver();
                break;
            default:
                System.setProperty("webdriver.chrome.driver", properties.getProperty("webriver.chrome"));
                driver = new ChromeDriver();
        }

        baseUrl = properties.getProperty("url");
        System.out.println(baseUrl);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    public static void tabPage() {
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
    }

    @AfterClass
    public static void quit() throws Exception{
        driver.quit();
    }
    protected boolean isElementPresent(By by){
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e){
            return false;
        }
    }
}
