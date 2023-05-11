package exercise.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class BaseTests {
    private WebDriver driver;

    public void  setUp(){
        System.setProperty("webdriver.chrome.driver" , "resources/chromedriver.exe");
        driver = new ChromeDriver();

        // go to this url
        driver.get("https://the-internet.herokuapp.com/");

        // find only one element & click on it
        WebElement inputslink = driver.findElement(By.linkText("Shifting Content"));
        inputslink.click();


        WebElement firstlink = driver.findElement(By.xpath("//*[@id='content']/div/a[1]"));
        firstlink.click();

        // find list of elements & count them
        List<WebElement> tabs =driver.findElements(By.xpath("//*[@id='content']/div/ul/li"));
        System.out.println(tabs.size());



        //driver.quit();
    }

    public static void main (String args[]){
        exercise.base.BaseTests tests = new exercise.base.BaseTests();
        tests.setUp();
    }
}
