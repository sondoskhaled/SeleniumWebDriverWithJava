package exercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class ContextMenuPage {
    private WebDriver driver;
    // create constructor to carry web driver object
    public ContextMenuPage(WebDriver driver){
        this.driver = driver;
    }

    private By context = By.id("hot-spot");

    public void context_rightClick ()
    {
        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement(context)).perform();
    }

    public String alert_getText(){
        return driver.switchTo().alert().getText();
    }

    public void alert_clickOnConfirm(){
        driver.switchTo().alert().accept();
    }
}
