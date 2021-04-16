package Lesson06;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateNewContact extends Driver {

    private static final String COMPANY_NAME = "1234";

    @FindBy (xpath = ".//a[text()='Создать контактное лицо']")
    private WebElement createNewContactButton;

    @FindBy (name = "crm_contact[lastName]")
    private WebElement lastName;

    @FindBy (name = "crm_contact[firstName]")
    private WebElement firstName;

    @FindBy (xpath = ".//span[text()='Укажите организацию']")
    private WebElement selectCompany;

    @FindBy (xpath = ".//input[@class='select2-input select2-focused']")
    private WebElement inputCompanyName;

    @FindBy (xpath = ".//span[@class='select2-match' and text()='" + COMPANY_NAME + "']")
    private WebElement clickCompanyName;

    @FindBy (name = "crm_contact[jobTitle]")
    private WebElement JobJTitle;

    @FindBy (xpath = ".//button[@class='btn btn-success action-button']")
    private WebElement submit;

    @FindBy (xpath = ".//div[@class='message' and text()='Контактное лицо сохранено']")
    private WebElement message;

    public CreateNewContact(WebDriver driver) {
        super(driver);
    }

    public CreateNewContact createNewContact() {
        createNewContactButton.click();
        return this;
    }

    public CreateNewContact inputLastName(String name) {
        lastName.sendKeys(name);
        return this;
    }

    public CreateNewContact inputFirstName(String name) {
        firstName.sendKeys(name);
        return this;
    }

    public CreateNewContact chooseCompany(String companyName) {
        selectCompany.click();
        inputCompanyName.sendKeys(companyName);
        clickCompanyName.click();
        return this;
    }

    public CreateNewContact inputJobTitle(String job) {
        JobJTitle.sendKeys(job);
        return this;
    }

    public CreateNewContact submitNewContact() {
        submit.click();
        return this;
    }

    public void checkSuccess() {
        Assertions.assertTrue(message.isDisplayed());
    }
}
