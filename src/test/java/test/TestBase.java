package test;

import common.ApplicationManager;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ScreenshotListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

@Listeners({ScreenshotListener.class})
public class TestBase {

    // Variables

    public static ApplicationManager app;
    protected static WebDriver driver;
    protected static String baseUrl;
    protected static WebDriverWait wait;

    // Methods

    @BeforeSuite
    public void setUp() {
        app = new ApplicationManager();
        driver = app.getDriver();
        baseUrl = app.getBaseUrl();
        wait = app.getWait();
    }

    @BeforeMethod
    public void set() {
        driver.get(baseUrl);
    }

    @AfterMethod
    public void clean() {
        driver.manage().deleteAllCookies();
    }

    @AfterSuite()
    public void tearsDown() {
        driver.quit();
    }
}