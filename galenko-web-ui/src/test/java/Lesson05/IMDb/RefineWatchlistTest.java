package Lesson05.IMDb;

import Lesson05.Lesson05;
import Lesson05.IMDb_Login;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RefineWatchlistTest {

    private static final String URL = "https://www.imdb.com/";
    static WebDriver driver = Lesson05.driver;

    @BeforeAll
    public static void login(){
        IMDb_Login.login();
    }

    @AfterAll
    public static void quit(){
        driver.quit();
    }

    @Test
    public void refineTest() {
        driver.get(URL);

        driver.findElement(By.xpath(".//div[text()='Watchlist']")).click();
        driver.findElement(By.xpath(".//button[text()='REFINE']")).click();
        driver.findElement(By.xpath(".//li/span[text()='Genres']")).click();
        driver.findElement(By.xpath(".//label/span[text()='Comedy']")).click();
        driver.findElement(By.xpath(".//li/span[text()='Type (Film, TV, etc.)']")).click();
        driver.findElement(By.xpath(".//label/span[text()='Feature Film']")).click();
        driver.findElement(By.xpath(".//button[text()='REFINE']")).click();

        Assertions.assertTrue(driver.findElements(By.xpath(
                ".//a[@href='https://www.imdb.com/title/tt2164430/?ref_=wl_li_tt']")).size() < 1);

    }
}
