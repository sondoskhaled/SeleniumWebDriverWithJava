package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicLoadingExample1Page {
    private WebDriver driver;
    // create constructor to carry web driver object
    public DynamicLoadingExample1Page(WebDriver driver){
        this.driver = driver;
    }

    private By startButton = By.xpath("//button[text() = 'Start']");
    private By loadingIndicator = By.xpath("//div[@id = 'loading']");
    private By loadedText = By.xpath("//div[@id = 'finish']");


    public void clickStart(){
        driver.findElement(startButton).click();
        // 27 & 28 line do the same thing
          WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(5));
//        FluentWait wait = new FluentWait(driver)
//                .withTimeout(Duration.ofSeconds(5))
//                .pollingEvery(Duration.ofSeconds(1))
//                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(loadingIndicator)));
    }

    public String getLoadedText(){
        return driver.findElement(loadedText).getText();

    }

    public void clickStart2(){
        driver.findElement(startButton).click();
    }

    public String getLoadedText2(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(loadedText)));
        return driver.findElement(loadedText).getText();

    }
}
