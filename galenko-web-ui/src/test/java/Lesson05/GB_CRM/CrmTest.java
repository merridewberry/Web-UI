package Lesson05.GB_CRM;

import Lesson05.Lesson05;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CrmTest {

    private static final String LOGIN_URL = "https://crm.geekbrains.space/user/login";
    private static final String URL = "https://crm.geekbrains.space/";
    private static final String LOGIN = "Applanatest1";
    private static final String PASSWORD = "Student2020!";
    private static final String CONT_LAST_NAME = "Contactson";
    private static final String CONT_NAME = "Contie";
    private static final String CONT_COMPANY_NAME = "1234";
    private static final String CONT_JOB = "Contact";
    private static final String PR_NAME = Lesson05.randomizedProjectName;
    private static final String PR_COMPANY_NAME = "1234";
    private static final String PR_CONTACT = "A B";

    private static WebDriver driver = Lesson05.driver;
    private static Actions builder = Lesson05.builder;

    @AfterAll
    public static void quit(){
        driver.quit();
    }

    @Test
    public void loginTest() {
        driver.get(LOGIN_URL);
        driver.findElement(By.cssSelector("input[name='_username']")).sendKeys(LOGIN);
        driver.findElement(By.cssSelector("input[name='_password']")).sendKeys(PASSWORD);
        driver.findElement(By.cssSelector("button[name='_submit']")).click();
        Assertions.assertTrue(driver.findElement(By.xpath(".//ul[@class='nav nav-multilevel main-menu']")).isDisplayed());
    }

    @Test
    public void addContactTest(){
        driver.get(URL);

        WebElement contractors = driver.findElement(By.xpath(
                ".//li[@class='dropdown first']/a/span[text()='Контрагенты']"));
        WebElement contacts = driver.findElement(By.xpath(".//span[@class='title' and text()='Контактные лица']"));
        builder
                .moveToElement(contractors)
                .click(contacts)
                .build()
                .perform();

        driver.findElement(By.xpath(".//a[text()='Создать контактное лицо']")).click();

        driver.findElement(By.name("crm_contact[lastName]")).sendKeys(CONT_LAST_NAME);
        driver.findElement(By.name("crm_contact[firstName]")).sendKeys(CONT_NAME);

        driver.findElement(By.xpath(".//span[text()='Укажите организацию']")).click();
        driver.findElement(By.xpath(".//input[@class='select2-input select2-focused']")).sendKeys(CONT_COMPANY_NAME);
        driver.findElement(By.xpath(".//span[@class='select2-match' and text()='" + CONT_COMPANY_NAME + "']")).click();

        driver.findElement(By.name("crm_contact[jobTitle]")).sendKeys(CONT_JOB);

        driver.findElement(By.xpath(".//button[@class='btn btn-success action-button']")).click();

        Assertions.assertTrue(driver.findElement(By.xpath(
                ".//div[@class='message' and text()='Контактное лицо сохранено']")).isDisplayed());
    }

    @Test
    public void addProjectTest() {
        driver.get(URL);

        WebElement projects = driver.findElement(By.xpath(".//li[@class='dropdown']/a/span[text()='Проекты']"));
        WebElement myProjects = driver.findElement(By.xpath(".//span[@class='title' and text()='Мои проекты']"));
        builder
                .moveToElement(projects)
                .click(myProjects)
                .build()
                .perform();

        driver.findElement(By.xpath(".//a[text()='Создать проект']")).click();

        driver.findElement(By.name("crm_project[name]")).sendKeys(PR_NAME);

        driver.findElement(By.xpath(".//span[text()='Укажите организацию']")).click();
        driver.findElement(By.xpath(".//input[@class='select2-input select2-focused']")).sendKeys(PR_COMPANY_NAME);
        driver.findElement(By.xpath(".//span[@class='select2-match' and text()='" + PR_COMPANY_NAME + "']")).click();

        driver.findElement(By.xpath(".//div[@class='controls']/div[@class='select2-container select2']/a")).click();
        driver.findElements(By.xpath(".//div[@class='select2-search']/input")).get(1).sendKeys(PR_CONTACT);
        driver.findElement(By.xpath(".//span[@class='select2-match' and text()='" + PR_CONTACT + "']")).click();

        Select businessUnit = new Select(driver.findElement(By.name("crm_project[businessUnit]")));
        businessUnit.selectByValue("1");

        Select curator = new Select(driver.findElement(By.name("crm_project[curator]")));
        curator.selectByVisibleText("Applanatest Applanatest Applanatest");

        Select projectLead = new Select(driver.findElement(By.name("crm_project[rp]")));
        projectLead.selectByVisibleText("Applanatest Applanatest Applanatest");

        Select administrator = new Select(driver.findElement(By.name("crm_project[administrator]")));
        administrator.selectByVisibleText("Applanatest Applanatest Applanatest");

        Select manager = new Select(driver.findElement(By.name("crm_project[manager]")));
        manager.selectByVisibleText("Applanatest Applanatest Applanatest");

        driver.findElement(By.xpath(".//button[@class='btn btn-success action-button']")).click();

        Assertions.assertTrue(driver.findElement(By.xpath(
                ".//div[@class='message' and text()='Проект сохранен']")).isDisplayed());
    }
}
