package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class DropdownPage {
    private WebDriver driver;
    // create constructor to carry web driver object
    public DropdownPage(WebDriver driver){
        this.driver = driver;
    }
    private By dropdown = By.id("dropdown");


    public void selectFormDropdown(String option){
        findDropdownElement().selectByVisibleText(option);
    }

    public List<String> getSelectedOption(){
         List <WebElement> selectedElements = findDropdownElement().getAllSelectedOptions();
         return selectedElements.stream().map(e->e.getText()).collect(Collectors.toList());
    }
    private Select findDropdownElement(){
        return  new Select(driver.findElement(dropdown));
    }

    private void changeDropDownAttribute(){
        var jsExecutor = (JavascriptExecutor)driver;
        String script = "arguments[0].setAttribute('multiple', '')";
        jsExecutor.executeScript(script,findDropdownElement());
    }

    public List<String> selectTwoOptions (List<String> options){
        changeDropDownAttribute();
        for (String option:
             options) {
            findDropdownElement().selectByVisibleText(option);
        }
        return getSelectedOption();

    }
}
