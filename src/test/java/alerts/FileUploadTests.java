package alerts;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FileUploadTests extends BaseTests {
    @Test
    public void testFileUpload(){
        var fileUploadPage = homePage.clickFileUpload();
        fileUploadPage.uploadFile("C:\\Users\\sondos khaled\\Downloads\\flowers.png");
        assertEquals(fileUploadPage.getUploadedFile(),"flowers.png" ,"file name is incorrect");
    }
}
