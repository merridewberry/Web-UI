package Lesson06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import static Lesson06.Values.LOGIN_URL;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public abstract class DriverTest {

    public static WebDriver driver;
    public static Actions builder;

    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void prepareTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");

        driver = new ChromeDriver(options);
        driver.manage().window().setSize(new Dimension(1600, 1000));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.get(LOGIN_URL);

        builder = new Actions(driver);
    }

    @AfterEach
    public void quit() throws IOException {
        LogEntries browserLogs = driver.manage().logs().get(LogType.BROWSER);
        List<LogEntry> allLogRows = browserLogs.getAll();
        if (allLogRows.size() > 0 ) {
            writeLog(allLogRows);
        }
        driver.quit();
    }

    private void writeLog(List<LogEntry> allLogRows)  throws IOException  {
        BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt", true));
        List<String> logMessages = allLogRows.stream()
                .map(logRow -> logRow.getMessage())
                .collect(Collectors.toList());
        for (int i = 0; i < logMessages.size(); i++) {
            writer.append(logMessages.get(i));
            writer.append("\n");
        }
        writer.append("\n\n\n");
        writer.close();
    }
}
