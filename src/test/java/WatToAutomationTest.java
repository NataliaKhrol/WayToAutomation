import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class WatToAutomationTest extends BaseTest {

    public static final String BASE_URL = "https://www.way2automation.com/way2auto_jquery/registration.php#load_box";
    private final By FIRST_NAME = By.name("name");
    private final By LAST_NAME = By.xpath("(//input[@type=\"text\"])[2]");
    private final By MARRIED_STATUS = By.name("m_status");
    private final By HOBBY_READING = By.xpath("(//input[@type=\"checkbox\"])[2]");
    private final By PHONE_ENTRY = By.xpath("(//input[@name=\"phone\"])[1]");
    private final By LOGIN_ENTRY = By.xpath("(//input[@name=\"username\"])[1]");
    private final By EMAIL_ENTRY = By.xpath("(//input[@name=\"email\"])[1]");
    private final By PASSWORD_ENTRY = By.xpath("(//input[@name=\"password\"])[1]");
    private final By PASSWORD_CHECK = By.name("c_password");
    private final By SUBMIT_BUTTON = By.cssSelector("[value=\"submit\"]");

    @Test
    public void emptyFields() {

        driver.get(BASE_URL);

        driver.findElement(FIRST_NAME).sendKeys("Rada");
        driver.findElement(LAST_NAME).sendKeys("RadaR");
        driver.findElement(MARRIED_STATUS).click();
        driver.findElement(HOBBY_READING).click();
        driver.findElement(PHONE_ENTRY).sendKeys(" ");
        driver.findElement(LOGIN_ENTRY).sendKeys("Radomir");
        driver.findElement(EMAIL_ENTRY).sendKeys(" ");
        driver.findElement(PASSWORD_ENTRY).sendKeys("Rada789");
        driver.findElement(PASSWORD_CHECK).sendKeys("Rada789");
        driver.findElement(SUBMIT_BUTTON).click();
        boolean registrationFailed = driver.findElement(By.xpath("//label[contains(text(),'This field is required.')]")).isDisplayed();
        assertTrue(registrationFailed, "Registration passed but the required fields were left unfilled");
    }

    @Test
    public void correctRegistration() {

        driver.get(BASE_URL);

        driver.findElement(FIRST_NAME).sendKeys("Rada");
        driver.findElement(LAST_NAME).sendKeys("RadaR");
        driver.findElement(MARRIED_STATUS).click();
        driver.findElement(HOBBY_READING).click();
        driver.findElement(PHONE_ENTRY).sendKeys("+375 00089649");
        driver.findElement(LOGIN_ENTRY).sendKeys("Radomir");
        driver.findElement(EMAIL_ENTRY).sendKeys("rada@sandbox.com");
        driver.findElement(PASSWORD_ENTRY).sendKeys("Rada789");
        driver.findElement(PASSWORD_CHECK).sendKeys("Rada789");
        driver.findElement(SUBMIT_BUTTON).click();
        List<WebElement> errorElements = driver.findElements(By.className("error_p"));
        assertTrue(errorElements.isEmpty(), "Registration failed");
    }
}
