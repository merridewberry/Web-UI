package Lesson05.IMDb;

import Lesson05.IMDb_Login;
import Lesson05.Lesson05;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindRateTest {

    private static final String URL = "https://www.imdb.com/";
    private static final String QUERY = "Swiss Army Man";
    static WebDriver driver = Lesson05.driver;
    static WebDriverWait waitFiveSec = new WebDriverWait(driver, 5);

    @BeforeAll
    public static void login(){
        IMDb_Login.login();
    }

    @AfterAll
    public static void quit(){
        driver.quit();
    }

    @Test
    public void findRateTest(){
        driver.get(URL);

        driver.findElement(By.name("q")).sendKeys(QUERY);
        driver.findElement(By.xpath(".//div[text()='" + QUERY + "']")).click();

        driver.findElement(By.xpath(".//span[@class='star-rating-star rating']")).click();
        waitFiveSec.until(ExpectedConditions.visibilityOf(
                driver.findElement(By.xpath(".//span[@class='star-rating-stars']/a[@title='Click to rate: 8']"))
        ));
        driver.findElement(By.xpath(".//span[@class='star-rating-stars']/a[@title='Click to rate: 8']")).click();
        driver.findElement(By.xpath(".//span[@class='star-rating-star rating']")).click();
        waitFiveSec.until(ExpectedConditions.visibilityOf(
                driver.findElement(By.xpath(".//span[@class='star-rating-stars']/a[@title='Click to rate: 10']"))
        ));
        driver.findElement(By.xpath(".//span[@class='star-rating-stars']/a[@title='Click to rate: 10']")).click();

        Assertions.assertTrue(driver.findElement(By.xpath(".//span[@class='star-rating-value' and text()='10']" +
                "/following-sibling::span[@class='star-rating-subtext' and text()='You']")).isDisplayed());
    }
}
