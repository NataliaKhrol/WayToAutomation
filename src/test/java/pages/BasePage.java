package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class BasePage {

    WebDriver driver;
    WebDriverWait wait;

    public static final String BASE_URL = "https://www.way2automation.com/way2auto_jquery/registration.php#load_box";

    public BasePage(WebDriver driver) {

        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize(); //открывает браузер в полном окне
    }
    @Step("Opening the login page")
    public BasePage open(){
         driver.get(BASE_URL);
    return this;
    }
}

