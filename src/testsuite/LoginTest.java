package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }


    public String getTextFromElement(By by){
        WebElement actualTextMessageElement = driver.findElement(by);
        return actualTextMessageElement.getText();
    }




    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        // Send Username to username field
        sendTextToElement(By.name("username"),"Admin");
        //Send password to password field
        sendTextToElement(By.name("password"),"admin123");
        // Click on login button using x-path
        clickOnElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']"));

        // Verify the text ‘Dashboard text’
        String expectedMessage = "Dashboard";
        // Storing message in to variable as String data type also used x-path to locate the element
        String actualMessage = getTextFromElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']"));

        // Validate actual and expected message
        Assert.assertEquals("No Dashboard text found",expectedMessage, actualMessage);


    }

    @After
    public void testDown(){
        closeBrowser();
    }

}