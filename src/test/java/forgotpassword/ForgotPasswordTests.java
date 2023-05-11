package forgotpassword;

import base.BaseTests;
import exercise.pages.EmailSentPage;
import exercise.pages.ForgotPasswordPage;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ForgotPasswordTests extends BaseTests {
    @Test
    public void testRetrievePassword(){
        ForgotPasswordPage forgotPasswordPage = homePage.clickForgotPassword();
        forgotPasswordPage.setEmail("tau@example.com");
        EmailSentPage emailSentPage = forgotPasswordPage.ClickOnRetrievePasswordButton();
        assertEquals(emailSentPage.getMessageText(),"Your e-mail's been sent!" , " message isn't correct");

    }
}
