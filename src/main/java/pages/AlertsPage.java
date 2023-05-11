package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsPage {
    WebDriver driver;
    // create constructor to carry web driver object
    public AlertsPage (WebDriver driver){
        this.driver = driver;
    }

    private  By triggerAlertButton = By.xpath("//button[text()='Click for JS Alert']");
    private  By triggerConfirmButton = By.xpath("//button[text()='Click for JS Confirm']");
    private  By triggerPromptButton = By.xpath("//button[text()='Click for JS Prompt']");


    public void triggerAlert(){
        driver.findElement(triggerAlertButton).click();
    }
    public void alert_clickToAccept(){
        driver.switchTo().alert().accept();
    }
    private By result = By.id("result");
    public String getResult(){
        return driver.findElement(result).getText();
    }

    public void triggerConfirm(){
        driver.findElement(triggerConfirmButton).click();
    }
    public void alert_clickToDismiss(){
        driver.switchTo().alert().dismiss();
    }
    public String alert_getText(){
        return driver.switchTo().alert().getText();
    }


    public void triggerPrompt(){
        driver.findElement(triggerPromptButton).click();
    }
    public void alert_setInput(String text){
        driver.switchTo().alert().sendKeys(text);
    }




}
