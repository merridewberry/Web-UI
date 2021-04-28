package Lesson06;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;

import static Lesson06.Values.LOGIN;
import static Lesson06.Values.PASSWORD;

@Feature("Login")
@Severity(SeverityLevel.BLOCKER)
public class LoginTest extends DriverTest {



    @Test
    @Description("Positive login test")
    public void positiveLoginTest() {
        new Login(driver)
                .enterLogin(LOGIN)
                .enterPassword(PASSWORD)
                .clickSubmit()
                .checkLoginTrue();
    }

    @Test
    @Disabled("Test saving console logs to txt file")
    public void consoleErrorTest() {
        new Login(driver);
        JavascriptExecutor jsEx = (JavascriptExecutor) driver;
        jsEx.executeScript("console.error('Error!')");
    }


    @Description("Negative login test with empty login and password fields")
    @Test
    public void emptyFieldsTest(){
        new Login(driver)
                .checkLoginFalse();
    }

    @Description("Negative login test with empty login field")
    @Test
    public void emptyLoginTest(){
        new Login(driver)
                .enterPassword(PASSWORD)
                .checkLoginFalse();
    }

    @Description("Negative login test with empty password field")
    @Test
    public void emptyPasswordTest(){
        new Login(driver)
                .enterLogin(LOGIN)
                .checkLoginFalse();
    }

    @Description("Negative login test with incorrect login")
    @Test
    public void wrongLoginTest(){
        new Login(driver)
                .enterLogin("LOGIN")
                .enterPassword(PASSWORD)
                .checkLoginFalse();
    }

    @Description("Negative login test with incorrect password")
    @Test
    public void wrongPasswordTest(){
        new Login(driver)
                .enterLogin(LOGIN)
                .enterPassword("PASSWORD")
                .checkLoginFalse();
    }
}
