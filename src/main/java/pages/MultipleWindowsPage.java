package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MultipleWindowsPage {
    private WebDriver driver;
    public MultipleWindowsPage (WebDriver driver){
        this.driver = driver;}

    private By clickHereLink = By.xpath("//*[@id='content']/div/a");
    public void clickHere (){
        driver.findElement(clickHereLink).click();
    }
}
