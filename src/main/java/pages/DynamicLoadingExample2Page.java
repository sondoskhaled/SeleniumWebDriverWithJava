package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicLoadingExample2Page {
    private WebDriver driver;
    // create constructor to carry web driver object
    public DynamicLoadingExample2Page(WebDriver driver){
        this.driver = driver;
    }

    private By startButton = By.xpath("//button[text() = 'Start']");

    public boolean checkStartButton (){
        return driver.findElement(startButton).isDisplayed();
    }


}
