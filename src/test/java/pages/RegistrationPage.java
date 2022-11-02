package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertTrue;

public class RegistrationPage extends BasePage {

    By FIRST_NAME = By.name("name");
    By LAST_NAME = By.xpath("(//input[@type=\"text\"])[2]");
    By MARRIED_STATUS = By.name("m_status");
    By HOBBY_READING = By.xpath("(//input[@type=\"checkbox\"])[2]");
    By PHONE_ENTRY = By.xpath("(//input[@name=\"phone\"])[1]");
    By LOGIN_ENTRY = By.xpath("(//input[@name=\"username\"])[1]");
    By EMAIL_ENTRY = By.xpath("(//input[@name=\"email\"])[1]");
    By PASSWORD_ENTRY = By.xpath("(//input[@name=\"password\"])[1]");
    By PASSWORD_CHECK = By.name("c_password");
    By SUBMIT_BUTTON = By.cssSelector("[value=\"submit\"]");

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @Step("Register by {firstname}")
    public RegistrationPage enterFirstName(String firstName) {
        driver.findElement(FIRST_NAME).sendKeys(firstName);
        return this;
    }
    @Step("Register by {lastname}")
    public RegistrationPage enterLastName(String lastName) {
        driver.findElement(LAST_NAME).sendKeys(lastName);
        return this;
    }
    @Step("Register by indicating maritual status")
    public RegistrationPage marriedStatus() {
        driver.findElement(MARRIED_STATUS).click();
        return this;
    }

    @Step("Register by indicating hobies")
    public RegistrationPage enterHobby() {
        driver.findElement(HOBBY_READING).click();
        return this;
    }
    @Step("Register by indicating {phone}")
    public RegistrationPage enterPhone(String phone) {
        driver.findElement(PHONE_ENTRY).sendKeys(phone);
        return this;
    }
    @Step("Register by entering {login}")
    public RegistrationPage enterLogin(String login) {
        driver.findElement(LOGIN_ENTRY).sendKeys(login);
        return this;
    }
    @Step("Register by entering {email}")
    public RegistrationPage enterEmail(String email) {
        driver.findElement(EMAIL_ENTRY).sendKeys(email);
        return this;
    }
    @Step("Register by entering {password}")
    public RegistrationPage enterPassword(String password) {
        driver.findElement(PASSWORD_ENTRY).sendKeys(password);
        driver.findElement(PASSWORD_CHECK).sendKeys(password);
        return this;
    }
    @Step("Completion of registration")
    public RegistrationPage submitRegistration() {
        driver.findElement(SUBMIT_BUTTON).click();
        return this;
    }
    @Step("Error messages")
    public boolean errors() {
        boolean errorElements = driver.findElements(By.className("error_p")).isEmpty();
        return errorElements;
    }
    @Step("The required fields to be filled in")
    public boolean shouldBeFilled() {
        boolean registrationFailed = driver.findElement(By.xpath("//label[contains(text(),'This field is required.')]")).isDisplayed();
        return registrationFailed;
    }


}
