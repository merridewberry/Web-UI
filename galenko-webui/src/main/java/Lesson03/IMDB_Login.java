package Lesson03;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

public class IMDB_Login {

    private static final String URL = "https://www.imdb.com/";
    private static final String LOGIN = "availableloginplease@yandex.ru";
    private static final String PASSWORD = "Somepassword1";
    private static WebDriver driver = Lesson03.driver;

    public static void login() {

        driver.navigate().to(URL);
        Cookie cookie = new Cookie("at-main", "Atza|IwEBIECFxXywBGeSyyURBDD2RveH6MFn-5tX6b8LgoHHdibEWb1" +
                "a612DojjphaGUpbBHeRuDjjnvUDl9s_zFw5l-PQPFUXuUENjhP9w8kqgLWpfnJRN4EZRA66nUuWik4YPZ8wvssYUPJ4fVHnUacufc" +
                "SItMBkrxbL0tAfClJt56VeXBiJkVG_3riaEK574vSEXO9YRhBHY02xKF6JRFRuGeMr7qtnDCcxLNBLDQR0NRl92Tng");
        driver.manage().addCookie(cookie);

//        driver.get(URL);
//
//        driver.findElement(By.xpath(".//div[text()='Sign In']")).click();
//        driver.findElement(By.xpath(".//span[text()='Sign in with IMDb']")).click();
//        driver.findElement(By.name("email")).sendKeys(LOGIN);
//        driver.findElement(By.name("password")).sendKeys(PASSWORD);
//
//        driver.findElement(By.cssSelector("input[id='signInSubmit']")).click();
    }

}
