package pages;

import baseTest.baseClass;
import org.openqa.selenium.By;

public class logout extends baseClass {
    static String clickedProfile = "//*[@id='root']/div[2]/div/header/div/div/div[3]/div/div[2]/div";
    static String clickedOnLogout = "//*[@id='basic-menu']/div[3]/ul/li[2]/p";
    static String clickedConfirmLogout = "/html/body/div[2]/div[3]/div/div[2]/div[2]";


    public static void clickedOnTheProfileLink() throws InterruptedException {
        test.info("clicking on the profile link");
        findByXpath(clickedProfile).click();
        Thread.sleep(2000);
        test.pass("Clicked on the Profile Link");

    }

    public static void clickedOnTheLogoutOption() throws InterruptedException {
        test.info("Clicking on the logout button");
        findByXpath(clickedOnLogout).click();
        Thread.sleep(2000);
        test.pass("Clicked on the logout button");

    }

    public static void clickedOnConfirmLogout() {
        test.info("Confirming the user is logout");
        findByXpath(clickedConfirmLogout).click();
        test.pass("Confirmed to logout and pressed yes");

    }


}
