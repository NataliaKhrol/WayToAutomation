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

        basePage.open();
        registrationPage.enterFirstName("Rada")
                .enterLastName("RadaR")
                .marriedStatus()
                .enterHobby()
                .enterPhone("3751354")
                .enterLogin("Radomir")
                .enterEmail("rada@sandbox.com")
                .enterPassword("Rada789")
                .submitRegistration();
        assertTrue(registrationPage.errors(), "Registration failed");
    }

    @Test
    public void emptyFields() {

        basePage.open();
        registrationPage.enterFirstName("Rada")
                .enterLastName("RadaR")
                .marriedStatus()
                .enterHobby()
                .enterPhone(" ")
                .enterLogin(" ")
                .enterEmail("")
                .enterPassword("Rada789")
                .submitRegistration();
        assertTrue(registrationPage.shouldBeFilled(), "Registration passed but the required fields were left unfilled");
    }
}
