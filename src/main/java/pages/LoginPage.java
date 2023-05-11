package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    // create constructor to carry web driver object
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    // find username field then enter the username in it
    private By usernameField = By.id("username");
    public void setUsername (String username){
        driver.findElement(usernameField).sendKeys(username);
    }
    // find password field enter the password in it
    private By passwordField = By.id("password");
    public void setPassword (String password){
        driver.findElement(passwordField).sendKeys(password);
    }
    // find login button then click on it
    private By loginButton = By.cssSelector("#login button");
    public SecureAreaPage clickLoginButton (){
        driver.findElement(loginButton).click();
        return new SecureAreaPage(driver);
    }
}
