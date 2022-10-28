package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.RegistrationPage;
import tests.BaseTest;

import java.util.List;

import static org.testng.Assert.*;

public class WatToAutomationTest extends BaseTest {
    public static final String BASE_URL = "https://www.way2automation.com/way2auto_jquery/registration.php#load_box";

    @Test
    public void entryAllFields() {

        new BasePage(driver).open();
        new RegistrationPage(driver).enterFirstName("Rada")
                .enterLastName("RadaR")
                .marriedStatus()
                .enterHobby()
                .enterPhone("3751354")
                .enterLogin("Radomir")
                .enterEmail("rada@sandbox.com")
                .enterPassword("Rada789")
                .submitRegistration();
        List<WebElement> errorElements = driver.findElements(By.className("error_p"));
        assertTrue(errorElements.isEmpty(), "Registration failed");

    }

    @Test
    public void emptyFields() {

        new BasePage(driver).open();
        new RegistrationPage(driver).enterFirstName("Rada")
                .enterLastName("RadaR")
                .marriedStatus()
                .enterHobby()
                .enterPhone(" ")
                .enterLogin(" ")
                .enterEmail("")
                .enterPassword("Rada789")
                .submitRegistration();
        boolean registrationFailed = driver.findElement(By.xpath("//label[contains(text(),'This field is required.')]")).isDisplayed();
        assertTrue(registrationFailed, "Registration passed but the required fields were left unfilled");
    }
}
