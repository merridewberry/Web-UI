package Lesson06;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public abstract class Driver {
    protected WebDriver driver;
    protected Actions builder;

    public Driver(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Driver(WebDriver driver, Actions builder) {
        this.builder = builder;
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
