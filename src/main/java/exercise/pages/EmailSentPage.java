package exercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmailSentPage {
    private WebDriver driver;
    // create constructor to carry web driver object
    public EmailSentPage(WebDriver driver){
        this.driver = driver;
    }

    private By message = By.tagName("h1");
    public String getMessageText(){
        return driver.findElement(message).getText();
    }
}
