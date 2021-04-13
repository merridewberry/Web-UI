package Lesson05.IMDb;

import Lesson05.IMDb_Login;
import Lesson05.Lesson05;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginTest {

    static WebDriver driver = Lesson05.driver;

    @AfterAll
    public static void quit(){
        driver.quit();
    }

    @Test
    public void loginTest(){
        IMDb_Login.login();
        Assertions.assertTrue(driver.findElement(By.xpath(
                ".//svg[@class='ipc-icon ipc-icon--account-circle ipc-button__icon ipc-button__icon--pre']"
        )).isDisplayed());
    }
}
