package Lesson03;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class Lesson03 {

    static final WebDriver driver;

    static {
        chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        driver = new ChromeDriver(options);
        driver.manage().window().setSize(new Dimension(1600, 800));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public static void main(String[] args) throws InterruptedException {

        try {

            GB_CRM_Login.login();
            GB_CRM_Add_Contact.addContact();
            GB_CRM_Add_Project.addProject();

            //IMDb периодически требует ввести капчу при логине, и, так как у меня нет фантазии, чтобы придумать
            //другой сайт для тестов, я засунула в IMDB_Login.login() куку, и оно сейчас логинится по ней.
            // Но нормальный логин там тоже реализован!

            IMDB_Login.login();
            IMDB_Find_Rate.findRate();
            IMDB_Refine_Watchlist.refine();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Thread.sleep(3000);
            driver.quit();
        }
    }
}
