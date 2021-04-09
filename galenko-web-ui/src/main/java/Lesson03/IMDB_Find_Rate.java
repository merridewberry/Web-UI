package Lesson03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IMDB_Find_Rate {

    private static final String URL = "https://www.imdb.com/";
    private static final String QUERY = "Swiss Army Man";
    static WebDriver driver = Lesson03.driver;
    static WebDriverWait waitFiveSec = new WebDriverWait(driver, 5);

    public static void findRate() throws InterruptedException {
        driver.get(URL);

        driver.findElement(By.name("q")).sendKeys(QUERY);
        driver.findElement(By.xpath(".//div[text()='" + QUERY + "']")).click();

        driver.findElement(By.xpath(".//span[@class='star-rating-star rating']")).click();
        waitFiveSec.until(ExpectedConditions.visibilityOf(
                driver.findElement(By.xpath(".//span[@class='star-rating-stars']/a[@title='Click to rate: 8']"))
        ));
        driver.findElement(By.xpath(".//span[@class='star-rating-stars']/a[@title='Click to rate: 8']")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath(".//span[@class='star-rating-star rating']")).click();
        waitFiveSec.until(ExpectedConditions.visibilityOf(
                driver.findElement(By.xpath(".//span[@class='star-rating-stars']/a[@title='Click to rate: 10']"))
        ));
        driver.findElement(By.xpath(".//span[@class='star-rating-stars']/a[@title='Click to rate: 10']")).click();
    }

}
