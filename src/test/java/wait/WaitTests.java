package wait;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class WaitTests extends BaseTests {
    @Test
    public void testWaitUntilHidden(){
        var loadingPage = homePage.clickDynamicLoading().clickExample1();
        loadingPage.clickStart();
        assertEquals(loadingPage.getLoadedText(),"Hello World!" ,"loaded text is incorrect");
    }

    @Test
    public void testWaitUntilAppear(){
        var loadingPage = homePage.clickDynamicLoading().clickExample1();
        loadingPage.clickStart2();
        assertEquals(loadingPage.getLoadedText2(),"Hello World!" ,"loaded text is incorrect");
    }

}
