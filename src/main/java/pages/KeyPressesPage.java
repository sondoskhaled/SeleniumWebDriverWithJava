package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class KeyPressesPage {
    private WebDriver driver;
    // create constructor to carry web driver object
    public KeyPressesPage(WebDriver driver){
        this.driver = driver;
    }

    private By inputField = By.id("target");

    public void enterText (String text){
        driver.findElement(inputField).sendKeys(text);
    }

    public void enterPi(){
        enterText(Keys.chord(Keys.SHIFT , "\u03C0") + " = 3.14");
    }

    private By result = By.id("result");
    public String getResult (){
        return driver.findElement(result).getText();
    }
}
