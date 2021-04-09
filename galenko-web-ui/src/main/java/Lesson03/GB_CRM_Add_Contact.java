package Lesson03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GB_CRM_Add_Contact {

    private static final String URL = "https://crm.geekbrains.space/";
    private static final String LAST_NAME = "Contactson";
    private static final String NAME = "Contie";
    private static final String COMPANY_NAME = "1234";
    private static final String JOB = "Contact";
    private static WebDriver driver = Lesson03.driver;

    public static void addContact() {
        driver.get(URL);

        driver.findElement(By.xpath(
                ".//li[@class='dropdown first']/a/span[text()='Контрагенты']")).click();
        driver.findElement(By.xpath(".//span[@class='title' and text()='Контактные лица']")).click();
        driver.findElement(By.xpath(".//a[text()='Создать контактное лицо']")).click();

        driver.findElement(By.name("crm_contact[lastName]")).sendKeys(LAST_NAME);
        driver.findElement(By.name("crm_contact[firstName]")).sendKeys(NAME);

        driver.findElement(By.xpath(".//span[text()='Укажите организацию']")).click();
        driver.findElement(By.xpath(".//input[@class='select2-input select2-focused']")).sendKeys(COMPANY_NAME);
        driver.findElement(By.xpath(".//span[@class='select2-match' and text()='" + COMPANY_NAME + "']")).click();

        driver.findElement(By.name("crm_contact[jobTitle]")).sendKeys(JOB);

        driver.findElement(By.xpath(".//button[@class='btn btn-success action-button']")).click();
    }
}
