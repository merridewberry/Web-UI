package Lesson03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IMDB_Refine_Watchlist {

    private static final String URL = "https://www.imdb.com/";
    static WebDriver driver = Lesson03.driver;

    public static void refine() throws InterruptedException {
        driver.get(URL);

        driver.findElement(By.xpath(".//div[text()='Watchlist']")).click();
        driver.findElement(By.xpath(".//button[text()='REFINE']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(".//li/span[text()='Genres']")).click();
        driver.findElement(By.xpath(".//label/span[text()='Comedy']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(".//li/span[text()='Type (Film, TV, etc.)']")).click();
        driver.findElement(By.xpath(".//label/span[text()='Feature Film']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(".//button[text()='REFINE']")).click();

    }
}
