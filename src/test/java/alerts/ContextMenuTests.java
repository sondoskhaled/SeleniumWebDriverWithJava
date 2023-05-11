package alerts;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ContextMenuTests extends BaseTests {

    @Test
    public void rightClickTest(){
        var contextMenuPage = homePage.clickContextMenu();
        contextMenuPage.context_rightClick();
        String text = contextMenuPage.alert_getText();
        contextMenuPage.alert_clickOnConfirm();
        assertEquals(text,"You selected a context menu","alert text is incorrect");
    }
}
