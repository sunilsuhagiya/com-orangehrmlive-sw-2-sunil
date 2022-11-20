package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class ForgotPasswordTest extends Utility {
    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToForgotPasswordPageSuccessfully(){
        //click on the ‘Forgot your password’ link
        clickOnElement(By.xpath("//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']"));
        // Verify the text ‘Reset Password ’
        String expectedMessage = "Reset Password";
        // Storing message in to variable as String data type also used x-path to locate the element
        String actualMessage = getTextFromElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 orangehrm-forgot-password-title']"));

        // Validate actual and expected message
        Assert.assertEquals("No Reset Password text found",expectedMessage, actualMessage);
    }


    @After
    public void testDown(){
        closeBrowser();
    }
}
