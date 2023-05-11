package frames;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FrameTests extends BaseTests {

    @Test
    public void testWysiwyg(){
        var wysiwygEditorPage = homePage.clickWYSIWYGEditor();
        wysiwygEditorPage.clearTextArea();
        String text1 = "hello" ;
        String text2 = " world" ;
        wysiwygEditorPage.setTextArea(text1);
        wysiwygEditorPage.decreaseIndention();
        wysiwygEditorPage.setTextArea(text2);
        assertEquals(wysiwygEditorPage.getTextFromEditor(), text1+text2 , "text is incorrect");
        }

}
