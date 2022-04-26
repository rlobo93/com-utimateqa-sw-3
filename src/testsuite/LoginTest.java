package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utility.Utility;

public class LoginTest extends Utility {

    String BaseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp(){
        openBrowser(BaseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully(){

        //locate ‘Sign In’ link and click on it
      clickOnElement(By.xpath("//header/div[1]/div[1]/section[1]/ul[1]/li[1]/a[1]"));

        // Verify the text ‘Welcome Back!’
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Welcome Back!')]"),"Welcome Back!");

    }

    @Test
    public void verifyTheErrorMessage(){

        //locate ‘Sign In’ link and click on it
        clickOnElement(By.xpath("//header/div[1]/div[1]/section[1]/ul[1]/li[1]/a[1]"));

        // Enter invalid username
        sendTextToElement(By.id("user[email]"),"rlobo@gmail.co.uk");

        // /Enter invalid password
        sendTextToElement(By.id("user[password]"),"rlobo123?");

        // Click on Login button
        clickOnElement(By.xpath("//body/main[@id='main-content']/div[1]/div[1]/article[1]/form[1]/div[4]/input[1]"));

        // Verify the error message ‘Invalid email or password.’
        verifyExpectedAndActual(By.xpath("//li[contains(text(),'Invalid email or password.')]"),"Invalid email or password.");

    }


    @After
    public void tearDown(){
        closeBrowser();
    }




}
