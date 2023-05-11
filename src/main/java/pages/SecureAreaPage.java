package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage {
    private WebDriver driver;
    // create constructor to carry web driver object
    public SecureAreaPage(WebDriver driver){
        this.driver = driver;
    }
    // find alert and get text
    private By statusAlert = By.id("flash");
    public String getAlertText(){
        return  driver.findElement(statusAlert).getText();

    }
}
