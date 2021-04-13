package Lesson05;


import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import java.util.concurrent.TimeUnit;
import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class Lesson05 {

    public static WebDriver driver;
    public static Actions builder;

    public static String randomizedProjectName = String.valueOf((int)(Math.random() * 1000)) + " Unique Title";

    static {
        chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        driver = new ChromeDriver(options);
        driver.manage().window().setSize(new Dimension(1600, 800));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        builder = new Actions(driver);
    }

}
