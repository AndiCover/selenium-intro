package at.andicover.seleniumintro;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

class BaseTest {
    protected static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(5);

    protected static WebDriver driver;
    protected static WebDriverWait wait;

    @BeforeAll
    public static void setup() {
        initWebDriver();
    }

    private static void initWebDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, DEFAULT_TIMEOUT);
    }

    @AfterAll
    public static void cleanUp() {
        if (driver != null) {
            driver.quit();
        }
    }
}