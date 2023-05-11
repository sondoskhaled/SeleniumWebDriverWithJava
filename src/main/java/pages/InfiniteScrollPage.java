package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class InfiniteScrollPage {
    private WebDriver driver;
    // create constructor to carry web driver object
    public InfiniteScrollPage(WebDriver driver){
        this.driver = driver;
    }

    By textBlocks = By.className("jscroll-added");

    /**
     * scroll until paragraph with index specified is in view
     * @param index is 1-based
     */

    public void scrollToParagraph(int index) {
        String script = "window.scrollTo(0, document.body.scrollHeight)";
        var jsExecutor = (JavascriptExecutor)driver;
        while (getNumberOfParagraphPresent() < index){
            jsExecutor.executeScript(script);
        }
    }

    private int getNumberOfParagraphPresent(){
        return driver.findElements(textBlocks).size();
    }


}
