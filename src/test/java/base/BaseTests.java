package base;

import com.google.common.io.Files;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;
import utils.EventReporter;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class BaseTests {
    //private WebDriver driver;
    private EventFiringWebDriver driver;
    protected HomePage homePage;
    @BeforeClass
    public void  setUp(){
        System.setProperty("webdriver.chrome.driver" , "resources/chromedriver.exe");
        //driver =new ChromeDriver();
        driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));

        driver.register(new EventReporter());
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        goHome();
        //setCookie();

        homePage = new HomePage(driver);
        // maximize the window
        // driver.manage().window().maximize();

        // full screen
        //driver.manage().window().fullscreen();

        // set size
        //driver.manage().window().setSize(new Dimension(375,812));

        // find list of elements & count them
//        List<WebElement> links =driver.findElements(By.tagName("a"));
//        System.out.println(links.size());

        // find only one element & click on it
//        WebElement inputslink = driver.findElement(By.linkText("Inputs"));
//        inputslink.click();
//
//        System.out.println(driver.getTitle());

    }
    @BeforeMethod
    public void goHome(){
        // go to this url
        driver.get("https://the-internet.herokuapp.com/");
    }
    @AfterClass
    public  void tearDown(){
        driver.quit();
    }

//    @AfterMethod
//    public void takeScreenshot (){
//        var camera = (TakesScreenshot)driver;
//        File screenshot = camera.getScreenshotAs(OutputType.FILE);
//        try {
//            Files.move(screenshot, new File("resources/screenshots/test.png"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println("path" + screenshot.getAbsolutePath());
//    }

    @AfterMethod
    public void recordFailure (ITestResult result){
        if(ITestResult.FAILURE == result.getStatus()){
            var camera = (TakesScreenshot)driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot, new File("resources/screenshots/" + result.getName() + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public WindowManager getWindowManager() {
        return new WindowManager(driver);
    }

    private ChromeOptions getChromeOptions (){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("disable-infobars");
        /**
         * tests is done without opening the browser
         * chromeOptions.setHeadless(true);
          */
        return chromeOptions;
    }

    private void setCookie(){
        Cookie cookie = new Cookie.Builder("tau" , "123")
                .domain("the-internet.herokuapp.com")
                .build();
        driver.manage().addCookie(cookie);
    }

    private void deleteCookie(){
        driver.manage().deleteCookieNamed("optimizelyPendingLogEvents");
    }

    private Cookie checkCookie(){
        return driver.manage().getCookieNamed("optimizelyPendingLogEvents");
    }

    @Test
    public void testDeleteCookie(){
        deleteCookie();
        assertEquals(checkCookie() , null , "wrong");
    }

// no more needing because we user testng annotaion
//    public static void main (String args[]){
//        BaseTests tests = new BaseTests();
//        tests.setUp();
//    }
}
