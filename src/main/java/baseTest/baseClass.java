package baseTest;

import com.aventstack.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import utility.ConfigReader;
import utility.listener;
import utility.extentReport;

import java.time.Duration;
import java.util.List;

import static utility.extentReport.extent;

@Listeners(listener.class)

public class baseClass extends listener {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static ExtentTest test;
    static WebElement ele;
    public static String url = ConfigReader.getProperty("url");
    public static String username = ConfigReader.getProperty("Email");
    public static String password = ConfigReader.getProperty("Password");
    public static int timeout = Integer.parseInt(ConfigReader.getProperty("timeout"));
    ChromeOptions options = new ChromeOptions();


    public static void openUrl(String URL) throws InterruptedException {
        driver.get(URL);
        String title = driver.getTitle();
        Assert.assertEquals("eAmata", title);
        Thread.sleep(2000);
        driver.manage().window().maximize();
    }

    @BeforeSuite
    public void report() {
        this.test = extentReport.Extent();
    }

    @Parameters({"browser", "headless"})
    @BeforeMethod
    public WebDriver setup(@Optional("chrome") String browser, @Optional("false") String headless) { // @optional provides default chrome if not provided
        String Browser = browser.toUpperCase();
        if (headless.equalsIgnoreCase("true")) {
//            options.addArguments("--headless");
//            options.addArguments("--disable-gpu");
//            options.addArguments("--no-sandbox");
//            options.addArguments("--window-size=1920,1080");
        }

        switch (Browser) {
            case "CHROME":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(options);
                break;
            case "EDGE":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "FIREFOX":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                System.out.println("Browser not found! ");
        }
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        return driver;
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }

    }

    @AfterSuite
    public static void tearDownReport() {
        extent.flush();
    }

    public static WebElement findByName(String path) {
        ele = driver.findElement(By.name(path));
        return ele;
    }

    public static List<WebElement> findByName(String path, String isList) {
        List<WebElement> list = driver.findElements(By.name(path));
        return list;
    }


    public static WebElement findByName(String path, boolean isWait) {
        ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(path)));
        return ele;
    }


    public static WebElement findByXpath(String path) {
        ele = driver.findElement(By.xpath(path));
        return ele;
    }

    public static List<WebElement> findByXpath(String path, String isList) {
        List<WebElement> list = driver.findElements(By.xpath(path));
        return list;
    }


    public static WebElement findByXpath(String path, boolean isWait) {
        ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));
        return ele;
    }

}
