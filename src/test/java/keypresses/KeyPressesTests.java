package keypresses;

import base.BaseTests;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class KeyPressesTests extends BaseTests {
    @Test
    public void testBackSpace (){
        var keyPressesPage = homePage.clickKeyPresses();
        String text = "A" + Keys.BACK_SPACE ;
        keyPressesPage.enterText(text);
        assertEquals(keyPressesPage.getResult() , ".You entered: BACK_SPACE" , "something went wrong" );
    }
    @Test
    public void testPi(){
        var keyPressesPage = homePage.clickKeyPresses();
        keyPressesPage.enterPi();

    }
}
