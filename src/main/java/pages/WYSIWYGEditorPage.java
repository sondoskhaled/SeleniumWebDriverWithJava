package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WYSIWYGEditorPage {
    private WebDriver driver;
    // create constructor to carry web driver object
    public WYSIWYGEditorPage(WebDriver driver){
        this.driver = driver;
    }

    private String editorIframeId = "mce_0_ifr";
    private By textArea = By.id("tinymce");
    private By decreaseIndentButton = By.xpath("//*[@aria-label='Increase indent']");
    WebDriverWait wait ;

    public void clearTextArea(){
        switchToEditorArea();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(textArea)));
        driver.findElement(textArea).clear();
        switchToMainArea();
    }



    public void setTextArea(String text){
        switchToEditorArea();
        driver.findElement(textArea).sendKeys(text);
        switchToMainArea();
    }

    public String getTextFromEditor (){
        switchToEditorArea();
        String text = driver.findElement(textArea).getText();
        switchToMainArea();
        return text;
    }

    public void decreaseIndention (){
        driver.findElement(decreaseIndentButton).click();
    }

    private void switchToEditorArea(){
       // driver.switchTo().frame(editorIframeId);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(editorIframeId));
    }

    private void switchToMainArea(){
        driver.switchTo().parentFrame();
    }
}
