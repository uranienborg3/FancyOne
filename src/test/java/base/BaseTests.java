package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.TopBase;

import java.util.concurrent.TimeUnit;

public class BaseTests {

    private WebDriver driver;
    public TopBase topbase;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        goHome();
    }

    @BeforeMethod
    public void goHome() {
        driver.get("http://automationpractice.com/index.php");
//        driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
        topbase = new TopBase(driver);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}