package frames;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class NestedFramesTests extends BaseTests {

    @Test
    public void testFrameText (){
        var framesPage = homePage.clickFrames();
        var nestedFramesPage = framesPage.clickOnNestedFramesLink();
        assertEquals(nestedFramesPage.getLeftFrameText(),"LEFT","text is incorrect");
        assertEquals(nestedFramesPage.getBottomFrameText(),"BOTTOM","text is incorrect");
    }
}
