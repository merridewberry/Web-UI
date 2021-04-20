package Lesson06;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Login extends Driver {

    @FindBy(css = "input[name='_username']")
    private WebElement inputLogin;

    @FindBy(css = "input[name='_password']")
    private WebElement inputPassword;

    @FindBy(css = "button[name='_submit']")
    private WebElement submit;

    @FindBy(xpath =  ".//ul[@class='nav nav-multilevel main-menu']")
    private WebElement mainMenu;

    @FindBy(xpath =  ".//ul[@class='nav nav-multilevel main-menu']")
    private List<WebElement> mainMenus;

    public Login(WebDriver driver) {
        super(driver);
    }

    public Login enterLogin(String login) {
        inputLogin.sendKeys(login);
        return this;
    }

    public Login enterPassword(String password) {
        inputPassword.sendKeys(password);
        return this;
    }

    public Login clickSubmit() {
        submit.click();
        return this;
    }

    public void checkLoginTrue() {
        Assertions.assertTrue(mainMenu.isDisplayed());
    }

    public boolean clickSubmitNegative() {
        try{
            submit.click();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public void checkLoginFalse() {
       Assertions.assertFalse(clickSubmitNegative());
    }

    public void signIn(String login, String password) {
        inputLogin.sendKeys(login);
        inputPassword.sendKeys(password);
        submit.click();
    }
}
