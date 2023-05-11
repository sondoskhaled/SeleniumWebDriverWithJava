package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadPage {
    WebDriver driver;
    // create constructor to carry web driver object
    public FileUploadPage(WebDriver driver){
        this.driver = driver;
    }

    private By inputField = By.id("file-upload");
    private By uploadButton = By.id("file-submit");
    private By uploadedFile = By.id("uploaded-files");

    public void clickUploadButton (){
        driver.findElement(uploadButton).click();
    }

    /**
     *
     * @param absolutePathOfFile provide the complete path of the file to upload
     * */

    public void uploadFile (String absolutePathOfFile){
        driver.findElement(inputField).sendKeys(absolutePathOfFile);
        clickUploadButton();
    }

    public String getUploadedFile (){
        return driver.findElement(uploadedFile).getText();

    }
}
