package testCases;

import baseTest.baseClass;
import org.testng.Assert;
import pages.loginPage;
import org.testng.annotations.Test;
import utility.ConfigReader;

public class TC01_loginUser extends baseClass {
    loginPage login = new loginPage();
    String expectedNoEmailErrorMessage = "Email is required";


    @Test    // Verify login functions with valid credentials
    public void verifyLoginWithValidCred() throws InterruptedException {
        loginPage.loginUser(url, username, password);

        String getActualText = login.getGettext();
        System.out.println("User logged in Successfully");
        Assert.assertEquals("Provider Groups", getActualText);

    }

    @Test
    public void verifyWithNoEmailExist() throws InterruptedException {
        username = "yogesh.jadhav+superadmin2abcsdfsd@thinkitive.com";

        loginPage.loginUser(url, username, password);
        String actualMessage = loginPage.getErrorMessage();

        String expectedMessage = "Cannot find user with emailId " + username;
        //  System.out.println(actualMessage);
        Assert.assertEquals(actualMessage, expectedMessage);

    }


    @Test
    public void verifyWithNoEmail() throws InterruptedException {
        username = "";

        loginPage.loginUser(url, username, password);
        String actualMessage = login.NoEmailMessage();

        // System.out.println(actualMessage);
        Assert.assertEquals(actualMessage, expectedNoEmailErrorMessage);
    }

    @Test
    public void verifyWithEmptyFields() throws InterruptedException {
        username ="";
        password="";
        loginPage.loginUser(url,username,password);

        String actualMessage = login.NoEmailMessage();
       // System.out.println(actualMessage);
        Assert.assertEquals(actualMessage, expectedNoEmailErrorMessage);

        String actualNoPasswordMessage = login.NoPasswordMessage();
        String expectedNoPasswordMessage = "Password is required";
        //System.out.println(actualMessage);
        Assert.assertEquals(actualNoPasswordMessage, expectedNoPasswordMessage);
    }


}