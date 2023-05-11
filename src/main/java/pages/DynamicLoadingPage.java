package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import utils.WindowManager;

public class DynamicLoadingPage {
    private WebDriver driver;
    // create constructor to carry web driver object
    public DynamicLoadingPage(WebDriver driver){
        this.driver = driver;
    }

    private String linkXpath_Format = ".//a[contains(text(), '%s')]";
    private By link_Example1 = By.xpath(String.format(linkXpath_Format,"Example 1"));
    private By link_Example2 = By.xpath(String.format(linkXpath_Format,"Example 2"));

    public DynamicLoadingExample1Page clickExample1(){
        driver.findElement(link_Example1).click();
        return new DynamicLoadingExample1Page(driver);
    }

    public DynamicLoadingExample2Page openExample2InNewTab(){
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).click(driver.findElement(link_Example2)).keyUp(Keys.CONTROL).perform();
        return new DynamicLoadingExample2Page(driver);
    }
}
