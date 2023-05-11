package horizontalslider;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class HorizontalSliderTests extends BaseTests {
    @Test
    public void slideToRight (){
        var horizontalSliderPage = homePage.clickHorizontalSlider();
        horizontalSliderPage.slide("4");
        assertEquals(horizontalSliderPage.getValue() , "4" , "something went wrong");
    }
}
