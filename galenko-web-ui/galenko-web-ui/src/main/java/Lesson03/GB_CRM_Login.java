package Lesson03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class GB_CRM_Login {

    private static final String URL = "https://crm.geekbrains.space/user/login";
    private static final String LOGIN = "Applanatest";
    private static final String PASSWORD = "Student2020!";
    private static WebDriver driver = Lesson03.driver;

    public static void login() {
        driver.get(URL);
        driver.findElement(By.cssSelector("input[name='_username']")).sendKeys(LOGIN);
        driver.findElement(By.cssSelector("input[name='_password']")).sendKeys(PASSWORD);
        driver.findElement(By.cssSelector("button[name='_submit']")).click();
    }
}
