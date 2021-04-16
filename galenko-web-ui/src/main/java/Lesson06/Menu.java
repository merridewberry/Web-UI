package Lesson06;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Menu extends Driver {

    @FindBy (xpath = ".//li[@class='dropdown first']/a/span[text()='Контрагенты']")
    WebElement contractors;

    @FindBy (xpath = ".//span[@class='title' and text()='Контактные лица']")
    WebElement contacts;

    @FindBy (xpath = ".//li[@class='dropdown']/a/span[text()='Проекты']")
    WebElement projects;

    @FindBy (xpath = ".//span[@class='title' and text()='Мои проекты']")
    WebElement myProjects;

    public Menu(WebDriver driver, Actions builder){
        super(driver, builder);
    }

    public CreateNewContact clickContacts () {
        builder
                .moveToElement(contractors)
                .click(contacts)
                .build()
                .perform();
        return new CreateNewContact(driver);
    }

    public CreateNewProject clickMyProjects() {
        builder
                .moveToElement(projects)
                .click(myProjects)
                .build()
                .perform();
        return new CreateNewProject(driver);
    }

}
