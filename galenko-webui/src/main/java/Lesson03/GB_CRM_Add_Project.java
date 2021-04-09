package Lesson03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class GB_CRM_Add_Project {

    private static final String URL = "https://crm.geekbrains.space/";
    private static final String NAME = "1234";
    private static final String COMPANY_NAME = "1234";
    private static final String CONTACT = "A B";
    private static WebDriver driver = Lesson03.driver;

    public static void addProject() {
        driver.get(URL);

        driver.findElement(By.xpath(
                ".//li[@class='dropdown']/a/span[text()='Проекты']")).click();
        driver.findElement(By.xpath(".//span[@class='title' and text()='Мои проекты']")).click();
        driver.findElement(By.xpath(".//a[text()='Создать проект']")).click();

        driver.findElement(By.name("crm_project[name]")).sendKeys(NAME);

        driver.findElement(By.xpath(".//span[text()='Укажите организацию']")).click();
        driver.findElement(By.xpath(".//input[@class='select2-input select2-focused']")).sendKeys(COMPANY_NAME);
        driver.findElement(By.xpath(".//span[@class='select2-match' and text()='" + COMPANY_NAME + "']")).click();

        driver.findElement(By.xpath(".//div[@class='controls']/div[@class='select2-container select2']/a")).click();
        driver.findElements(By.xpath(".//div[@class='select2-search']/input")).get(1).sendKeys(CONTACT);
        driver.findElement(By.xpath(".//span[@class='select2-match' and text()='" + CONTACT + "']")).click();

        Select businessUnit = new Select(driver.findElement(By.name("crm_project[businessUnit]")));
        businessUnit.selectByValue("1");

        Select curator = new Select(driver.findElement(By.name("crm_project[curator]")));
        curator.selectByVisibleText("Applanatest Applanatest Applanatest");

        Select projectLead = new Select(driver.findElement(By.name("crm_project[rp]")));
        projectLead.selectByVisibleText("Applanatest Applanatest Applanatest");

        Select administrator = new Select(driver.findElement(By.name("crm_project[administrator]")));
        administrator.selectByVisibleText("Гикбрейнс Студент");

        Select manager = new Select(driver.findElement(By.name("crm_project[manager]")));
        manager.selectByVisibleText("Гикбрейнс Студент");

        driver.findElement(By.xpath(".//button[@class='btn btn-success action-button']")).click();
    }

}
