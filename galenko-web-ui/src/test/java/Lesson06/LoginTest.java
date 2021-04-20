package Lesson06;

import org.junit.jupiter.api.Test;
import static Lesson06.Values.LOGIN;
import static Lesson06.Values.PASSWORD;

public class LoginTest extends DriverTest {

    @Test
    public void positiveLoginTest() {
        new Login(driver)
                .enterLogin(LOGIN)
                .enterPassword(PASSWORD)
                .clickSubmit()
                .checkLoginTrue();
    }

    @Test
    public void emptyFieldsTest(){
        new Login(driver)
                .checkLoginFalse();
    }

    @Test
    public void emptyLoginTest(){
        new Login(driver)
                .enterPassword(PASSWORD)
                .checkLoginFalse();
    }

    @Test
    public void emptyPasswordTest(){
        new Login(driver)
                .enterLogin(LOGIN)
                .checkLoginFalse();
    }

    @Test
    public void wrongLoginTest(){
        new Login(driver)
                .enterLogin("LOGIN")
                .enterPassword(PASSWORD)
                .checkLoginFalse();
    }

    @Test
    public void wrongPasswordTest(){
        new Login(driver)
                .enterLogin(LOGIN)
                .enterPassword("PASSWORD")
                .checkLoginFalse();
    }



}
