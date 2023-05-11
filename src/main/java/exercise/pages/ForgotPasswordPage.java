package exercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage  {
    private WebDriver driver;
    // create constructor to carry web driver object
    public ForgotPasswordPage(WebDriver driver){
        this.driver = driver;
    }

    private By emailField = By.id("email");
    public void setEmail(String email){
        driver.findElement(emailField).sendKeys(email);
    }

    private By retrievePasswordButton = By.id("form_submit");
    public EmailSentPage ClickOnRetrievePasswordButton(){
        driver.findElement(retrievePasswordButton).click();
        return new EmailSentPage(driver);

    }
}
