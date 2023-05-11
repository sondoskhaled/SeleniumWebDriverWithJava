package utils;

import org.openqa.selenium.WebDriver;
import pages.DynamicLoadingExample2Page;

public class WindowManager {
    private WebDriver driver;
    private WebDriver.Navigation navigate;
    public WindowManager (WebDriver driver){
        this.driver = driver;
        navigate = driver.navigate();
    }

    public void goBack (){
        navigate.back();
    }

    public void goForward (){
        navigate.forward();
    }

    public void refreshPage (){
        navigate.refresh();
    }

    public void goTo (String url){
        navigate.to(url);
    }

    public void switchToTab(String tabTitle){
        var windows = driver.getWindowHandles();

        System.out.println("Number of tabs: " + windows.size());
        System.out.println("Window handles:");
        windows.forEach(System.out::println);

        for (String window:
             windows) {
            System.out.println("switching to window: " + window);
            driver.switchTo().window(window);
            System.out.println("Current window title: " + driver.getTitle());

            if(tabTitle.equals(driver.getTitle())){
                break;
            }
        }

    }

    public void switchToNextTab(){
        var windows = driver.getWindowHandles();
        var currentWindow = driver.getWindowHandle();

        for (String window:windows) {
            driver.switchTo().window(window);
            if(!(window.equals(currentWindow))){break;}
        }
    }
}
