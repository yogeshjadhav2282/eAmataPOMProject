package testCases;

import baseTest.baseClass;
import org.testng.annotations.Test;
import pages.loginPage;
import pages.logout;
import utility.ConfigReader;

import static baseTest.baseClass.test;

public class TC02_logout extends baseClass{

    @Test
    public void logoutUser() throws InterruptedException {
        loginPage.loginUser(url, username,password);

        logout.clickedOnTheProfileLink();
        logout.clickedOnTheLogoutOption();
        logout.clickedOnConfirmLogout();


    }
}

