package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.BasePage;
import pages.RegistrationPage;

@Listeners(TestListener.class)
public class BaseTest {
    WebDriver driver;
    RegistrationPage registrationPage;
    BasePage basePage;

    @Parameters({"browser"})
    @BeforeMethod(description = "Opening the browser")
    // 1. Открыть браузер

    public void setup(@Optional("chrome") String browser, ITestContext context) {
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
             options.setHeadless(true);
            driver = new ChromeDriver(options);
        }
        context.setAttribute("driver", driver);

        registrationPage = new RegistrationPage(driver);
        basePage = new BasePage(driver);
    }

    @AfterMethod(alwaysRun = true, description = "Closing the browser")
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
