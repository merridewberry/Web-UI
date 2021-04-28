package Lesson06;

import io.qameta.allure.Step;
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

    @Step(value = "Enter login {login}")
    public Login enterLogin(String login) {
        inputLogin.sendKeys(login);
        return this;
    }

    @Step(value = "Enter password {password}")
    public Login enterPassword(String password) {
        inputPassword.sendKeys(password);
        return this;
    }

    @Step(value = "Click submit button")
    public Login clickSubmit() {
        submit.click();
        return this;
    }

    @Step(value = "Check if login was successful")
    public void checkLoginTrue() {
        Assertions.assertTrue(mainMenu.isDisplayed());
    }

    public boolean clickSubmitNegative() {
        try{
            submit.click();
        } catch (Exception e) {
            return false;
        }
        return mainMenus.size() > 0;
    }

    @Step(value = "Check if login was unsuccessful")
    public void checkLoginFalse() {
       Assertions.assertFalse(clickSubmitNegative());
    }

    @Step(value = "Sign in with login \'{login}\' and password \'{password}\'")
    public void signIn(String login, String password) {
        inputLogin.sendKeys(login);
        inputPassword.sendKeys(password);
        submit.click();
    }
}
