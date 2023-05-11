package exercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FramesPage {
    private WebDriver driver;
    // create constructor to carry web driver object
    public FramesPage(WebDriver driver){
        this.driver = driver;
    }

    private By nestedFramesLink = By.xpath("//*[@href='/nested_frames']");

    public NestedFramesPage clickOnNestedFramesLink(){
        driver.findElement(nestedFramesLink).click();
        return new NestedFramesPage(driver);
    }
}
