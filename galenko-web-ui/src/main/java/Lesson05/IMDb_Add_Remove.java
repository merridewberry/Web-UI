package Lesson05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IMDb_Add_Remove {

    private static final String MOVIE_URL = "https://www.imdb.com/title/tt0068646/?ref_=wl_li_tt";
    static WebDriver driver = Lesson05.driver;

    public static void add() {
        driver.get(MOVIE_URL);
        driver.findElement(By.xpath(".//div[@class='wl-ribbon standalone not-inWL']")).click();
    }

    public static void remove(){
        driver.get(MOVIE_URL);
        driver.findElement(By.xpath(".//div[@class='wl-ribbon standalone inWL']")).click();
    }
}
