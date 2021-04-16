package Lesson05.IMDb;

import Lesson05.Lesson05;
import Lesson05.IMDb_Login;
import Lesson05.IMDb_Add_Remove;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import java.util.ArrayList;

public class AddToWatchlistTest {

    private static final String MOVIE_URL = "https://www.imdb.com/title/tt0068646/?ref_=wl_li_tt";
    static WebDriver driver = Lesson05.driver;
    private static JavascriptExecutor jsEx = (JavascriptExecutor) driver;
    private static Actions builder = Lesson05.builder;

    @BeforeAll
    public static void login(){
        IMDb_Login.login();
    }

    @AfterAll
    public static void quit(){
        driver.quit();
    }

    @AfterEach
    public void remove() {
        IMDb_Add_Remove.remove();
    }

    @Test
    public void addByButtonTest() {
        driver.get(MOVIE_URL);

        driver.findElement(By.xpath(".//div[text()='Add to Watchlist']")).click();

        Assertions.assertTrue(driver.findElement(By.xpath(".//div[@class='wl-ribbon standalone inWL']")).isDisplayed());
    }

    @Test
    public void addByRibbonTest() {
        driver.get(MOVIE_URL);

        Assumptions.assumeTrue(driver.findElement(By.xpath(".//div[@class='wl-ribbon standalone not-inWL']")).isDisplayed());

        driver.findElement(By.xpath(".//div[@class='wl-ribbon standalone not-inWL']")).click();

        Assertions.assertTrue(driver.findElement(By.xpath(".//div[@class='wl-ribbon standalone inWL']")).isDisplayed());
    }

    @Test
    public void addedMovieIsPresentInTheWatchlist() {
        IMDb_Add_Remove.add();

        Object watchlistUrl = jsEx.executeScript(
                "var link = document.querySelector('.imdb-header__watchlist-button a').href; return link;");
        jsEx.executeScript("window.open('" + watchlistUrl + "', '_blank');");

        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        Assertions.assertTrue(driver.findElement(By.xpath(".//a[@href='/title/tt0068646/?ref_=wl_li_tt']")).isDisplayed());
    }
}
