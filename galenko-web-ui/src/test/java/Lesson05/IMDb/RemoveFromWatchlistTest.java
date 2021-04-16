package Lesson05.IMDb;

import Lesson05.Lesson05;
import Lesson05.IMDb_Login;
import Lesson05.IMDb_Add_Remove;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class RemoveFromWatchlistTest {

    static WebDriver driver = Lesson05.driver;
    private static JavascriptExecutor jsEx = (JavascriptExecutor) driver;
    private static Actions builder = Lesson05.builder;
    static WebDriverWait waitFiveSec = new WebDriverWait(driver, 5);

    @BeforeAll
    public static void login(){
        IMDb_Login.login();
    }

    @AfterAll
    public static void quit(){
        driver.quit();
    }

    @BeforeEach
    public void add() {
        IMDb_Add_Remove.add();
    }

    @Test
    public void removeFromWatchlistTest() {
        Object watchlistUrl = jsEx.executeScript(
                "var link = document.querySelector('.imdb-header__watchlist-button a').href; return link;");
        jsEx.executeScript("window.open('" + watchlistUrl + "', '_blank');");

        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        driver.findElement(By.xpath(".//div[@title='Click to remove from watchlist' and @tconst='tt0068646']")).click();
        jsEx.executeScript("history.go(0);");

        Assertions.assertTrue(driver.findElements(By.xpath(
                ".//a[@href='/title/tt0068646/?ref_=wl_li_tt']")).size() < 1);
    }

    @Test
    public void removeFromMoviePageTest() {
        driver.findElement(By.xpath(".//div[@class='wl-ribbon standalone inWL']")).click();

        Assertions.assertTrue(driver.findElement(By.xpath(
                ".//div[@class='wl-ribbon standalone not-inWL']")).isDisplayed());
    }

    @Test
    public void removeFromEditWatchlistTest() {
        WebElement ribbon = driver.findElement(By.xpath(
                ".//div[@class='wl-ribbon standalone inWL']"));
        WebElement watchlistLink = driver.findElement(By.xpath(
                ".//span[@class='wlb_text' and text()='View Watchlist »']"));

        builder
                .moveToElement(ribbon)
                .click(watchlistLink)
                .build()
                .perform();

        driver.findElement(By.xpath(".//span[@class='lister-widget-sprite lister-action edit']")).click();
        driver.findElement(By.xpath(
                ".//a[@href='/title/tt0068646']/parent::div/parent::div/parent::div/div/div")).click();
        driver.findElement(By.xpath(".//a[@href='delete_items_content']")).click();
        driver.findElement(By.xpath(".//input[@class='items_content_submit flat-button' and @value='DELETE']")).click();
        waitFiveSec.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath(
                ".//a[@href='/title/tt0068646']"))));
        driver.findElement(By.xpath(".//button[@class='btn-raised btn-raised--primary list-edit-done']")).click();

        Assertions.assertTrue(driver.findElements(By.xpath(
                ".//a[@href='/title/tt0068646/?ref_=wl_li_tt']")).size() < 1);
    }
}
