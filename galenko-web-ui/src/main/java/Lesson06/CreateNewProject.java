package Lesson06;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CreateNewProject extends Driver{

    private static final String PR_COMPANY_NAME = "1234";
    private static final String PR_CONTACT = "A B";

    @FindBy (xpath = ".//a[text()='Создать проект']")
    private WebElement createProjectButton;

    @FindBy (name = "crm_project[name]")
    private WebElement projectName;

    @FindBy (xpath = ".//span[text()='Укажите организацию']")
    private WebElement selectCompany;

    @FindBy(xpath = ".//input[@class='select2-input select2-focused']")
    private WebElement inputCompanyName;

    @FindBy (xpath = ".//span[@class='select2-match' and text()='" + PR_COMPANY_NAME + "']")
    private WebElement clickCompanyName;

    @FindBy (xpath = ".//div[@class='controls']/div[@class='select2-container select2']/a")
    private WebElement selectContact;

    @FindBy(xpath = ".//div[@class='select2-search']/input")
    private List<WebElement> inputContactName;

    @FindBy (xpath = ".//span[@class='select2-match' and text()='" + PR_CONTACT + "']")
    private WebElement clickContactName;

    @FindBy (name = "crm_project[businessUnit]")
    private WebElement businessUnit;

    @FindBy (name = "crm_project[curator]")
    private WebElement curator;

    @FindBy (name = "crm_project[rp]")
    private WebElement rp;

    @FindBy (name = "crm_project[administrator]")
    private WebElement administrator;

    @FindBy (name = "crm_project[manager]")
    private WebElement manager;

    @FindBy (xpath = ".//button[@class='btn btn-success action-button']")
    private WebElement submitButton;

    @FindBy (xpath = ".//div[@class='message' and text()='Проект сохранен']")
    private WebElement message;

    public CreateNewProject(WebDriver driver) {
        super(driver);
    }

    public CreateNewProject createNewProject() {
        createProjectButton.click();
        return this;
    }

    public CreateNewProject inputProjectName(String name) {
        projectName.sendKeys(name);
        return this;
    }

    public CreateNewProject chooseCompany(String name) {
        selectCompany.click();
        inputCompanyName.sendKeys(name);
        clickCompanyName.click();
        return this;
    }

    public CreateNewProject chooseContact(String name) {
        selectContact.click();
        inputContactName.get(1).sendKeys(name);
        clickContactName.click();
        return this;
    }

    public CreateNewProject chooseBusinessUnit(String unit) {
        Select bUnit = new Select(businessUnit);
        bUnit.selectByValue(unit);
        return this;
    }

    public CreateNewProject chooseCurator(String name) {
        Select cur = new Select(curator);
        cur.selectByVisibleText(name);
        return this;
    }

    public CreateNewProject chooseRP(String name) {
        Select lead = new Select(rp);
        lead.selectByVisibleText(name);
        return this;
    }

    public CreateNewProject chooseAdministrator(String name) {
        Select admin = new Select(administrator);
        admin.selectByVisibleText(name);
        return this;
    }

    public CreateNewProject chooseManager(String name) {
        Select man = new Select(manager);
        man.selectByVisibleText(name);
        return this;
    }

    public CreateNewProject submitNewProject() {
        submitButton.click();
        return this;
    }

    public void checkSuccess() {
        Assertions.assertTrue(message.isDisplayed());
    }
}
