package exercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NestedFramesPage {
    private WebDriver driver;
    // create constructor to carry web driver object
    public NestedFramesPage(WebDriver driver){
        this.driver = driver;
    }

    WebDriverWait wait ;
    private By topFrame = By.xpath("//*[@name='frame-top']");
    private By bottomFrame = By.xpath("//*[@name='frame-bottom']");
    private By leftFrame = By.xpath("//*[@name='frame-left']");
    private By leftFrameText = By.tagName("body");
    private By bottomFrameText = By.tagName("body");


    public String getLeftFrameText(){
        switchToTopFrame();
        switchToLeftFrame();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(leftFrameText)));
        String text = driver.findElement(leftFrameText).getText();
        switchToMainArea();
        switchToMainArea();
        return text;
    }

    public String getBottomFrameText(){
        switchToBottomFrame();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(bottomFrameText)));
        String text = driver.findElement(bottomFrameText).getText();
        switchToMainArea();
        return text;
    }

    private void switchToTopFrame(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(topFrame));
    }
    private void switchToBottomFrame(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(bottomFrame));
    }
    private void switchToLeftFrame(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(leftFrame));
    }

    private void switchToMainArea(){
        driver.switchTo().parentFrame();
    }

}
