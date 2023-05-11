package exercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HorizontalSliderPage {
    private WebDriver driver;
    // create constructor to carry web driver object
    public HorizontalSliderPage (WebDriver driver){
        this.driver=driver;
    }

    private By slider = By.xpath("//*[@id='content']/div/div/input");
    private By value = By.id("range");
    public void slide (String num){
        String count = driver.findElement(value).getText();
        while ( ! count.equals(num) ){
        driver.findElement(slider).sendKeys(Keys.ARROW_RIGHT);
        count = driver.findElement(value).getText(); }


    }

    public String getValue (){
        return driver.findElement(value).getText();

    }
}
