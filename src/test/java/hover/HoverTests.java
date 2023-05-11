package hover;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class HoverTests extends BaseTests {
    @Test
    public void testHoverUser1 (){
        var hoverPage = homePage.clickHovers();
        var caption = hoverPage.hoverOverFigure(1);
        assertTrue(caption.isCaptionDisplayed(),"caption isn't displayed");
        assertEquals(caption.getTitle(),"name: user1" , "caption title is incorrect");
        assertEquals(caption.getLinkText(),"View profile" , "caption link text is incorrect");
        assertTrue(caption.getLink().endsWith("/users/1"),"link is incorrect");

    }
}
